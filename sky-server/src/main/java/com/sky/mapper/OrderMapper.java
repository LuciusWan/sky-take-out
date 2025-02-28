package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import com.sky.vo.DishVO;
import com.sky.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderMapper {
    void insert(Orders orders);
    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);
    @Select("select * from orders where id=#{id}")
    Orders checkOrder(Long id);
    @Update("update orders set status=#{status},cancel_reason=#{cancelReason},cancel_time=#{cancelTime} where id=#{id}")
    void update(Orders orders);
    @Select("select count(*) from orders where status=3")
    Integer checkConfirms();
    @Select("select count(*) from orders where status=4")
    Integer checkDeliveryInProgress();
    @Select("select count(*) from orders where status=2")
    Integer checkToBeConfirmed();

    void delivery(Long id);
}
