package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.OrderDetailsDao;
import com.aaa.springboothomestay.entity.OrdersDetails;
import com.aaa.springboothomestay.impl.service.OrderDetailsService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class OrderDetailsImpl implements OrderDetailsService {

    @Resource
    OrderDetailsDao orderDetailsDao;

    @Override
    public OrdersDetails SelectOrderOid(Integer oid) {
        OrdersDetails ordersDetails=new OrdersDetails();
        ordersDetails.setOid(oid);
        OrdersDetails ordersDetails1 = orderDetailsDao.selectOne(ordersDetails);
        return ordersDetails1;
    }

    @Override
    public Integer AddOrdersDetails(OrdersDetails ordersDetails) {

        return orderDetailsDao.insertSelective(ordersDetails);
    }
}
