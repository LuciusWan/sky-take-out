package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


public class UserLoginVO implements Serializable {

    private Long id;
    private String openid;
    private String token;
    private static final long serialVersionUID = 1L;
    public UserLoginVO() {
    }

    public UserLoginVO(Long id, String openid, String token) {
        this.id = id;
        this.openid = openid;
        this.token = token;
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
     * @return openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置
     * @param openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    public String toString() {
        return "UserLoginVO{id = " + id + ", openid = " + openid + ", token = " + token + "}";
    }
}
