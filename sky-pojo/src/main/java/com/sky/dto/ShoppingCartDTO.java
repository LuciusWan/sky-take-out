package com.sky.dto;

import lombok.Data;
import java.io.Serializable;


public class ShoppingCartDTO implements Serializable {

    private Long dishId;
    private Long setmealId;
    private String dishFlavor;

    public ShoppingCartDTO() {
    }

    public ShoppingCartDTO(Long dishId, Long setmealId, String dishFlavor) {
        this.dishId = dishId;
        this.setmealId = setmealId;
        this.dishFlavor = dishFlavor;
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

    public String toString() {
        return "ShoppingCartDTO{dishId = " + dishId + ", setmealId = " + setmealId + ", dishFlavor = " + dishFlavor + "}";
    }
}
