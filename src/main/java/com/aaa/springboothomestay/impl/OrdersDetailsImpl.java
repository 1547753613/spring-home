package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.OrdersDetailsDao;
import com.aaa.springboothomestay.entity.OrdersDetails;
import com.aaa.springboothomestay.impl.service.OrdersDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrdersDetailsImpl implements OrdersDetailsService {
    @Resource
    OrdersDetailsDao ordersDetailsDao;


    @Override
    public List<OrdersDetails> findAllOrdersDetails() {
        return ordersDetailsDao.findAllOrdersDetails();
    }
}
