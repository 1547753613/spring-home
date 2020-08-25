package com.aaa.springboothomestay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("muniao")
public class MuniaoController {
    @RequestMapping("/a")
    public String a(){
        return "/qiantai/index";
    }
}
