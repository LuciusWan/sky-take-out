package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 菜品总览
 */

public class DishOverViewVO implements Serializable {
    // 已启售数量
    private Integer sold;

    // 已停售数量
    private Integer discontinued;

    public DishOverViewVO() {
    }

    public DishOverViewVO(Integer sold, Integer discontinued) {
        this.sold = sold;
        this.discontinued = discontinued;
    }

    /**
     * 获取
     * @return sold
     */
    public Integer getSold() {
        return sold;
    }

    /**
     * 设置
     * @param sold
     */
    public void setSold(Integer sold) {
        this.sold = sold;
    }

    /**
     * 获取
     * @return discontinued
     */
    public Integer getDiscontinued() {
        return discontinued;
    }

    /**
     * 设置
     * @param discontinued
     */
    public void setDiscontinued(Integer discontinued) {
        this.discontinued = discontinued;
    }

    public String toString() {
        return "DishOverViewVO{sold = " + sold + ", discontinued = " + discontinued + "}";
    }
}
