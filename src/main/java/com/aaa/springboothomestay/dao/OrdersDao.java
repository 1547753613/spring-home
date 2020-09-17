package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.Order;
import com.aaa.springboothomestay.entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrdersDao extends Mapper<Order> {

    @Select("select * from orders o \n" +
            "LEFT JOIN orders_details od on od.oid=o.id\n" +
            "where  o.hid=#{id} and (o.status=3 or o.status=1 or o.status=2 or o.status=4 ) ORDER  by o.id DESC")
    public List<Order> SelectOrderId(@Param("id") Integer id);
}
