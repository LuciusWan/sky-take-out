package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
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
    /**
     * 条件查询菜品和口味
     * @param dish
     * @return
     */
    List<DishVO> listWithFlavor(Dish dish);
    List<Dish> selectByCategoryId(Long categoryId);
}
