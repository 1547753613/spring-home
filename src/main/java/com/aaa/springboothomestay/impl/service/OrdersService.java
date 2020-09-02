package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.Order;
import com.aaa.springboothomestay.entity.Orders;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersService {
    List<Orders> findAllOrders(Integer uid,Integer status);

    List<Orders>finById(Integer id);

    Integer updateChexiao(Orders orders);


    Integer updatetuifang(Orders orders);

    /**
     *
     * @return 分页查询查询所有订单
     */
    public PageInfo<Order> SelectOrdersAll(Integer pageNum, Integer pageSize, Integer id);

}
