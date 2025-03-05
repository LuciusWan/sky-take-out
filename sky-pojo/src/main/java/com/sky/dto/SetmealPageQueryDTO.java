package com.sky.dto;

import lombok.Data;

import java.io.Serializable;


public class SetmealPageQueryDTO implements Serializable {

    private int page;

    private int pageSize;

    private String name;

    //分类id
    private Integer categoryId;

    //状态 0表示禁用 1表示启用
    private Integer status;

    public SetmealPageQueryDTO() {
    }

    public SetmealPageQueryDTO(int page, int pageSize, String name, Integer categoryId, Integer status) {
        this.page = page;
        this.pageSize = pageSize;
        this.name = name;
        this.categoryId = categoryId;
        this.status = status;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置
     * @param categoryId
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public String toString() {
        return "SetmealPageQueryDTO{page = " + page + ", pageSize = " + pageSize + ", name = " + name + ", categoryId = " + categoryId + ", status = " + status + "}";
    }
}
