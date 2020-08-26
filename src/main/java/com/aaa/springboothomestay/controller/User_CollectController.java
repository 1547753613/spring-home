package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.Collect;
import com.aaa.springboothomestay.entity.User;
import com.aaa.springboothomestay.impl.service.User_CollectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
@RequestMapping("muniao")
public class User_CollectController {

    @Resource
    private User_CollectService user_collectService;



    @RequestMapping("/findCollect")
    public String findCollect(Model model, HttpSession httpSession){
        Collect collect = new Collect();
        User map = (User) httpSession.getAttribute("user");
        int uid = map.getUid();
        collect.setUid(uid);
        List<Collect> list = user_collectService.findAllCollect(collect);
        model.addAttribute("list",list);
        return "/qiantai/user-collect";
    }
}
