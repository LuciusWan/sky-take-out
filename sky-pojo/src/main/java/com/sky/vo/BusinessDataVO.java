package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 数据概览
 */

public class BusinessDataVO implements Serializable {

    private Double turnover;//营业额

    private Integer validOrderCount;//有效订单数

    private Double orderCompletionRate;//订单完成率

    private Double unitPrice;//平均客单价

    private Integer newUsers;//新增用户数

    public BusinessDataVO() {
    }

    public BusinessDataVO(Double turnover, Integer validOrderCount, Double orderCompletionRate, Double unitPrice, Integer newUsers) {
        this.turnover = turnover;
        this.validOrderCount = validOrderCount;
        this.orderCompletionRate = orderCompletionRate;
        this.unitPrice = unitPrice;
        this.newUsers = newUsers;
    }

    /**
     * 获取
     * @return turnover
     */
    public Double getTurnover() {
        return turnover;
    }

    /**
     * 设置
     * @param turnover
     */
    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    /**
     * 获取
     * @return validOrderCount
     */
    public Integer getValidOrderCount() {
        return validOrderCount;
    }

    /**
     * 设置
     * @param validOrderCount
     */
    public void setValidOrderCount(Integer validOrderCount) {
        this.validOrderCount = validOrderCount;
    }

    /**
     * 获取
     * @return orderCompletionRate
     */
    public Double getOrderCompletionRate() {
        return orderCompletionRate;
    }

    /**
     * 设置
     * @param orderCompletionRate
     */
    public void setOrderCompletionRate(Double orderCompletionRate) {
        this.orderCompletionRate = orderCompletionRate;
    }

    /**
     * 获取
     * @return unitPrice
     */
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * 设置
     * @param unitPrice
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * 获取
     * @return newUsers
     */
    public Integer getNewUsers() {
        return newUsers;
    }

    /**
     * 设置
     * @param newUsers
     */
    public void setNewUsers(Integer newUsers) {
        this.newUsers = newUsers;
    }

    public String toString() {
        return "BusinessDataVO{turnover = " + turnover + ", validOrderCount = " + validOrderCount + ", orderCompletionRate = " + orderCompletionRate + ", unitPrice = " + unitPrice + ", newUsers = " + newUsers + "}";
    }
}
