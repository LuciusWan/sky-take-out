package com.sky.dto;

import lombok.Data;

import java.io.Serializable;

public class EmployeePageQueryDTO implements Serializable {

    //员工姓名
    private String name;

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;

    public EmployeePageQueryDTO() {
    }

    public EmployeePageQueryDTO(String name, int page, int pageSize) {
        this.name = name;
        this.page = page;
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

    public String toString() {
        return "EmployeePageQueryDTO{name = " + name + ", page = " + page + ", pageSize = " + pageSize + "}";
    }
}
