package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.OrderDao;
import com.aaa.springboothomestay.entity.Orders;
import com.aaa.springboothomestay.impl.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrdersImpl implements OrdersService {

    @Resource
    OrderDao orderDao;


    @Override
    public List<Orders> findAllOrders(Integer uid,Integer status) {
        return orderDao.findAllOrders(uid,status);
    }

    @Override
    public List<Orders> finById(Integer id) {
        return orderDao.finById(id);
    }

    @Override
    public Integer updateChexiao(Orders orders) {
        return orderDao.updateChexiao(orders);
    }

    @Override
    public Integer updatetuifang(Orders orders) {
        return orderDao.updatetuifang(orders);
    }


}
