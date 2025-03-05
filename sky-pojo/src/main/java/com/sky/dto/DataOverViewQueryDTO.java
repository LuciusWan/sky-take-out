package com.sky.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


public class DataOverViewQueryDTO implements Serializable {

    private LocalDateTime begin;

    private LocalDateTime end;

    public DataOverViewQueryDTO() {
    }

    public DataOverViewQueryDTO(LocalDateTime begin, LocalDateTime end) {
        this.begin = begin;
        this.end = end;
    }

    /**
     * 获取
     * @return begin
     */
    public LocalDateTime getBegin() {
        return begin;
    }

    /**
     * 设置
     * @param begin
     */
    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    /**
     * 获取
     * @return end
     */
    public LocalDateTime getEnd() {
        return end;
    }

    /**
     * 设置
     * @param end
     */
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String toString() {
        return "DataOverViewQueryDTO{begin = " + begin + ", end = " + end + "}";
    }
}
