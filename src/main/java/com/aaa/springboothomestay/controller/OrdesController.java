package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.Orders;
import com.aaa.springboothomestay.entity.User;
import com.aaa.springboothomestay.impl.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("muniao")
public class OrdesController {
    @Resource
    private OrdersService ordersService;

    @RequestMapping("/toList")
    public String toList(Model model, HttpSession httpSession){
        User map = (User) httpSession.getAttribute("user");
        int uid = map.getUid();

        List<Orders> list = ordersService.findAllOrders(uid);
        model.addAttribute("list",list);
        return "/qiantai/orders";
    }
}
