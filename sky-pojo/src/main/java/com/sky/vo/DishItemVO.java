package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


public class DishItemVO implements Serializable {

    //菜品名称
    private String name;

    //份数
    private Integer copies;

    //菜品图片
    private String image;

    //菜品描述
    private String description;
    private static final long serialVersionUID = 1L;
    public DishItemVO() {
    }

    public DishItemVO(String name, Integer copies, String image, String description) {
        this.name = name;
        this.copies = copies;
        this.image = image;
        this.description = description;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return copies
     */
    public Integer getCopies() {
        return copies;
    }

    /**
     * 设置
     * @param copies
     */
    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    /**
     * 获取
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "DishItemVO{name = " + name + ", copies = " + copies + ", image = " + image + ", description = " + description + "}";
    }
}
