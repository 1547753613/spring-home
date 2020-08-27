package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.Orders;
import com.aaa.springboothomestay.entity.User;
import com.aaa.springboothomestay.impl.service.OrdersService;
import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("muniao")
public class OrdesController {
    @Resource
    private OrdersService ordersService;

    /**
     * 查询所有订单
     * @param model
     * @param httpSession
     * @return
     */


    @RequestMapping("/toList")
    public String toList(Model model, HttpSession httpSession,Integer status){
        System.out.println(status);
        User map = (User) httpSession.getAttribute("user");
        Integer uid = map.getUid();

        List<Orders> list = ordersService.findAllOrders(uid,status);
        model.addAttribute("list",list);
        return "/qiantai/orders";
    }
    @RequestMapping("/toOrder")
    @ResponseBody
    public List<Orders> toOrder( HttpSession httpSession,Integer status){
        User map = (User) httpSession.getAttribute("user");
        Integer uid = map.getUid();

        List<Orders> list = ordersService.findAllOrders(uid,status);

        return list;
    }



}
