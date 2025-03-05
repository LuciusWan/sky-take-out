package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class OrderSubmitVO implements Serializable {
    //订单id
    private Long id;
    //订单号
    private String orderNumber;
    //订单金额
    private BigDecimal orderAmount;
    //下单时间
    private LocalDateTime orderTime;

    public OrderSubmitVO() {
    }

    public OrderSubmitVO(Long id, String orderNumber, BigDecimal orderAmount, LocalDateTime orderTime) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderAmount = orderAmount;
        this.orderTime = orderTime;
    }

    /**
     * 获取
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return orderAmount
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * 设置
     * @param orderAmount
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 获取
     * @return orderTime
     */
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    /**
     * 设置
     * @param orderTime
     */
    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String toString() {
        return "OrderSubmitVO{id = " + id + ", orderNumber = " + orderNumber + ", orderAmount = " + orderAmount + ", orderTime = " + orderTime + "}";
    }
}
