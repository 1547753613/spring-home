package com.aaa.springboothomestay.controller;
import com.aaa.springboothomestay.entity.Landlord;
import com.aaa.springboothomestay.impl.service.Land_LandIordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("muniao")
public class Land_LandIordController {
    @Autowired
    Land_LandIordService land_landIordService;

    @RequestMapping("tologin")
    public String LandLogin(){
        return "qiantai/denglu/index2";
    }

    //房东登录
    @PostMapping("/todenglu")
    public String login(String nickname, String pass, Model model){
        Landlord landlord = land_landIordService.findLandIord(nickname,pass);
        if(landlord == null || !pass.equals(landlord.getPass())) {
            return "qiantai/denglu/index2";
        }
        model.addAttribute("landlord",landlord);
        return "/qiantai/tujia";
    }
}
