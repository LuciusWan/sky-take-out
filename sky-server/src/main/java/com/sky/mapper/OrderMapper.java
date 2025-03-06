package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.GoodsSalesDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import com.sky.vo.DishVO;
import com.sky.vo.OrderVO;
import com.sky.vo.SalesTop10ReportVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface OrderMapper {
    void insert(Orders orders);
    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);
    @Select("select * from orders where id=#{id}")
    Orders checkOrder(Long id);
    //@Update("update orders set status=#{status},cancel_reason=#{cancelReason},cancel_time=#{cancelTime} where id=#{id}")
    void update(Orders orders);
    @Select("select count(*) from orders where status=3")
    Integer checkConfirms();
    @Select("select count(*) from orders where status=4")
    Integer checkDeliveryInProgress();
    @Select("select count(*) from orders where status=2")
    Integer checkToBeConfirmed();
    @Select("select * from orders where order_time<#{localDateTime} and status=1")
    List<Orders> selectOverTime(LocalDateTime localDateTime);
    @Select("select * from orders where status=4")
    List<Orders> selectUnCompleteOrder(LocalDateTime now);
    @Select("select * from orders where user_id=#{userId} and status=1 and number=#{number}")
    Orders checkOrderByUserId(Long userId,String number);
    @Update("update orders set consignee=#{consignee},phone=#{phone} where address_book_id=#{addressBookId}")
    void updateConsignee(String consignee,Long addressBookId,String phone);
    @Select("select sum(amount) from orders where order_time>=#{beginTime} and order_time<=#{endTime} and status=5")
    Double turnover(LocalDateTime beginTime, LocalDateTime endTime);
    @Select("select count(DISTINCT user_id) from orders where order_time>=#{beginTime} and order_time<=#{endTime}")
    Integer totalUser(LocalDateTime beginTime, LocalDateTime endTime);
    @Select("select count(*) from user where create_time>=#{beginTime} and create_time<=#{endTime}")
    Integer newUser(LocalDateTime beginTime, LocalDateTime endTime);
    @Select("select count(*) from orders")
    Integer totalOrderCount();
    @Select("select count(*) from orders where status=5")
    Integer validOrderCount();
    @Select("select count(*) from orders where order_time>=#{beginTime} and order_time<=#{endTime}")
    Integer totalOrders(LocalDateTime beginTime, LocalDateTime endTime);
    @Select("select count(*) from orders where order_time>=#{beginTime} and order_time<=#{endTime} and status=5")
    Integer validOrders(LocalDateTime beginTime, LocalDateTime endTime);
    @Select("select od.name,sum(od.number) number from order_detail od, orders o where od.order_id=o.id and o.order_time>=#{beginTime} and o.order_time<=#{endTime} and o.status=5 " +
            "group by od.name order by number desc limit 0,10")
    List<GoodsSalesDTO> saleTop10(LocalDateTime beginTime, LocalDateTime endTime);
}
