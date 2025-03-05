package com.sky.dto;

import lombok.Data;
import java.io.Serializable;

public class OrdersPaymentDTO implements Serializable {
    //订单号
    private String orderNumber;

    //付款方式
    private Integer payMethod;

    public OrdersPaymentDTO() {
    }

    public OrdersPaymentDTO(String orderNumber, Integer payMethod) {
        this.orderNumber = orderNumber;
        this.payMethod = payMethod;
    }

    /**
     * 获取
     * @return orderNumber
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置
     * @param orderNumber
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取
     * @return payMethod
     */
    public Integer getPayMethod() {
        return payMethod;
    }

    /**
     * 设置
     * @param payMethod
     */
    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public String toString() {
        return "OrdersPaymentDTO{orderNumber = " + orderNumber + ", payMethod = " + payMethod + "}";
    }
}
