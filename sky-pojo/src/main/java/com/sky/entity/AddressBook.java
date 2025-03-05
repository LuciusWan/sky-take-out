package com.sky.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 地址簿
 */

public class AddressBook implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    //用户id
    private Long userId;

    //收货人
    private String consignee;

    //手机号
    private String phone;

    //性别 0 女 1 男
    private String sex;

    //省级区划编号
    private String provinceCode;

    //省级名称
    private String provinceName;

    //市级区划编号
    private String cityCode;

    //市级名称
    private String cityName;

    //区级区划编号
    private String districtCode;

    //区级名称
    private String districtName;

    //详细地址
    private String detail;

    //标签
    private String label;

    //是否默认 0否 1是
    private Integer isDefault;

    public AddressBook() {
    }

    public AddressBook(long serialVersionUID, Long id, Long userId, String consignee, String phone, String sex, String provinceCode, String provinceName, String cityCode, String cityName, String districtCode, String districtName, String detail, String label, Integer isDefault) {

        this.id = id;
        this.userId = userId;
        this.consignee = consignee;
        this.phone = phone;
        this.sex = sex;
        this.provinceCode = provinceCode;
        this.provinceName = provinceName;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.districtCode = districtCode;
        this.districtName = districtName;
        this.detail = detail;
        this.label = label;
        this.isDefault = isDefault;
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

    /**
     * 获取
     * @return consignee
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * 设置
     * @param consignee
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
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
     * @return provinceCode
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 设置
     * @param provinceCode
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * 获取
     * @return provinceName
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * 设置
     * @param provinceName
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * 获取
     * @return cityCode
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置
     * @param cityCode
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * 获取
     * @return cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 获取
     * @return districtCode
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * 设置
     * @param districtCode
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * 获取
     * @return districtName
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * 设置
     * @param districtName
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * 获取
     * @return detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置
     * @param detail
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * 获取
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * 设置
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 获取
     * @return isDefault
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * 设置
     * @param isDefault
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String toString() {
        return "AddressBook{serialVersionUID = " + serialVersionUID + ", id = " + id + ", userId = " + userId + ", consignee = " + consignee + ", phone = " + phone + ", sex = " + sex + ", provinceCode = " + provinceCode + ", provinceName = " + provinceName + ", cityCode = " + cityCode + ", cityName = " + cityName + ", districtCode = " + districtCode + ", districtName = " + districtName + ", detail = " + detail + ", label = " + label + ", isDefault = " + isDefault + "}";
    }
}
