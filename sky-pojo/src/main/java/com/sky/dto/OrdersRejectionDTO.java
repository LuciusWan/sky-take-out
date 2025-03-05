package com.sky.dto;

import lombok.Data;

import java.io.Serializable;


public class OrdersRejectionDTO implements Serializable {

    private Long id;

    //订单拒绝原因
    private String rejectionReason;

    public OrdersRejectionDTO() {
    }

    public OrdersRejectionDTO(Long id, String rejectionReason) {
        this.id = id;
        this.rejectionReason = rejectionReason;
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
     * @return rejectionReason
     */
    public String getRejectionReason() {
        return rejectionReason;
    }

    /**
     * 设置
     * @param rejectionReason
     */
    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public String toString() {
        return "OrdersRejectionDTO{id = " + id + ", rejectionReason = " + rejectionReason + "}";
    }
}
