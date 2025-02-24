package com.sky.service.impl;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.sky.context.BaseContext;
import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.Dish;
import com.sky.entity.Setmeal;
import com.sky.entity.ShoppingCart;
import com.sky.mapper.DishFlavorsMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.mapper.ShoppingCartMapping;
import com.sky.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private SetmealMapper setmealMapper;
    @Autowired
    private DishFlavorsMapper dishFlavorsMapper;
    @Autowired
    private ShoppingCartMapping shoppingCartMapping;
    @Override
    public void add(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        BeanUtils.copyProperties(shoppingCartDTO, shoppingCart);
        Long userId = BaseContext.getCurrentId();
        shoppingCart.setUserId(userId);
        System.out.println(shoppingCart);
        List<ShoppingCart> list=shoppingCartMapping.select(shoppingCart);
        if(list!=null&&list.size()>0){
            ShoppingCart cart= list.get(0);
            cart.setNumber(cart.getNumber()+1);
            shoppingCartMapping.update(cart);
        }else{
            Long dishId=shoppingCart.getDishId();
            if(dishId==null){
                Setmeal setmeal=setmealMapper.getSetmealById(shoppingCart.getSetmealId());
                shoppingCart.setImage(setmeal.getImage());
                shoppingCart.setName(setmeal.getName());
                shoppingCart.setAmount(setmeal.getPrice());
            }
            else{
                Dish dish=dishMapper.selectById(dishId);
                shoppingCart.setImage(dish.getImage());
                shoppingCart.setName(dish.getName());
                shoppingCart.setAmount(dish.getPrice());
            }
            shoppingCart.setNumber(1);
            shoppingCart.setCreateTime(LocalDateTime.now());
            shoppingCartMapping.insert(shoppingCart);
        }
    }

    @Override
    public List<ShoppingCart> check() {
        Long userId = BaseContext.getCurrentId();
        return shoppingCartMapping.checkAll(userId);
    }

    @Override
    public void deleteOne(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        BeanUtils.copyProperties(shoppingCartDTO, shoppingCart);
        Long userId = BaseContext.getCurrentId();
        shoppingCart.setUserId(userId);
        List<ShoppingCart> list=shoppingCartMapping.select(shoppingCart);
        shoppingCart.setCreateTime(LocalDateTime.now());
        shoppingCart.setNumber(list.get(0).getNumber());
        System.out.println(shoppingCart);
        if(shoppingCart.getNumber()>1){
            shoppingCart.setNumber(shoppingCart.getNumber()-1);
            shoppingCartMapping.reduceOne(shoppingCart);
        }else{
            shoppingCartMapping.deleteOne(shoppingCart);
        }

    }

    @Override
    public void deleteAll() {
        Long userId = BaseContext.getCurrentId();
        shoppingCartMapping.deleteAll(userId);
    }
}
