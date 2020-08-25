package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.User;
import com.aaa.springboothomestay.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("muniao")
public class UserController {
    /**
     * 罗元超登陆
     */
    @Autowired
    UserImpl userimpl;
    @RequestMapping("/login")
    public String yuan()
    {
        return "qiantai/denglu/index";
    }
    @PostMapping("/denglu")
    public String login(String uname, String pass, Model model){

        User user = userimpl.findByDenglu(uname,pass);
        if(user == null || !pass.equals(user.getPass())) {
            return "qiantai/denglu/index";
        }
        model.addAttribute("user",user);
        return "/qiantai/muniao";
    }

}
