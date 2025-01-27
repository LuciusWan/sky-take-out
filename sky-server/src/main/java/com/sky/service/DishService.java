package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

public interface DishService {
    void addDishAndFlavors(DishDTO dishDTO);

    PageResult select(DishPageQueryDTO dishPageQueryDTO);
}
