package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


public class TurnoverReportVO implements Serializable {

    //日期，以逗号分隔，例如：2022-10-01,2022-10-02,2022-10-03
    private String dateList;

    //营业额，以逗号分隔，例如：406.0,1520.0,75.0
    private String turnoverList;

    public TurnoverReportVO() {
    }

    public TurnoverReportVO(String dateList, String turnoverList) {
        this.dateList = dateList;
        this.turnoverList = turnoverList;
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
     * @return turnoverList
     */
    public String getTurnoverList() {
        return turnoverList;
    }

    /**
     * 设置
     * @param turnoverList
     */
    public void setTurnoverList(String turnoverList) {
        this.turnoverList = turnoverList;
    }

    public String toString() {
        return "TurnoverReportVO{dateList = " + dateList + ", turnoverList = " + turnoverList + "}";
    }
}
