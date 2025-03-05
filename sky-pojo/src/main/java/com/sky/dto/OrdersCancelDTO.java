package com.sky.dto;

import lombok.Data;

import java.io.Serializable;


public class OrdersCancelDTO implements Serializable {

    private Long id;
    //订单取消原因
    private String cancelReason;

    public OrdersCancelDTO() {
    }

    public OrdersCancelDTO(Long id, String cancelReason) {
        this.id = id;
        this.cancelReason = cancelReason;
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
     * @return cancelReason
     */
    public String getCancelReason() {
        return cancelReason;
    }

    /**
     * 设置
     * @param cancelReason
     */
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String toString() {
        return "OrdersCancelDTO{id = " + id + ", cancelReason = " + cancelReason + "}";
    }
}
