package com.sky.dto;

import lombok.Data;

import java.io.Serializable;

public class OrdersConfirmDTO implements Serializable {

    private Long id;
    //订单状态 1待付款 2待接单 3 已接单 4 派送中 5 已完成 6 已取消 7 退款
    private Integer status;

    public OrdersConfirmDTO() {
    }

    public OrdersConfirmDTO(Long id, Integer status) {
        this.id = id;
        this.status = status;
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
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString() {
        return "OrdersConfirmDTO{id = " + id + ", status = " + status + "}";
    }
}
