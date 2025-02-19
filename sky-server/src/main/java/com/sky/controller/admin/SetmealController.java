package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;

import com.sky.vo.SetmealVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/setmeal")
@Api(tags = "套餐相关接口")
@Slf4j
public class SetmealController {
    @Autowired
    private SetmealService setmealService;
    @GetMapping("/page")
    public Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO){
        log.info("分页查询{}",setmealPageQueryDTO);
        PageResult pageResult=setmealService.pageQuery(setmealPageQueryDTO);
        return Result.success(pageResult);
    }
    @PostMapping
    public Result save(@RequestBody SetmealDTO setmealDTO){
        log.info("新增套餐{}",setmealDTO);
        setmealService.save(setmealDTO);
        return Result.success();
    }
    @DeleteMapping
    public Result delete(@RequestParam List<Long> ids){
        log.info("批量删除/删除{}",ids);
        setmealService.delete(ids);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result<SetmealVO> get(@PathVariable Long id){
        log.info("修改套餐第一步,套餐id为{}",id);
        SetmealVO setmealVO=setmealService.getById(id);
        return Result.success(setmealVO);
    }
    @PutMapping
    public Result update(@RequestBody SetmealDTO setmealDTO){
        setmealService.update(setmealDTO);
        return Result.success();
    }
    @PostMapping("status/{status}")
    public Result updateStatus(@PathVariable  Integer status ,Long id){
        log.info("修改套餐状态");
        setmealService.changeStatus(status,id);
        return Result.success();
    }
}
