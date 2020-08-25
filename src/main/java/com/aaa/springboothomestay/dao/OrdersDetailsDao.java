package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.OrdersDetails;

import java.util.List;

public interface OrdersDetailsDao {
    List<OrdersDetails> findAllOrdersDetails();
}
