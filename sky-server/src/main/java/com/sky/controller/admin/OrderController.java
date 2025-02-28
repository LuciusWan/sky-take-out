package com.sky.controller.admin;

import com.sky.dto.OrdersCancelDTO;
import com.sky.dto.OrdersConfirmDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.dto.OrdersRejectionDTO;
import com.sky.entity.Orders;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrderService;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("adminOrderController")
@RequestMapping("/admin/order")
@Slf4j
@Api(tags = "admin端订单接口")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/conditionSearch")
    @ApiOperation("订单搜索")
    public Result<PageResult> adminCheckOrder(OrdersPageQueryDTO ordersPageQueryDTO) {
        log.info("管理端查询订单");
        PageResult page= orderService.adminCheckOrder(ordersPageQueryDTO);
        return Result.success(page);
    }
    @GetMapping("/details/{id}")
    @ApiOperation("查询订单详情")
    public Result<OrderVO> adminCheckOrder(@PathVariable Long id) {
        log.info("查询订单详情");
        OrderVO orderVO=orderService.checkOrder(id);
        return Result.success(orderVO);
    }
    @PutMapping("/confirm")
    @ApiOperation("接单")
    public Result adminConfirm(@RequestBody OrdersConfirmDTO ordersConfirmDTO) {
        log.info("接单");
        orderService.adminConfirm(ordersConfirmDTO);
        return Result.success();
    }
    @PutMapping("/rejection")
    @ApiOperation("拒单")
    public Result adminRejection(@RequestBody OrdersRejectionDTO ordersRejectionDTO) {
        log.info("拒单");
        orderService.adminRejection(ordersRejectionDTO);
        return Result.success();
    }
    @PutMapping("/cancel")
    @ApiOperation("取消订单")
    public Result adminCancel(@RequestBody OrdersCancelDTO ordersCancelDTO) {
        log.info("取消订单");
        orderService.adminCancel(ordersCancelDTO);
        return Result.success();
    }
    @GetMapping("statistics")
    @ApiOperation("各个状态订单数量统计")
    public Result<OrderStatisticsVO> adminStatistics() {
        OrderStatisticsVO orderStatisticsVO= orderService.checkStatistics();
        return Result.success(orderStatisticsVO);
    }
    @PutMapping("/delivery/{id}")
    @ApiOperation("派送订单")
    public Result adminCancel(@PathVariable Long id) {
        log.info("派送订单");
        orderService.adminDelivery(id);
        return Result.success();
    }
    @PutMapping("/complete/{id}")
    @ApiOperation("完成订单")
    public Result adminComplete(@PathVariable Long id) {
        log.info("完成订单");
        orderService.adminComplete(id);
        return Result.success();
    }
}
