package com.sky.vo;

import lombok.Data;
import java.io.Serializable;


public class OrderStatisticsVO implements Serializable {
    //待接单数量
    private Integer toBeConfirmed;

    //待派送数量
    private Integer confirmed;

    //派送中数量
    private Integer deliveryInProgress;
    private static final long serialVersionUID = 1L;
    public OrderStatisticsVO() {
    }

    public OrderStatisticsVO(Integer toBeConfirmed, Integer confirmed, Integer deliveryInProgress) {
        this.toBeConfirmed = toBeConfirmed;
        this.confirmed = confirmed;
        this.deliveryInProgress = deliveryInProgress;
    }

    /**
     * 获取
     * @return toBeConfirmed
     */
    public Integer getToBeConfirmed() {
        return toBeConfirmed;
    }

    /**
     * 设置
     * @param toBeConfirmed
     */
    public void setToBeConfirmed(Integer toBeConfirmed) {
        this.toBeConfirmed = toBeConfirmed;
    }

    /**
     * 获取
     * @return confirmed
     */
    public Integer getConfirmed() {
        return confirmed;
    }

    /**
     * 设置
     * @param confirmed
     */
    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    /**
     * 获取
     * @return deliveryInProgress
     */
    public Integer getDeliveryInProgress() {
        return deliveryInProgress;
    }

    /**
     * 设置
     * @param deliveryInProgress
     */
    public void setDeliveryInProgress(Integer deliveryInProgress) {
        this.deliveryInProgress = deliveryInProgress;
    }

    public String toString() {
        return "OrderStatisticsVO{toBeConfirmed = " + toBeConfirmed + ", confirmed = " + confirmed + ", deliveryInProgress = " + deliveryInProgress + "}";
    }
}
