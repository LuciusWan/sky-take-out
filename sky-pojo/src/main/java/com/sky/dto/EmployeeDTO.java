package com.sky.dto;

import lombok.Data;

import java.io.Serializable;


public class EmployeeDTO implements Serializable {

    private Long id;

    private String username;

    private String name;

    private String phone;

    private String sex;

    private String idNumber;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String username, String name, String phone, String sex, String idNumber) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.idNumber = idNumber;
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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
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
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取
     * @return idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置
     * @param idNumber
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String toString() {
        return "EmployeeDTO{id = " + id + ", username = " + username + ", name = " + name + ", phone = " + phone + ", sex = " + sex + ", idNumber = " + idNumber + "}";
    }
}
