package com.sky.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 菜品口味
 */

public class DishFlavor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    //菜品id
    private Long dishId;

    //口味名称
    private String name;

    //口味数据list
    private String value;

    public DishFlavor() {
    }

    public DishFlavor(long serialVersionUID, Long id, Long dishId, String name, String value) {
        this.id = id;
        this.dishId = dishId;
        this.name = name;
        this.value = value;
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
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return "DishFlavor{serialVersionUID = " + serialVersionUID + ", id = " + id + ", dishId = " + dishId + ", name = " + name + ", value = " + value + "}";
    }
}
