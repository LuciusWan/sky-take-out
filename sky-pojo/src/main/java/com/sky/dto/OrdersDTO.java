package com.sky.dto;

import com.sky.entity.OrderDetail;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrdersDTO implements Serializable {

    private Long id;

    //订单号
    private String number;

    //订单状态 1待付款，2待派送，3已派送，4已完成，5已取消
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

    private List<OrderDetail> orderDetails;

    public OrdersDTO() {
    }

    public OrdersDTO(Long id, String number, Integer status, Long userId, Long addressBookId, LocalDateTime orderTime, LocalDateTime checkoutTime, Integer payMethod, BigDecimal amount, String remark, String userName, String phone, String address, String consignee, List<OrderDetail> orderDetails) {
        this.id = id;
        this.number = number;
        this.status = status;
        this.userId = userId;
        this.addressBookId = addressBookId;
        this.orderTime = orderTime;
        this.checkoutTime = checkoutTime;
        this.payMethod = payMethod;
        this.amount = amount;
        this.remark = remark;
        this.userName = userName;
        this.phone = phone;
        this.address = address;
        this.consignee = consignee;
        this.orderDetails = orderDetails;
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
     * @return orderDetails
     */
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    /**
     * 设置
     * @param orderDetails
     */
    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String toString() {
        return "OrdersDTO{id = " + id + ", number = " + number + ", status = " + status + ", userId = " + userId + ", addressBookId = " + addressBookId + ", orderTime = " + orderTime + ", checkoutTime = " + checkoutTime + ", payMethod = " + payMethod + ", amount = " + amount + ", remark = " + remark + ", userName = " + userName + ", phone = " + phone + ", address = " + address + ", consignee = " + consignee + ", orderDetails = " + orderDetails + "}";
    }
}
