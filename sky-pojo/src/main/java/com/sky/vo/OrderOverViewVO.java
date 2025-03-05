package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 订单概览数据
 */

public class OrderOverViewVO implements Serializable {
    //待接单数量
    private Integer waitingOrders;

    //待派送数量
    private Integer deliveredOrders;

    //已完成数量
    private Integer completedOrders;

    //已取消数量
    private Integer cancelledOrders;

    //全部订单
    private Integer allOrders;
    private static final long serialVersionUID = 1L;
    public OrderOverViewVO() {
    }

    public OrderOverViewVO(Integer waitingOrders, Integer deliveredOrders, Integer completedOrders, Integer cancelledOrders, Integer allOrders) {
        this.waitingOrders = waitingOrders;
        this.deliveredOrders = deliveredOrders;
        this.completedOrders = completedOrders;
        this.cancelledOrders = cancelledOrders;
        this.allOrders = allOrders;
    }

    /**
     * 获取
     * @return waitingOrders
     */
    public Integer getWaitingOrders() {
        return waitingOrders;
    }

    /**
     * 设置
     * @param waitingOrders
     */
    public void setWaitingOrders(Integer waitingOrders) {
        this.waitingOrders = waitingOrders;
    }

    /**
     * 获取
     * @return deliveredOrders
     */
    public Integer getDeliveredOrders() {
        return deliveredOrders;
    }

    /**
     * 设置
     * @param deliveredOrders
     */
    public void setDeliveredOrders(Integer deliveredOrders) {
        this.deliveredOrders = deliveredOrders;
    }

    /**
     * 获取
     * @return completedOrders
     */
    public Integer getCompletedOrders() {
        return completedOrders;
    }

    /**
     * 设置
     * @param completedOrders
     */
    public void setCompletedOrders(Integer completedOrders) {
        this.completedOrders = completedOrders;
    }

    /**
     * 获取
     * @return cancelledOrders
     */
    public Integer getCancelledOrders() {
        return cancelledOrders;
    }

    /**
     * 设置
     * @param cancelledOrders
     */
    public void setCancelledOrders(Integer cancelledOrders) {
        this.cancelledOrders = cancelledOrders;
    }

    /**
     * 获取
     * @return allOrders
     */
    public Integer getAllOrders() {
        return allOrders;
    }

    /**
     * 设置
     * @param allOrders
     */
    public void setAllOrders(Integer allOrders) {
        this.allOrders = allOrders;
    }

    public String toString() {
        return "OrderOverViewVO{waitingOrders = " + waitingOrders + ", deliveredOrders = " + deliveredOrders + ", completedOrders = " + completedOrders + ", cancelledOrders = " + cancelledOrders + ", allOrders = " + allOrders + "}";
    }
}
