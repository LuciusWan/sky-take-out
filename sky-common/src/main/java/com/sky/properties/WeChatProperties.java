package com.sky.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sky.wechat")

public class WeChatProperties {

    private String appid; //小程序的appid
    private String secret; //小程序的秘钥
    private String mchid; //商户号
    private String mchSerialNo; //商户API证书的证书序列号
    private String privateKeyFilePath; //商户私钥文件
    private String apiV3Key; //证书解密的密钥
    private String weChatPayCertFilePath; //平台证书
    private String notifyUrl; //支付成功的回调地址
    private String refundNotifyUrl; //退款成功的回调地址

    public WeChatProperties() {
    }

    public WeChatProperties(String appid, String secret, String mchid, String mchSerialNo, String privateKeyFilePath, String apiV3Key, String weChatPayCertFilePath, String notifyUrl, String refundNotifyUrl) {
        this.appid = appid;
        this.secret = secret;
        this.mchid = mchid;
        this.mchSerialNo = mchSerialNo;
        this.privateKeyFilePath = privateKeyFilePath;
        this.apiV3Key = apiV3Key;
        this.weChatPayCertFilePath = weChatPayCertFilePath;
        this.notifyUrl = notifyUrl;
        this.refundNotifyUrl = refundNotifyUrl;
    }

    /**
     * 获取
     * @return appid
     */
    public String getAppid() {
        return appid;
    }

    /**
     * 设置
     * @param appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /**
     * 获取
     * @return secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     * 设置
     * @param secret
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * 获取
     * @return mchid
     */
    public String getMchid() {
        return mchid;
    }

    /**
     * 设置
     * @param mchid
     */
    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    /**
     * 获取
     * @return mchSerialNo
     */
    public String getMchSerialNo() {
        return mchSerialNo;
    }

    /**
     * 设置
     * @param mchSerialNo
     */
    public void setMchSerialNo(String mchSerialNo) {
        this.mchSerialNo = mchSerialNo;
    }

    /**
     * 获取
     * @return privateKeyFilePath
     */
    public String getPrivateKeyFilePath() {
        return privateKeyFilePath;
    }

    /**
     * 设置
     * @param privateKeyFilePath
     */
    public void setPrivateKeyFilePath(String privateKeyFilePath) {
        this.privateKeyFilePath = privateKeyFilePath;
    }

    /**
     * 获取
     * @return apiV3Key
     */
    public String getApiV3Key() {
        return apiV3Key;
    }

    /**
     * 设置
     * @param apiV3Key
     */
    public void setApiV3Key(String apiV3Key) {
        this.apiV3Key = apiV3Key;
    }

    /**
     * 获取
     * @return weChatPayCertFilePath
     */
    public String getWeChatPayCertFilePath() {
        return weChatPayCertFilePath;
    }

    /**
     * 设置
     * @param weChatPayCertFilePath
     */
    public void setWeChatPayCertFilePath(String weChatPayCertFilePath) {
        this.weChatPayCertFilePath = weChatPayCertFilePath;
    }

    /**
     * 获取
     * @return notifyUrl
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * 设置
     * @param notifyUrl
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    /**
     * 获取
     * @return refundNotifyUrl
     */
    public String getRefundNotifyUrl() {
        return refundNotifyUrl;
    }

    /**
     * 设置
     * @param refundNotifyUrl
     */
    public void setRefundNotifyUrl(String refundNotifyUrl) {
        this.refundNotifyUrl = refundNotifyUrl;
    }

    public String toString() {
        return "WeChatProperties{appid = " + appid + ", secret = " + secret + ", mchid = " + mchid + ", mchSerialNo = " + mchSerialNo + ", privateKeyFilePath = " + privateKeyFilePath + ", apiV3Key = " + apiV3Key + ", weChatPayCertFilePath = " + weChatPayCertFilePath + ", notifyUrl = " + notifyUrl + ", refundNotifyUrl = " + refundNotifyUrl + "}";
    }
}
