package com.sky.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

public class OrdersPageQueryDTO implements Serializable {

    private int page;

    private int pageSize;

    private String number;

    private  String phone;

    private Integer status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    private Long userId;

    public OrdersPageQueryDTO() {
    }

    public OrdersPageQueryDTO(int page, int pageSize, String number, String phone, Integer status, LocalDateTime beginTime, LocalDateTime endTime, Long userId) {
        this.page = page;
        this.pageSize = pageSize;
        this.number = number;
        this.phone = phone;
        this.status = status;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.userId = userId;
    }

    /**
     * 获取
     * @return page
     */
    public int getPage() {
        return page;
    }

    /**
     * 设置
     * @param page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 获取
     * @return pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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
     * @return beginTime
     */
    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    /**
     * 设置
     * @param beginTime
     */
    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取
     * @return endTime
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * 设置
     * @param endTime
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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

    public String toString() {
        return "OrdersPageQueryDTO{page = " + page + ", pageSize = " + pageSize + ", number = " + number + ", phone = " + phone + ", status = " + status + ", beginTime = " + beginTime + ", endTime = " + endTime + ", userId = " + userId + "}";
    }
}
