package com.sky.Task;

import com.sky.constant.MessageConstant;
import com.sky.context.BaseContext;
import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import com.sky.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
public class OrderTask {
    @Autowired
    private OrderMapper orderMapper;
    @Scheduled(cron = "0 * * * * ?")
    public void orderPayTask() {
        LocalDateTime fifteenMinutesAgo = LocalDateTime.now().minusMinutes(15);
        List<Orders> list=orderMapper.selectOverTime(fifteenMinutesAgo);
        for(Orders order:list){
            order.setStatus(6);
            order.setCancelTime(LocalDateTime.now());
            order.setCancelReason(MessageConstant.LONG_TIME_NO_PAYMENT);
            orderMapper.update(order);
            log.info("订单号为{}的订单因为支付超时被取消订单",order.getId());
        }
    }
    @Scheduled(cron = "0 0 1 * * ?")
    public void orderCompleteTask() {
        List<Orders> list=orderMapper.selectUnCompleteOrder(LocalDateTime.now());
        for(Orders order:list){
            order.setStatus(5);
            order.setDeliveryTime(LocalDateTime.now());
            orderMapper.update(order);
            log.info("订单号为{}的订单完成配送",order.getId());
        }
    }
}
