package com.aaa.springboothomestay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("muniao")
public class PersonageController {

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "/qiantai/muniao";
    }
}
