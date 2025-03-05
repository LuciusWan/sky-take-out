package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sky.jwt")
public class JwtProperties {

    /**
     * 管理端员工生成jwt令牌相关配置
     */
    private String adminSecretKey;
    private long adminTtl;
    private String adminTokenName;

    /**
     * 用户端微信用户生成jwt令牌相关配置
     */
    private String userSecretKey;
    private long userTtl;
    private String userTokenName;

    public JwtProperties() {
    }

    public JwtProperties(String adminSecretKey, long adminTtl, String adminTokenName, String userSecretKey, long userTtl, String userTokenName) {
        this.adminSecretKey = adminSecretKey;
        this.adminTtl = adminTtl;
        this.adminTokenName = adminTokenName;
        this.userSecretKey = userSecretKey;
        this.userTtl = userTtl;
        this.userTokenName = userTokenName;
    }

    /**
     * 获取
     * @return adminSecretKey
     */
    public String getAdminSecretKey() {
        return adminSecretKey;
    }

    /**
     * 设置
     * @param adminSecretKey
     */
    public void setAdminSecretKey(String adminSecretKey) {
        this.adminSecretKey = adminSecretKey;
    }

    /**
     * 获取
     * @return adminTtl
     */
    public long getAdminTtl() {
        return adminTtl;
    }

    /**
     * 设置
     * @param adminTtl
     */
    public void setAdminTtl(long adminTtl) {
        this.adminTtl = adminTtl;
    }

    /**
     * 获取
     * @return adminTokenName
     */
    public String getAdminTokenName() {
        return adminTokenName;
    }

    /**
     * 设置
     * @param adminTokenName
     */
    public void setAdminTokenName(String adminTokenName) {
        this.adminTokenName = adminTokenName;
    }

    /**
     * 获取
     * @return userSecretKey
     */
    public String getUserSecretKey() {
        return userSecretKey;
    }

    /**
     * 设置
     * @param userSecretKey
     */
    public void setUserSecretKey(String userSecretKey) {
        this.userSecretKey = userSecretKey;
    }

    /**
     * 获取
     * @return userTtl
     */
    public long getUserTtl() {
        return userTtl;
    }

    /**
     * 设置
     * @param userTtl
     */
    public void setUserTtl(long userTtl) {
        this.userTtl = userTtl;
    }

    /**
     * 获取
     * @return userTokenName
     */
    public String getUserTokenName() {
        return userTokenName;
    }

    /**
     * 设置
     * @param userTokenName
     */
    public void setUserTokenName(String userTokenName) {
        this.userTokenName = userTokenName;
    }

    public String toString() {
        return "JwtProperties{adminSecretKey = " + adminSecretKey + ", adminTtl = " + adminTtl + ", adminTokenName = " + adminTokenName + ", userSecretKey = " + userSecretKey + ", userTtl = " + userTtl + ", userTokenName = " + userTokenName + "}";
    }
}
