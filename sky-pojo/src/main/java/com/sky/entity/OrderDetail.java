package com.sky.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单明细
 */

public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    //名称
    private String name;

    //订单id
    private Long orderId;

    //菜品id
    private Long dishId;

    //套餐id
    private Long setmealId;

    //口味
    private String dishFlavor;

    //数量
    private Integer number;

    //金额
    private BigDecimal amount;

    //图片
    private String image;

    public OrderDetail() {
    }

    public OrderDetail(long serialVersionUID, Long id, String name, Long orderId, Long dishId, Long setmealId, String dishFlavor, Integer number, BigDecimal amount, String image) {
        this.id = id;
        this.name = name;
        this.orderId = orderId;
        this.dishId = dishId;
        this.setmealId = setmealId;
        this.dishFlavor = dishFlavor;
        this.number = number;
        this.amount = amount;
        this.image = image;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return orderId
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置
     * @param orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取
     * @return dishId
     */
    public Long getDishId() {
        return dishId;
    }

    /**
     * 设置
     * @param dishId
     */
    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    /**
     * 获取
     * @return setmealId
     */
    public Long getSetmealId() {
        return setmealId;
    }

    /**
     * 设置
     * @param setmealId
     */
    public void setSetmealId(Long setmealId) {
        this.setmealId = setmealId;
    }

    /**
     * 获取
     * @return dishFlavor
     */
    public String getDishFlavor() {
        return dishFlavor;
    }

    /**
     * 设置
     * @param dishFlavor
     */
    public void setDishFlavor(String dishFlavor) {
        this.dishFlavor = dishFlavor;
    }

    /**
     * 获取
     * @return number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取
     * @return amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置
     * @param amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    public String toString() {
        return "OrderDetail{serialVersionUID = " + serialVersionUID + ", id = " + id + ", name = " + name + ", orderId = " + orderId + ", dishId = " + dishId + ", setmealId = " + setmealId + ", dishFlavor = " + dishFlavor + ", number = " + number + ", amount = " + amount + ", image = " + image + "}";
    }
}
