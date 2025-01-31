package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.mapper.DishFlavorsMapper;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

public interface DishService {
    void addDishAndFlavors(DishDTO dishDTO);

    PageResult select(DishPageQueryDTO dishPageQueryDTO);

    void delete(List<Long> ids);

    DishVO selectById(Long id);

    void update(DishDTO dishDTO);
}
