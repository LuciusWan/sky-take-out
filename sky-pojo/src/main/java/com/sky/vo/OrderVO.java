package com.sky.vo;

import com.sky.entity.OrderDetail;
import com.sky.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

public class OrderVO extends Orders implements Serializable {

    //订单菜品信息
    private String orderDishes;

    //订单详情
    private List<OrderDetail> orderDetailList;
    private static final long serialVersionUID = 1L;
    public OrderVO() {
    }

    public OrderVO(String orderDishes, List<OrderDetail> orderDetailList) {
        this.orderDishes = orderDishes;
        this.orderDetailList = orderDetailList;
    }

    /**
     * 获取
     * @return orderDishes
     */
    public String getOrderDishes() {
        return orderDishes;
    }

    /**
     * 设置
     * @param orderDishes
     */
    public void setOrderDishes(String orderDishes) {
        this.orderDishes = orderDishes;
    }

    /**
     * 获取
     * @return orderDetailList
     */
    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    /**
     * 设置
     * @param orderDetailList
     */
    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public String toString() {
        return "OrderVO{orderDishes = " + orderDishes + ", orderDetailList = " + orderDetailList + "}";
    }
}
