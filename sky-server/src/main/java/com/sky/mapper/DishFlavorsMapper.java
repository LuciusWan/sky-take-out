package com.sky.mapper;

import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishFlavorsMapper {
    //批量插入
    void insertBatch (List<DishFlavor> dishFlavors);
    //根据菜品数据删除口味数据
    @Delete("delete from dish_flavor where dish_id=#{dishId}")
    void deleteByDishId(Long dishId);

    void deleteByDishIds(List<Long> dishIds);
    @Select("select * from dish_flavor where dish_id=#{id}")
    List<DishFlavor> selectById(Long id);
}
