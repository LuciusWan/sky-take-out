package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


public class OrderPaymentVO implements Serializable {

    private String nonceStr; //随机字符串
    private String paySign; //签名
    private String timeStamp; //时间戳
    private String signType; //签名算法
    private String packageStr; //统一下单接口返回的 prepay_id 参数值
    private static final long serialVersionUID = 1L;
    public OrderPaymentVO() {
    }

    public OrderPaymentVO(String nonceStr, String paySign, String timeStamp, String signType, String packageStr) {
        this.nonceStr = nonceStr;
        this.paySign = paySign;
        this.timeStamp = timeStamp;
        this.signType = signType;
        this.packageStr = packageStr;
    }

    /**
     * 获取
     * @return nonceStr
     */
    public String getNonceStr() {
        return nonceStr;
    }

    /**
     * 设置
     * @param nonceStr
     */
    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    /**
     * 获取
     * @return paySign
     */
    public String getPaySign() {
        return paySign;
    }

    /**
     * 设置
     * @param paySign
     */
    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }

    /**
     * 获取
     * @return timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * 设置
     * @param timeStamp
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * 获取
     * @return signType
     */
    public String getSignType() {
        return signType;
    }

    /**
     * 设置
     * @param signType
     */
    public void setSignType(String signType) {
        this.signType = signType;
    }

    /**
     * 获取
     * @return packageStr
     */
    public String getPackageStr() {
        return packageStr;
    }

    /**
     * 设置
     * @param packageStr
     */
    public void setPackageStr(String packageStr) {
        this.packageStr = packageStr;
    }

    public String toString() {
        return "OrderPaymentVO{nonceStr = " + nonceStr + ", paySign = " + paySign + ", timeStamp = " + timeStamp + ", signType = " + signType + ", packageStr = " + packageStr + "}";
    }
}
