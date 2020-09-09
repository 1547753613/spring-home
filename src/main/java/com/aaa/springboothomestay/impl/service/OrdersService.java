package com.aaa.springboothomestay.impl.service;
import com.aaa.springboothomestay.entity.Order;
import com.aaa.springboothomestay.entity.Orders;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface OrdersService {
    List<Orders> findAllOrders(Integer uid,Integer status);

    List<Orders>finById(Integer id);

    List<Orders> findShow(Integer status);

    Integer updateChexiao(Orders orders);


    Integer updatetuifang(Orders orders);

    Integer queren(Integer status);


    /**
     *
     * @return 分页查询查询所有订单
     */
    public PageInfo<Order> SelectOrdersAll(Integer pageNum, Integer pageSize, Integer id);

    /**
     * 查寻房间订单
     * @param id
     * @return
     */
    public Order SelectOrderId(Integer id);

    /**
     *
     * @param order 添加订单
     * @return
     */
    public Integer AddOrders(Order order);

}
