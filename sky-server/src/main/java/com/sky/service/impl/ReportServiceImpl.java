package com.sky.service.impl;

import com.sky.dto.GoodsSalesDTO;
import com.sky.mapper.OrderMapper;
import com.sky.service.ReportService;
import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;
import io.swagger.v3.oas.models.security.SecurityScheme;
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

    @Override
    public UserReportVO userStatistics(LocalDate begin, LocalDate end) {
        UserReportVO userReportVO = new UserReportVO();
        List<LocalDate> list = new ArrayList<>();
        list.add(begin);
        while(!begin.equals(end)) {
            begin=begin.plusDays(1);
            list.add(begin);
        }
        List<Integer> totalUserList = new ArrayList<>();
        List<Integer> newUserList = new ArrayList<>();
        for (LocalDate date : list) {
            LocalDateTime beginTime = LocalDateTime.of(date, LocalTime.MIN);
            LocalDateTime endTime = LocalDateTime.of(date, LocalTime.MAX);
            Integer totalUser= orderMapper.totalUser(beginTime,endTime);
            Integer newUser= orderMapper.newUser(beginTime,endTime);
            totalUser =totalUser==null?0:totalUser;
            newUser =newUser==null?0:newUser;
            totalUserList.add(totalUser);
            newUserList.add(newUser);

        }
        String dateList=StringUtils.join(list,",");
        userReportVO.setDateList(dateList);
        String newUserList1=StringUtils.join(newUserList,",");
        String totalList=StringUtils.join(totalUserList,",");
        userReportVO.setNewUserList(newUserList1);
        userReportVO.setTotalUserList(totalList);
        return userReportVO;
    }

    @Override
    public OrderReportVO ordersStatistics(LocalDate begin, LocalDate end) {
        OrderReportVO orderReportVO = new OrderReportVO();
        List<LocalDate> list = new ArrayList<>();
        List<Integer> totalOrderList = new ArrayList<>();
        List<Integer> validOrderList = new ArrayList<>();
        list.add(begin);
        while(!begin.equals(end)) {
            begin=begin.plusDays(1);
            list.add(begin);
        }
        //获取订单总数
        Integer total= orderMapper.totalOrderCount();
        //获取总有效订单数
        Integer valid= orderMapper.validOrderCount();
        //计算订单完成率
        Double orderCompletionRate=valid/(double)total;
        //通过时间查询每日订单数
        for (LocalDate date : list) {
            //通过时间查询每日有效订单数
            LocalDateTime beginTime = LocalDateTime.of(date, LocalTime.MIN);
            LocalDateTime endTime = LocalDateTime.of(date, LocalTime.MAX);
            Integer totalOrders= orderMapper.totalOrders(beginTime,endTime);
            Integer validOrders= orderMapper.validOrders(beginTime,endTime);
            totalOrders =totalOrders==null?0:totalOrders;
            validOrders =validOrders==null?0:validOrders;
            totalOrderList.add(totalOrders);
            validOrderList.add(validOrders);

        }
        //转string格式构建VO返回
        String dateList=StringUtils.join(list,",");
        String totalList=StringUtils.join(totalOrderList,",");
        String validList=StringUtils.join(validOrderList,",");
        orderReportVO.setDateList(dateList);
        orderReportVO.setTotalOrderCount(total);
        orderReportVO.setOrderCompletionRate(orderCompletionRate);
        orderReportVO.setValidOrderCount(valid);
        orderReportVO.setOrderCountList(totalList);
        orderReportVO.setValidOrderCountList(validList);
        return orderReportVO;
    }

    @Override
    public SalesTop10ReportVO top10(LocalDate begin, LocalDate end) {
        SalesTop10ReportVO salesTop10ReportVO = new SalesTop10ReportVO();
        List<GoodsSalesDTO> list2 = new ArrayList<>();
        LocalDateTime beginTime = LocalDateTime.of(begin, LocalTime.MIN);
        LocalDateTime endTime = LocalDateTime.of(end, LocalTime.MAX);
        list2=orderMapper.saleTop10(beginTime,endTime);
        System.out.println(list2);
        List<String> name=new ArrayList<>();
        List<Integer> number=new ArrayList<>();
        for (GoodsSalesDTO goodsSalesDTO : list2) {
            name.add(goodsSalesDTO.getName());
            number.add(goodsSalesDTO.getNumber());
        }
        String nameList=StringUtils.join(name,",");
        String numberList=StringUtils.join(number,",");
        salesTop10ReportVO.setNameList(nameList);
        salesTop10ReportVO.setNumberList(numberList);
        return salesTop10ReportVO;
    }
}
