package com.sky.service.impl;

import com.sky.mapper.OrderMapper;
import com.sky.service.ReportService;
import com.sky.vo.TurnoverReportVO;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public TurnoverReportVO turnoverStatistics(LocalDate begin, LocalDate end) {
        List<LocalDate> list = new ArrayList<>();
        list.add(begin);
        while(!begin.equals(end)) {
            begin=begin.plusDays(1);
            list.add(begin);
        }
        List<Double> amount = new ArrayList<>();
        for (LocalDate date : list) {
            LocalDateTime beginTime = LocalDateTime.of(date, LocalTime.MIN);
            LocalDateTime endTime = LocalDateTime.of(date, LocalTime.MAX);
            Double turnover= orderMapper.turnover(beginTime,endTime);
            turnover =turnover==null?0.0:turnover;
            amount.add(turnover);
        }
        String dateList=StringUtils.join(list,",");
        String amountList=StringUtils.join(amount,",");
        TurnoverReportVO turnoverReportVO = new TurnoverReportVO();
        turnoverReportVO.setDateList(dateList);
        turnoverReportVO.setTurnoverList(amountList);
        //turnover要统计当天已完成的订单
        return turnoverReportVO;
    }
}
