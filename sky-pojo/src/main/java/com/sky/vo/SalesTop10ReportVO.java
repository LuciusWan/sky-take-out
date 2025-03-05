package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


public class SalesTop10ReportVO implements Serializable {

    //商品名称列表，以逗号分隔，例如：鱼香肉丝,宫保鸡丁,水煮鱼
    private String nameList;

    //销量列表，以逗号分隔，例如：260,215,200
    private String numberList;
    private static final long serialVersionUID = 1L;
    public SalesTop10ReportVO() {
    }

    public SalesTop10ReportVO(String nameList, String numberList) {
        this.nameList = nameList;
        this.numberList = numberList;
    }

    /**
     * 获取
     * @return nameList
     */
    public String getNameList() {
        return nameList;
    }

    /**
     * 设置
     * @param nameList
     */
    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    /**
     * 获取
     * @return numberList
     */
    public String getNumberList() {
        return numberList;
    }

    /**
     * 设置
     * @param numberList
     */
    public void setNumberList(String numberList) {
        this.numberList = numberList;
    }

    public String toString() {
        return "SalesTop10ReportVO{nameList = " + nameList + ", numberList = " + numberList + "}";
    }
}
