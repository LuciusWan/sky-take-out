package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


public class OrderReportVO implements Serializable {

    //日期，以逗号分隔，例如：2022-10-01,2022-10-02,2022-10-03
    private String dateList;

    //每日订单数，以逗号分隔，例如：260,210,215
    private String orderCountList;

    //每日有效订单数，以逗号分隔，例如：20,21,10
    private String validOrderCountList;

    //订单总数
    private Integer totalOrderCount;

    //有效订单数
    private Integer validOrderCount;

    //订单完成率
    private Double orderCompletionRate;

    public OrderReportVO() {
    }

    public OrderReportVO(String dateList, String orderCountList, String validOrderCountList, Integer totalOrderCount, Integer validOrderCount, Double orderCompletionRate) {
        this.dateList = dateList;
        this.orderCountList = orderCountList;
        this.validOrderCountList = validOrderCountList;
        this.totalOrderCount = totalOrderCount;
        this.validOrderCount = validOrderCount;
        this.orderCompletionRate = orderCompletionRate;
    }

    /**
     * 获取
     * @return dateList
     */
    public String getDateList() {
        return dateList;
    }

    /**
     * 设置
     * @param dateList
     */
    public void setDateList(String dateList) {
        this.dateList = dateList;
    }

    /**
     * 获取
     * @return orderCountList
     */
    public String getOrderCountList() {
        return orderCountList;
    }

    /**
     * 设置
     * @param orderCountList
     */
    public void setOrderCountList(String orderCountList) {
        this.orderCountList = orderCountList;
    }

    /**
     * 获取
     * @return validOrderCountList
     */
    public String getValidOrderCountList() {
        return validOrderCountList;
    }

    /**
     * 设置
     * @param validOrderCountList
     */
    public void setValidOrderCountList(String validOrderCountList) {
        this.validOrderCountList = validOrderCountList;
    }

    /**
     * 获取
     * @return totalOrderCount
     */
    public Integer getTotalOrderCount() {
        return totalOrderCount;
    }

    /**
     * 设置
     * @param totalOrderCount
     */
    public void setTotalOrderCount(Integer totalOrderCount) {
        this.totalOrderCount = totalOrderCount;
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

    public String toString() {
        return "OrderReportVO{dateList = " + dateList + ", orderCountList = " + orderCountList + ", validOrderCountList = " + validOrderCountList + ", totalOrderCount = " + totalOrderCount + ", validOrderCount = " + validOrderCount + ", orderCompletionRate = " + orderCompletionRate + "}";
    }
}
