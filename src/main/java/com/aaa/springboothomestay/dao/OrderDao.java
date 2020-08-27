package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

//    List<Orders> findAllOrders(Integer uid);id

    List<Orders> findAllOrders(@Param("uid") Integer uid,@Param("status")Integer status);
}
