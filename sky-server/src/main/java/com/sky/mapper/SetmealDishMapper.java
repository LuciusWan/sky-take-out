package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    //根据菜品id查询对应套餐id
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);
    void insertBatch(List<SetmealDish> setmealDishes);

    void delete(List<Long> ids);
    @Select("select * from setmeal_dish where setmeal_id =#{id}")
    List<SetmealDish> getDishBySetmealId(Long id);
}
