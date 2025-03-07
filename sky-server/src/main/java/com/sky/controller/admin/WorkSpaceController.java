package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.service.OrderService;
import com.sky.service.SetmealService;
import com.sky.vo.BusinessDataVO;
import com.sky.vo.DishOverViewVO;
import com.sky.vo.OrderOverViewVO;
import com.sky.vo.SetmealOverViewVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin/workspace")
@RestController
@Api(tags = "工作台相关接口")
public class WorkSpaceController {
    @Autowired
    private DishService dishService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private SetmealService setmealService;
    @GetMapping("/overviewDishes")
    @ApiOperation("餐品总览")
    public Result<DishOverViewVO> overviewDishes() {
        DishOverViewVO vo = dishService.overviewDishes();
        return Result.success(vo);
    }
    @GetMapping("/overviewSetmeals")
    @ApiOperation("餐品总览")
    public Result<SetmealOverViewVO> overviewSetmeals() {
        SetmealOverViewVO vo = setmealService.overviewSetmeals();
        return Result.success(vo);
    }
    @GetMapping("/overviewOrders")
    @ApiOperation("餐品总览")
    public Result<OrderOverViewVO> overviewOrders() {
        OrderOverViewVO vo = orderService.overviewOrders();
        return Result.success(vo);
    }
    @GetMapping("/businessData")
    @ApiOperation("餐品总览")
    public Result<BusinessDataVO> overviewBusinessData() {
        BusinessDataVO vo = orderService.overviewBusinessData();
        return Result.success(vo);
    }
}
