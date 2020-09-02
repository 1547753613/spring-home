package com.aaa.springboothomestay.controller.back;

import com.aaa.springboothomestay.entity.Order;
import com.aaa.springboothomestay.impl.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrdersService ordersService;

    @GetMapping("select")
    public PageInfo<Order> PageOrders(Integer pageNum, Integer pageSize, Integer id){
        return ordersService.SelectOrdersAll(pageNum, pageSize, id);
    }
}
