package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


public class UserReportVO implements Serializable {

    //日期，以逗号分隔，例如：2022-10-01,2022-10-02,2022-10-03
    private String dateList;

    //用户总量，以逗号分隔，例如：200,210,220
    private String totalUserList;

    //新增用户，以逗号分隔，例如：20,21,10
    private String newUserList;
    private static final long serialVersionUID = 1L;
    public UserReportVO() {
    }

    public UserReportVO(String dateList, String totalUserList, String newUserList) {
        this.dateList = dateList;
        this.totalUserList = totalUserList;
        this.newUserList = newUserList;
    }

    /**
     * 获取
     * @return dateList
     */
    public String getDateList() {
        return dateList;
    }

    /**
     * 设置
     * @param dateList
     */
    public void setDateList(String dateList) {
        this.dateList = dateList;
    }

    /**
     * 获取
     * @return totalUserList
     */
    public String getTotalUserList() {
        return totalUserList;
    }

    /**
     * 设置
     * @param totalUserList
     */
    public void setTotalUserList(String totalUserList) {
        this.totalUserList = totalUserList;
    }

    /**
     * 获取
     * @return newUserList
     */
    public String getNewUserList() {
        return newUserList;
    }

    /**
     * 设置
     * @param newUserList
     */
    public void setNewUserList(String newUserList) {
        this.newUserList = newUserList;
    }

    public String toString() {
        return "UserReportVO{dateList = " + dateList + ", totalUserList = " + totalUserList + ", newUserList = " + newUserList + "}";
    }
}
