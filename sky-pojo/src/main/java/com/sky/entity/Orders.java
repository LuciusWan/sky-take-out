package com.sky.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单
 */

public class Orders implements Serializable {

    /**
     * 订单状态 1待付款 2待接单 3已接单 4派送中 5已完成 6已取消
     */
    public static final Integer PENDING_PAYMENT = 1;
    public static final Integer TO_BE_CONFIRMED = 2;
    public static final Integer CONFIRMED = 3;
    public static final Integer DELIVERY_IN_PROGRESS = 4;
    public static final Integer COMPLETED = 5;
    public static final Integer CANCELLED = 6;

    /**
     * 支付状态 0未支付 1已支付 2退款
     */
    public static final Integer UN_PAID = 0;
    public static final Integer PAID = 1;
    public static final Integer REFUND = 2;

    private static final long serialVersionUID = 1L;

    private Long id;

    //订单号
    private String number;

    //订单状态 1待付款 2待接单 3已接单 4派送中 5已完成 6已取消 7退款
    private Integer status;

    //下单用户id
    private Long userId;

    //地址id
    private Long addressBookId;

    //下单时间
    private LocalDateTime orderTime;

    //结账时间
    private LocalDateTime checkoutTime;

    //支付方式 1微信，2支付宝
    private Integer payMethod;

    //支付状态 0未支付 1已支付 2退款
    private Integer payStatus;

    //实收金额
    private BigDecimal amount;

    //备注
    private String remark;

    //用户名
    private String userName;

    //手机号
    private String phone;

    //地址
    private String address;

    //收货人
    private String consignee;

    //订单取消原因
    private String cancelReason;

    //订单拒绝原因
    private String rejectionReason;

    //订单取消时间
    private LocalDateTime cancelTime;

    //预计送达时间
    private LocalDateTime estimatedDeliveryTime;

    //配送状态  1立即送出  0选择具体时间
    private Integer deliveryStatus;

    //送达时间
    private LocalDateTime deliveryTime;

    //打包费
    private int packAmount;

    //餐具数量
    private int tablewareNumber;

    //餐具数量状态  1按餐量提供  0选择具体数量
    private Integer tablewareStatus;

    public Orders() {
    }

    public Orders(Integer PENDING_PAYMENT, Integer TO_BE_CONFIRMED, Integer CONFIRMED, Integer DELIVERY_IN_PROGRESS, Integer COMPLETED, Integer CANCELLED, Integer UN_PAID, Integer PAID, Integer REFUND, long serialVersionUID, Long id, String number, Integer status, Long userId, Long addressBookId, LocalDateTime orderTime, LocalDateTime checkoutTime, Integer payMethod, Integer payStatus, BigDecimal amount, String remark, String userName, String phone, String address, String consignee, String cancelReason, String rejectionReason, LocalDateTime cancelTime, LocalDateTime estimatedDeliveryTime, Integer deliveryStatus, LocalDateTime deliveryTime, int packAmount, int tablewareNumber, Integer tablewareStatus) {
        this.id = id;
        this.number = number;
        this.status = status;
        this.userId = userId;
        this.addressBookId = addressBookId;
        this.orderTime = orderTime;
        this.checkoutTime = checkoutTime;
        this.payMethod = payMethod;
        this.payStatus = payStatus;
        this.amount = amount;
        this.remark = remark;
        this.userName = userName;
        this.phone = phone;
        this.address = address;
        this.consignee = consignee;
        this.cancelReason = cancelReason;
        this.rejectionReason = rejectionReason;
        this.cancelTime = cancelTime;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
        this.deliveryStatus = deliveryStatus;
        this.deliveryTime = deliveryTime;
        this.packAmount = packAmount;
        this.tablewareNumber = tablewareNumber;
        this.tablewareStatus = tablewareStatus;
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
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
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

    /**
     * 获取
     * @return userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
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
     * @return orderTime
     */
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    /**
     * 设置
     * @param orderTime
     */
    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 获取
     * @return checkoutTime
     */
    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    /**
     * 设置
     * @param checkoutTime
     */
    public void setCheckoutTime(LocalDateTime checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    /**
     * 获取
     * @return payMethod
     */
    public Integer getPayMethod() {
        return payMethod;
    }

    /**
     * 设置
     * @param payMethod
     */
    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    /**
     * 获取
     * @return payStatus
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * 设置
     * @param payStatus
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
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
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return consignee
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * 设置
     * @param consignee
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
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

    /**
     * 获取
     * @return cancelTime
     */
    public LocalDateTime getCancelTime() {
        return cancelTime;
    }

    /**
     * 设置
     * @param cancelTime
     */
    public void setCancelTime(LocalDateTime cancelTime) {
        this.cancelTime = cancelTime;
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
     * @return deliveryTime
     */
    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * 设置
     * @param deliveryTime
     */
    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * 获取
     * @return packAmount
     */
    public int getPackAmount() {
        return packAmount;
    }

    /**
     * 设置
     * @param packAmount
     */
    public void setPackAmount(int packAmount) {
        this.packAmount = packAmount;
    }

    /**
     * 获取
     * @return tablewareNumber
     */
    public int getTablewareNumber() {
        return tablewareNumber;
    }

    /**
     * 设置
     * @param tablewareNumber
     */
    public void setTablewareNumber(int tablewareNumber) {
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

    public String toString() {
        return "Orders{PENDING_PAYMENT = " + PENDING_PAYMENT + ", TO_BE_CONFIRMED = " + TO_BE_CONFIRMED + ", CONFIRMED = " + CONFIRMED + ", DELIVERY_IN_PROGRESS = " + DELIVERY_IN_PROGRESS + ", COMPLETED = " + COMPLETED + ", CANCELLED = " + CANCELLED + ", UN_PAID = " + UN_PAID + ", PAID = " + PAID + ", REFUND = " + REFUND + ", serialVersionUID = " + serialVersionUID + ", id = " + id + ", number = " + number + ", status = " + status + ", userId = " + userId + ", addressBookId = " + addressBookId + ", orderTime = " + orderTime + ", checkoutTime = " + checkoutTime + ", payMethod = " + payMethod + ", payStatus = " + payStatus + ", amount = " + amount + ", remark = " + remark + ", userName = " + userName + ", phone = " + phone + ", address = " + address + ", consignee = " + consignee + ", cancelReason = " + cancelReason + ", rejectionReason = " + rejectionReason + ", cancelTime = " + cancelTime + ", estimatedDeliveryTime = " + estimatedDeliveryTime + ", deliveryStatus = " + deliveryStatus + ", deliveryTime = " + deliveryTime + ", packAmount = " + packAmount + ", tablewareNumber = " + tablewareNumber + ", tablewareStatus = " + tablewareStatus + "}";
    }
}
