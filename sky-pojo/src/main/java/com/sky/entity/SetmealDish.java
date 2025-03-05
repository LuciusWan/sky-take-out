package com.sky.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 套餐菜品关系
 */

public class SetmealDish implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    //套餐id
    private Long setmealId;

    //菜品id
    private Long dishId;

    //菜品名称 （冗余字段）
    private String name;

    //菜品原价
    private BigDecimal price;

    //份数
    private Integer copies;

    public SetmealDish() {
    }

    public SetmealDish(long serialVersionUID, Long id, Long setmealId, Long dishId, String name, BigDecimal price, Integer copies) {

        this.id = id;
        this.setmealId = setmealId;
        this.dishId = dishId;
        this.name = name;
        this.price = price;
        this.copies = copies;
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
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取
     * @return copies
     */
    public Integer getCopies() {
        return copies;
    }

    /**
     * 设置
     * @param copies
     */
    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public String toString() {
        return "SetmealDish{serialVersionUID = " + serialVersionUID + ", id = " + id + ", setmealId = " + setmealId + ", dishId = " + dishId + ", name = " + name + ", price = " + price + ", copies = " + copies + "}";
    }
}
