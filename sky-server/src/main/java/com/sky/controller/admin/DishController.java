package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @DeleteMapping
    @ApiOperation("删除菜品接口")
    //前端传来的数据是1,2,3...如果要用集合去接受就要用到springboot框架的帮助，使用注解@RequestParam
    public Result deleteDish(@RequestParam List<Long> ids) {
        log.info("菜品批量删除{}",ids);
        dishService.delete(ids);
        return Result.success();
    }
    @ApiOperation("修改菜品第一步")
    @GetMapping("/{id}")
    public Result<DishVO> getDish(@PathVariable Long id) {
        DishVO dishVO=dishService.selectById(id);
        return Result.success(dishVO);
    }
    @ApiOperation("修改菜品第二步")
    @PutMapping
    public Result updateDish(@RequestBody DishDTO dishDTO) {
        dishService.update(dishDTO);
        return Result.success();
    }
    @ApiOperation("根据分类查询菜品")
    @GetMapping("/list")
    public Result<List<Dish>> getDishList(Long categoryId) {
        log.info("根据分类查询菜品{}",categoryId);
        List<Dish> list= dishService.selectByCategoryId(categoryId);
        return Result.success(list);
    }
    @PostMapping("status/{status}")
    public Result updateStatus(@PathVariable  Integer status ,Long id){
        log.info("修改菜品状态");
        dishService.changeStatus(status,id);
        return Result.success();
    }
}
