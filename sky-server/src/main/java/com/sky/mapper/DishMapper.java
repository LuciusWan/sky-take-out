package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);
    @AutoFill(OperationType.INSERT)
    void insert(Dish dish);

    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    Dish getById(Long id);
    //根据主键删除菜品数据
    @Delete("delete from dish where id=#{id}")
    void deleteById(Long id);

    void deleteByIds(List<Long> ids);
    @Select("select * from dish where id=#{id}")
    Dish selectById(Long id);
    @AutoFill(value=OperationType.UPDATE)
    void update(Dish dish);
    @Select("select * from dish where category_id=#{categoryId}")
    List<Dish> selectByCategoryId(Long categoryId);
}
