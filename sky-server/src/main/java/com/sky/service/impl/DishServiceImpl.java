package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.entity.Employee;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.DishFlavorsMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealDishMapper;
import com.sky.result.PageResult;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class DishServiceImpl implements DishService {
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishFlavorsMapper dishFlavorsMapper;
    @Autowired
    private SetmealDishMapper setmealDishMapper;
    @Override
    @Transactional
    public void addDishAndFlavors(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);
        dishMapper.insert(dish);
        Long id = dish.getId();
        List<DishFlavor> list=dishDTO.getFlavors();
        if(list!=null&&list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setDishId(id);
            }
            dishFlavorsMapper.insertBatch(list);
        }
    }

    @Override
    public PageResult select(DishPageQueryDTO dishPageQueryDTO) {
        PageResult pageResult = new PageResult();
        PageHelper.startPage(dishPageQueryDTO.getPage(),dishPageQueryDTO.getPageSize());
        //按照PageHelper的要求，用Page<Employee>接收需要返回的参数
        //进入mapper层后通过动态SQL语句实现模糊查询和分页查询，返回结果为总内容数和数据内容
        //返回结果是DishVO和一些其他属性VO是后端打包好的数据，好提交给前端，DTO是前端发过来的，entity是具体类
        Page<DishVO> page=dishMapper.pageQuery(dishPageQueryDTO);
        pageResult.setTotal(page.getTotal());
        pageResult.setRecords(page.getResult());
        return pageResult;
    }
    //业务规则:
    //可以一次删除一个菜品，也可以批量删除菜品
    //起售中的菜品不能删除
    //被套餐关联的菜品不能删除
    //删除菜品后，关联的口味数据也需要删除掉
    @Override
    @Transactional
    public void delete(List<Long> ids) {
        //判断字段status是否是0
        for (Long id : ids) {
            Dish dish=dishMapper.getById(id);
            if(dish.getStatus()== StatusConstant.ENABLE){
                //商品正在起售中，不能删除
                throw new DeletionNotAllowedException(MessageConstant.DISH_ON_SALE);
            }
        }
        List<Long> setmealIds= setmealDishMapper.getSetmealIdsByDishIds(ids);
        if(setmealIds!=null&&setmealIds.size()>0){
            throw new DeletionNotAllowedException(MessageConstant.DISH_BE_RELATED_BY_SETMEAL);
        }
        //动态SQL删除
        dishMapper.deleteByIds(ids);
        dishFlavorsMapper.deleteByDishIds(ids);
    }

    @Override
    public DishVO selectById(Long id) {
        DishVO dishVO=new DishVO();
        Dish dish=dishMapper.selectById(id);
        BeanUtils.copyProperties(dish,dishVO);
        List<DishFlavor> dishFlavor=dishFlavorsMapper.selectById(id);
        dishVO.setFlavors(dishFlavor);
        return dishVO;
    }

    @Override
    public void update(DishDTO dishDTO) {
        Dish dish=new Dish();
        BeanUtils.copyProperties(dishDTO,dish);
        dishMapper.update(dish);
        //业务逻辑:先删除对应所有口味，再重新插入来更新
        dishFlavorsMapper.deleteByDishId(dishDTO.getId());
        List<DishFlavor> list=dishDTO.getFlavors();
        if(list!=null&&list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setDishId(dishDTO.getId());
            }
            dishFlavorsMapper.insertBatch(list);
        }
    }
}
