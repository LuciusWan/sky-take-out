package com.sky.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import com.sky.constant.MessageConstant;
import com.sky.context.BaseContext;
import com.sky.dto.*;
import com.sky.entity.*;
import com.sky.exception.AddressBookBusinessException;
import com.sky.exception.OrderBusinessException;
import com.sky.mapper.*;
import com.sky.result.PageResult;
import com.sky.service.OrderService;
import com.sky.vo.*;
import com.sky.websocket.WebSocketServer;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private AddressBookMapper addressBookMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private WebSocketServer webSocketServer;
    @Override
    public OrderSubmitVO submit(OrdersSubmitDTO ordersSubmitDTO) {
        //异常处理
        AddressBook addressBook=addressBookMapper.selectById(ordersSubmitDTO.getAddressBookId());
        if(addressBook==null){
            throw new AddressBookBusinessException(MessageConstant.ADDRESS_BOOK_IS_NULL);
        }
        ShoppingCart shoppingCart=new ShoppingCart();
        shoppingCart.setUserId(BaseContext.getCurrentId());
        shoppingCart.setId(ordersSubmitDTO.getAddressBookId());
        List<ShoppingCart> shoppingCartList=shoppingCartMapper.select(shoppingCart);
        if(shoppingCartList.size()==0||shoppingCartList==null){
            throw new AddressBookBusinessException(MessageConstant.SHOPPING_CART_IS_NULL);
        }
        Orders orders=new Orders();
        BeanUtils.copyProperties(ordersSubmitDTO,orders);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime estimatedDeliveryTime = orders.getEstimatedDeliveryTime();

        // 计算时间差
        Duration duration = Duration.between(now, estimatedDeliveryTime);
        System.out.println(duration);
        System.out.println(now);
        System.out.println(estimatedDeliveryTime);
        // 检查时间差是否正好是一小时
        if (duration.toHours() <= 1.1) {
            orders.setDeliveryStatus(1);
        } else {
            orders.setDeliveryStatus(0);
        }
        orders.setOrderTime(LocalDateTime.now());
        orders.setStatus(Orders.PENDING_PAYMENT);
        orders.setPayStatus(Orders.UN_PAID);
        orders.setNumber(String.valueOf(System.currentTimeMillis()));
        orders.setPhone(addressBook.getPhone());
        orders.setUserId(BaseContext.getCurrentId());
        orders.setConsignee(addressBook.getConsignee());
        //向订单表中插入1条数据
        orderMapper.insert(orders);
        //向订单明细表中插入多条数据
        List<OrderDetail> list=new ArrayList<>();
        for (ShoppingCart cart : shoppingCartList) {
            OrderDetail orderDetail=new OrderDetail();
            BeanUtils.copyProperties(cart,orderDetail);
            orderDetail.setOrderId(orders.getId());
            list.add(orderDetail);
        }
        System.out.println(list);
        orderDetailMapper.insert(list);
        shoppingCartMapper.deleteAll(orders.getUserId());
        OrderSubmitVO orderSubmitVO=new OrderSubmitVO();
        orderSubmitVO.setOrderTime(orders.getOrderTime());
        orderSubmitVO.setOrderNumber(orders.getNumber());
        orderSubmitVO.setId(orders.getId());
        orderSubmitVO.setOrderAmount(orders.getAmount());
        return orderSubmitVO;
    }

    @Override
    public PageResult pageResult(int pageNum, int pageSize, Integer status) {
        // 设置分页
        PageHelper.startPage(pageNum, pageSize);

        OrdersPageQueryDTO ordersPageQueryDTO = new OrdersPageQueryDTO();
        ordersPageQueryDTO.setUserId(BaseContext.getCurrentId());
        ordersPageQueryDTO.setStatus(status);

        // 分页条件查询
        Page<Orders> page = orderMapper.pageQuery(ordersPageQueryDTO);

        List<OrderVO> list = new ArrayList();

        // 查询出订单明细，并封装入OrderVO进行响应
        if (page != null && page.getTotal() > 0) {
            for (Orders orders : page) {
                Long orderId = orders.getId();// 订单id

                // 查询订单明细
                List<OrderDetail> orderDetails = orderDetailMapper.selectById(orderId);

                OrderVO orderVO = new OrderVO();
                BeanUtils.copyProperties(orders, orderVO);
                orderVO.setOrderDetailList(orderDetails);

                list.add(orderVO);
            }
        }
        return new PageResult(page.getTotal(), list);
    }

    @Override
    public OrderVO checkOrder(Long id) {
        // 根据id查询订单
        Orders orders = orderMapper.checkOrder(id);
        AddressBook addressBook=addressBookMapper.selectById(orders.getAddressBookId());
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(addressBook.getProvinceName());
        stringBuilder.append(addressBook.getCityName());
        stringBuilder.append(addressBook.getDistrictName());
        stringBuilder.append(addressBook.getDetail());
        String address=stringBuilder.toString();
        orders.setAddress(address);
        // 查询该订单对应的菜品/套餐明细
        List<OrderDetail> orderDetailList = orderDetailMapper.selectById(orders.getId());

        // 将该订单及其详情封装到OrderVO并返回
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(orders, orderVO);
        orderVO.setOrderDetailList(orderDetailList);

        return orderVO;
    }

    @Override
    public void cancel(Long id) {
        // 根据id查询订单
        Orders ordersDB = orderMapper.checkOrder(id);

        // 校验订单是否存在
        if (ordersDB == null) {
            throw new OrderBusinessException(MessageConstant.ORDER_NOT_FOUND);
        }

        //订单状态 1待付款 2待接单 3已接单 4派送中 5已完成 6已取消
        if (ordersDB.getStatus() > 2) {
            throw new OrderBusinessException(MessageConstant.ORDER_STATUS_ERROR);
        }

        Orders orders = new Orders();
        orders.setId(ordersDB.getId());

        // 订单处于待接单状态下取消，需要进行退款
        if (ordersDB.getStatus().equals(Orders.TO_BE_CONFIRMED)) {
            //调用微信支付退款接口
            //省略
            //支付状态修改为 退款
            orders.setPayStatus(Orders.REFUND);
        }

        // 更新订单状态、取消原因、取消时间
        orders.setStatus(Orders.CANCELLED);
        orders.setCancelReason("用户取消");
        orders.setCancelTime(LocalDateTime.now());
        orderMapper.update(orders);
    }

    @Override
    @Transactional
    public void repetition(Long id) {
        //先查询有没有以前这个订单，没有就抛出异常
        Orders orders= orderMapper.checkOrder(id);
        if(orders==null){
            throw new OrderBusinessException(MessageConstant.ORDER_NOT_FOUND);
        }
        //查询到后使用BeanUtils进行内容拷贝，内容进行正确设置
        if(orders.getDeliveryStatus()==0){
            throw new OrderBusinessException(MessageConstant.PREVIOUS_ORDER_NOT_ALLOW_TIMED_DELIVERY);
        }
        orders.setOrderTime(LocalDateTime.now());
        orders.setCancelReason(null);
        orders.setNumber(String.valueOf(System.currentTimeMillis()));
        orders.setCancelTime(null);
        orders.setStatus(1);
        orders.setCheckoutTime(null);
        orders.setRejectionReason(null);
        orders.setEstimatedDeliveryTime(LocalDateTime.now().plusHours(1));
        orders.setDeliveryStatus(1);
        //下单
        orderMapper.insert(orders);
        //查到订单后查询对应的订单详情list
        List<OrderDetail> list =orderDetailMapper.selectById(id);
        for (OrderDetail orderDetail : list) {
            orderDetail.setOrderId(orders.getId());
        }
        System.out.println(list);
        //新增一遍订单详情
        orderDetailMapper.insert(list);
    }

    /**
     * 订单搜索
     *
     * @param ordersPageQueryDTO
     * @return
     */
    public PageResult adminCheckOrder(OrdersPageQueryDTO ordersPageQueryDTO) {
        PageHelper.startPage(ordersPageQueryDTO.getPage(), ordersPageQueryDTO.getPageSize());

        Page<Orders> page = orderMapper.pageQuery(ordersPageQueryDTO);

        // 部分订单状态，需要额外返回订单菜品信息，将Orders转化为OrderVO
        List<OrderVO> orderVOList = getOrderVOList(page);

        return new PageResult(page.getTotal(), orderVOList);
    }

    @Override
    public void adminConfirm(OrdersConfirmDTO ordersConfirmDTO) {
        Orders orders = orderMapper.checkOrder(ordersConfirmDTO.getId());
        orders.setStatus(orders.CONFIRMED);
        orderMapper.update(orders);
    }

    @Override
    public void adminRejection(OrdersRejectionDTO ordersRejectionDTO) {
        Orders orders = orderMapper.checkOrder(ordersRejectionDTO.getId());
        orders.setStatus(Orders.CANCELLED);
        orders.setCancelTime(LocalDateTime.now());
        orders.setCancelReason(ordersRejectionDTO.getRejectionReason());
        orders.setRejectionReason(ordersRejectionDTO.getRejectionReason());
        orderMapper.update(orders);
    }

    @Override
    public void adminCancel(OrdersCancelDTO ordersCancelDTO) {
        Orders orders = orderMapper.checkOrder(ordersCancelDTO.getId());
        orders.setStatus(Orders.CANCELLED);
        orders.setCancelTime(LocalDateTime.now());
        orders.setCancelReason(ordersCancelDTO.getCancelReason());
        orderMapper.update(orders);
    }

    @Override
    public OrderStatisticsVO checkStatistics() {
        OrderStatisticsVO orderStatisticsVO = new OrderStatisticsVO();
        orderStatisticsVO.setConfirmed(orderMapper.checkConfirms());
        orderStatisticsVO.setDeliveryInProgress(orderMapper.checkDeliveryInProgress());
        orderStatisticsVO.setToBeConfirmed(orderMapper.checkToBeConfirmed());
        return null;
    }

    @Override
    public void adminDelivery(Long id) {
        Orders orders = orderMapper.checkOrder(id);
        orders.setStatus(Orders.DELIVERY_IN_PROGRESS);
        orderMapper.update(orders);
    }

    @Override
    public void adminComplete(Long id) {
        Orders orders = orderMapper.checkOrder(id);
        orders.setStatus(Orders.COMPLETED);
        orders.setDeliveryTime(LocalDateTime.now());
        orderMapper.update(orders);
    }

    private List<OrderVO> getOrderVOList(Page<Orders> page) {
        // 需要返回订单菜品信息，自定义OrderVO响应结果
        List<OrderVO> orderVOList = new ArrayList<>();

        List<Orders> ordersList = page.getResult();
        if (!CollectionUtils.isEmpty(ordersList)) {
            for (Orders orders : ordersList) {
                // 将共同字段复制到OrderVO
                System.out.println(orders.getAddressBookId());
                AddressBook addressBook=addressBookMapper.selectById(orders.getAddressBookId());
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append(addressBook.getProvinceName());
                stringBuilder.append(addressBook.getCityName());
                stringBuilder.append(addressBook.getDistrictName());
                stringBuilder.append(addressBook.getDetail());
                String address=stringBuilder.toString();
                orders.setAddress(address);
                OrderVO orderVO = new OrderVO();
                BeanUtils.copyProperties(orders, orderVO);
                String orderDishes = getOrderDishesStr(orders);

                // 将订单菜品信息封装到orderVO中，并添加到orderVOList
                orderVO.setOrderDishes(orderDishes);
                orderVOList.add(orderVO);
            }
        }
        return orderVOList;
    }

    /**
     * 根据订单id获取菜品信息字符串
     *
     * @param orders
     * @return
     */
    private String getOrderDishesStr(Orders orders) {
        // 查询订单菜品详情信息（订单中的菜品和数量）
        List<OrderDetail> orderDetailList = orderDetailMapper.selectById(orders.getId());

        // 将每一条订单菜品信息拼接为字符串（格式：宫保鸡丁*3；）
        List<String> orderDishList = orderDetailList.stream().map(x -> {
            String orderDish = x.getName() + "*" + x.getNumber() + ";";
            return orderDish;
        }).collect(Collectors.toList());

        // 将该订单对应的所有菜品信息拼接在一起
        return String.join("", orderDishList);
    }

    public void payment(OrdersPaymentDTO ordersPaymentDTO){
        // 当前登录用户id
        Long userId = BaseContext.getCurrentId();
        String number=ordersPaymentDTO.getOrderNumber();
        Orders order = orderMapper.checkOrderByUserId(userId,number);
        order.setStatus(Orders.TO_BE_CONFIRMED);
        order.setPayStatus(Orders.PAID);
        order.setCheckoutTime(LocalDateTime.now());
        orderMapper.update(order);
        Map map=new HashMap();
        //type是1的时候是来单提醒
        map.put("type",1);
        map.put("orderId",order.getId());
        map.put("content","订单号"+order.getNumber());
        String json= JSON.toJSONString(map);
        webSocketServer.sendToAllClient(json);
    }

    @Override
    public void reminder(Long id) {
        Map map=new HashMap<>();
        map.put("type",2);
        map.put("orderId",id);
        map.put("content","id为"+id+"的用户催单了");
        String json= JSON.toJSONString(map);
        webSocketServer.sendToAllClient(json);
    }

    @Override
    public OrderOverViewVO overviewOrders() {
        OrderOverViewVO orderOverViewVO = new OrderOverViewVO();
        orderOverViewVO=orderMapper.overviewOrders();
        return orderOverViewVO;
    }

    @Override
    public BusinessDataVO overviewBusinessData() {
        LocalDateTime beginTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime endTime = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        BusinessDataVO businessDataVO = new BusinessDataVO();
        businessDataVO.setNewUsers(orderMapper.newUser(beginTime,endTime));
        businessDataVO.setTurnover(orderMapper.turnover(beginTime,endTime));
        businessDataVO.setOrderCompletionRate(orderMapper.validOrders(beginTime,endTime)/(double)orderMapper.totalOrders(beginTime,endTime));
        Double totalAmount = orderMapper.totalAmount(beginTime, endTime);
        double value = totalAmount/orderMapper.totalOrders(beginTime,endTime);
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        double roundedValue = bd.doubleValue();
        businessDataVO.setUnitPrice(roundedValue);
        businessDataVO.setValidOrderCount(orderMapper.validOrders(beginTime,endTime));
        return businessDataVO;
    }
}
