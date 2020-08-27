package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.Orders;
import com.aaa.springboothomestay.entity.User;
import com.aaa.springboothomestay.impl.service.OrdersService;
import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("muniao")
public class OrdesController {
    @Resource
    private OrdersService ordersService;

    @RequestMapping(value = "/toList",method = RequestMethod.GET)
    public String toList(@RequestParam(value = "status",required = false) Integer status, Model model, HttpSession httpSession){
        User map = (User) httpSession.getAttribute("user");
        Integer uid = map.getUid();
        System.out.println(status);
        List<Orders> list = ordersService.findAllOrders(uid,status);
        model.addAttribute("list",list);
        return "/qiantai/orders";
    }
}
