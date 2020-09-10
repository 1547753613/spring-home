package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

//    List<Orders> findAllOrders(Integer uid);id

    List<Orders> findAllOrders(@Param("uid") Integer uid,@Param("status")Integer status);



    //订单详情
    List<Orders>finById(Integer id);

    //跳转撤销申请页面
    List<Orders> findShow(Integer status);

    //撤销订单
    Integer updateChexiao(Orders orders);

    //退房
    Integer updatetuifang(Orders orders);

    //确认
    Integer queren(Integer status);

    List<Orders> bylidquery(@Param("lid") Integer lid,@Param("status") Integer status);
    Integer updatebyoid(@Param("oid")Integer oid,@Param("status")Integer status);


}
