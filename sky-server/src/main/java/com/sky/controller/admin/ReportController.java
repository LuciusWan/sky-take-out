package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.ReportService;
import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@Api(tags = "报告相关接口")
@RequestMapping("/admin/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @ApiOperation("营业额统计")
    @GetMapping("/turnoverStatistics")
    public Result<TurnoverReportVO> turnoverStatistics(
            @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate end) {
        TurnoverReportVO vo = new TurnoverReportVO();
        vo=reportService.turnoverStatistics(begin,end);
        return Result.success(vo);
    }
    @ApiOperation("用户统计")
    @GetMapping("/userStatistics")
    public Result<UserReportVO> userStatistics(
            @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate end) {
        UserReportVO vo = new UserReportVO();
        vo=reportService.userStatistics(begin,end);
        return Result.success(vo);
    }
    @ApiOperation("有效订单查询")
    @GetMapping("/ordersStatistics")
    public Result<OrderReportVO> ordersStatistics(
            @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate end
    ){
        OrderReportVO vo = reportService.ordersStatistics(begin,end);
        return Result.success(vo);
    }
    @ApiOperation("商品TOP10查询")
    @GetMapping("/top10")
    public Result<SalesTop10ReportVO> top10(
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate end
    ){
        SalesTop10ReportVO vo = new SalesTop10ReportVO();
        vo=reportService.top10(begin,end);
        return Result.success(vo);
    }

}
