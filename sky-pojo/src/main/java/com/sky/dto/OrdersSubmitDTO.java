package com.sky.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class OrdersSubmitDTO implements Serializable {
    //地址簿id
    private Long addressBookId;
    //付款方式
    private int payMethod;
    //备注
    private String remark;
    //预计送达时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime estimatedDeliveryTime;
    //配送状态  1立即送出  0选择具体时间
    private Integer deliveryStatus;
    //餐具数量
    private Integer tablewareNumber;
    //餐具数量状态  1按餐量提供  0选择具体数量
    private Integer tablewareStatus;
    //打包费
    private Integer packAmount;
    //总金额
    private BigDecimal amount;

    public OrdersSubmitDTO() {
    }

    public OrdersSubmitDTO(Long addressBookId, int payMethod, String remark, LocalDateTime estimatedDeliveryTime, Integer deliveryStatus, Integer tablewareNumber, Integer tablewareStatus, Integer packAmount, BigDecimal amount) {
        this.addressBookId = addressBookId;
        this.payMethod = payMethod;
        this.remark = remark;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
        this.deliveryStatus = deliveryStatus;
        this.tablewareNumber = tablewareNumber;
        this.tablewareStatus = tablewareStatus;
        this.packAmount = packAmount;
        this.amount = amount;
    }

    /**
     * 获取
     * @return addressBookId
     */
    public Long getAddressBookId() {
        return addressBookId;
    }

    /**
     * 设置
     * @param addressBookId
     */
    public void setAddressBookId(Long addressBookId) {
        this.addressBookId = addressBookId;
    }

    /**
     * 获取
     * @return payMethod
     */
    public int getPayMethod() {
        return payMethod;
    }

    /**
     * 设置
     * @param payMethod
     */
    public void setPayMethod(int payMethod) {
        this.payMethod = payMethod;
    }

    /**
     * 获取
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取
     * @return estimatedDeliveryTime
     */
    public LocalDateTime getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    /**
     * 设置
     * @param estimatedDeliveryTime
     */
    public void setEstimatedDeliveryTime(LocalDateTime estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    /**
     * 获取
     * @return deliveryStatus
     */
    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    /**
     * 设置
     * @param deliveryStatus
     */
    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    /**
     * 获取
     * @return tablewareNumber
     */
    public Integer getTablewareNumber() {
        return tablewareNumber;
    }

    /**
     * 设置
     * @param tablewareNumber
     */
    public void setTablewareNumber(Integer tablewareNumber) {
        this.tablewareNumber = tablewareNumber;
    }

    /**
     * 获取
     * @return tablewareStatus
     */
    public Integer getTablewareStatus() {
        return tablewareStatus;
    }

    /**
     * 设置
     * @param tablewareStatus
     */
    public void setTablewareStatus(Integer tablewareStatus) {
        this.tablewareStatus = tablewareStatus;
    }

    /**
     * 获取
     * @return packAmount
     */
    public Integer getPackAmount() {
        return packAmount;
    }

    /**
     * 设置
     * @param packAmount
     */
    public void setPackAmount(Integer packAmount) {
        this.packAmount = packAmount;
    }

    /**
     * 获取
     * @return amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置
     * @param amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String toString() {
        return "OrdersSubmitDTO{addressBookId = " + addressBookId + ", payMethod = " + payMethod + ", remark = " + remark + ", estimatedDeliveryTime = " + estimatedDeliveryTime + ", deliveryStatus = " + deliveryStatus + ", tablewareNumber = " + tablewareNumber + ", tablewareStatus = " + tablewareStatus + ", packAmount = " + packAmount + ", amount = " + amount + "}";
    }
}
