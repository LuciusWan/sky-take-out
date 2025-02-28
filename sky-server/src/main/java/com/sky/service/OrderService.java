package com.sky.service;
import com.sky.dto.*;
import com.sky.entity.Orders;
import com.sky.result.PageResult;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;

import java.util.List;

public interface OrderService {
    OrderSubmitVO submit(OrdersSubmitDTO ordersSubmitDTO);

    PageResult pageResult(int page,int pageSize,Integer status);

    OrderVO checkOrder(Long id);

    void cancel(Long id);

    void repetition(Long id);

    PageResult adminCheckOrder(OrdersPageQueryDTO ordersPageQueryDTO);

    void adminConfirm(OrdersConfirmDTO ordersConfirmDTO);

    void adminRejection(OrdersRejectionDTO ordersRejectionDTO);

    void adminCancel(OrdersCancelDTO ordersCancelDTO);

    OrderStatisticsVO checkStatistics();

    void adminDelivery(Long id);

    void adminComplete(Long id);
}
