package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.Orders;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersService {
    List<Orders> findAllOrders(Integer uid,Integer status);

    List<Orders>finById(Integer id);



}
