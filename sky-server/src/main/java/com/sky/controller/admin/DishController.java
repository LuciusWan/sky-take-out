package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/dish")
@Api(tags = "菜品相关接口")
@Slf4j
public class DishController {
    @Autowired
    DishService dishService;
    @PostMapping
    @ApiOperation("菜品添加")
    public Result addDish(@RequestBody DishDTO dishDTO) {
        log.info("新增菜品{}", dishDTO);
        dishService.addDishAndFlavors(dishDTO);
        return Result.success();
    }
    @GetMapping("/page")
    @ApiOperation("分页查询菜品")
    public Result<PageResult> getDishPage(DishPageQueryDTO dishPageQueryDTO) {
        log.info("分页查询菜品{}", dishPageQueryDTO);
        PageResult pageResult=dishService.select(dishPageQueryDTO);
        log.info("分页查询结果{}", pageResult);
        return Result.success(pageResult);
    }
}
