package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.OrderDao;
import com.aaa.springboothomestay.dao.OrdersDao;
import com.aaa.springboothomestay.entity.Admins;
import com.aaa.springboothomestay.entity.Orders;
import com.aaa.springboothomestay.impl.service.HouseService;
import com.aaa.springboothomestay.impl.service.OrderDetailsService;
import com.aaa.springboothomestay.impl.service.OrdersService;
import com.aaa.springboothomestay.impl.service.UsersService;
import com.aaa.springboothomestay.util.PageEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.springboothomestay.entity.Order;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrdersImpl implements OrdersService {

    @Autowired
    HouseService houseService;

    @Resource
    OrderDao orderDao;

    @Autowired
    OrderDetailsService orderDetailsService;

    @Autowired
    UsersService usersService;

    @Resource
    OrdersDao ordersDao;

    @Override
    public List<Orders> findAllOrders(Integer uid,Integer status) {
        return orderDao.findAllOrders(uid,status);
    }

    @Override
    public List<Orders> finById(Integer id) {
        return orderDao.finById(id);
    }

    @Override
    public List<Orders> findShow(Integer status) {
        return orderDao.findShow(status);
    }

    @Override
    public Integer updateChexiao(Orders orders) {
        return orderDao.updateChexiao(orders);
    }

    @Override
    public Integer updatetuifang(Orders orders) {
        return orderDao.updatetuifang(orders);
    }

    /**
     *
     * @return
     */
    @Override
    public PageInfo<Order> SelectOrdersAll(Integer pageNum, Integer pageSize, Integer id) {
        List<Order> orders=null;
        PageEntity pageEntity=new PageEntity(pageNum,pageSize);
        PageHelper.startPage(pageEntity.getPageNum(),pageEntity.getPageSize());
        if (null==id){
            orders = ordersDao.selectAll();
        }else{
            Order order=new Order();
            order.setId(id);
            orders=ordersDao.select(order);
        }


        for (Order o:orders){
            o.setOrdersDetails(orderDetailsService.SelectOrderOid(o.getId()));
            o.setHouse(houseService.QueryHouseHid(o.getHid()));
            o.setUser(usersService.SelectUserId(o.getUid()));
        }
        PageInfo<Order> pageInfo= new PageInfo<Order>(orders);

        return pageInfo;

    }

    @Override
    public Integer queren(Integer status) {
        return orderDao.queren(status);
    }


}
