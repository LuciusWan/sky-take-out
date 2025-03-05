package com.sky.dto;

import lombok.Data;

import java.io.Serializable;


public class PasswordEditDTO implements Serializable {

    //员工id
    private Long empId;

    //旧密码
    private String oldPassword;

    //新密码
    private String newPassword;

    public PasswordEditDTO() {
    }

    public PasswordEditDTO(Long empId, String oldPassword, String newPassword) {
        this.empId = empId;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    /**
     * 获取
     * @return empId
     */
    public Long getEmpId() {
        return empId;
    }

    /**
     * 设置
     * @param empId
     */
    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    /**
     * 获取
     * @return oldPassword
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * 设置
     * @param oldPassword
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * 获取
     * @return newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * 设置
     * @param newPassword
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String toString() {
        return "PasswordEditDTO{empId = " + empId + ", oldPassword = " + oldPassword + ", newPassword = " + newPassword + "}";
    }
}
