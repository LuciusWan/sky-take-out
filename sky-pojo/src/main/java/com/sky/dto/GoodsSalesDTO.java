package com.sky.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


public class GoodsSalesDTO implements Serializable {
    //商品名称
    private String name;

    //销量
    private Integer number;

    public GoodsSalesDTO() {
    }

    public GoodsSalesDTO(String name, Integer number) {
        this.name = name;
        this.number = number;
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

    public String toString() {
        return "GoodsSalesDTO{name = " + name + ", number = " + number + "}";
    }
}
