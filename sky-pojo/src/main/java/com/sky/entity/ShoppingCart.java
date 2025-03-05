package com.sky.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 购物车
 */

public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    //名称
    private String name;

    //用户id
    private Long userId;

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

    private LocalDateTime createTime;

    public ShoppingCart() {
    }

    public ShoppingCart(long serialVersionUID, Long id, String name, Long userId, Long dishId, Long setmealId, String dishFlavor, Integer number, BigDecimal amount, String image, LocalDateTime createTime) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.dishId = dishId;
        this.setmealId = setmealId;
        this.dishFlavor = dishFlavor;
        this.number = number;
        this.amount = amount;
        this.image = image;
        this.createTime = createTime;
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
     * @return userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
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

    /**
     * 获取
     * @return createTime
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String toString() {
        return "ShoppingCart{serialVersionUID = " + serialVersionUID + ", id = " + id + ", name = " + name + ", userId = " + userId + ", dishId = " + dishId + ", setmealId = " + setmealId + ", dishFlavor = " + dishFlavor + ", number = " + number + ", amount = " + amount + ", image = " + image + ", createTime = " + createTime + "}";
    }
}
