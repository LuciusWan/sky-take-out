package com.sky.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * C端用户登录
 */

public class UserLoginDTO implements Serializable {

    private String code;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String code) {
        this.code = code;
    }

    /**
     * 获取
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    public String toString() {
        return "UserLoginDTO{code = " + code + "}";
    }
}
