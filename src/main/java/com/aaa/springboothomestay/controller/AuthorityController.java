package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.impl.service.AuthorityService;
import com.aaa.springboothomestay.util.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/authority")
public class AuthorityController {

    @Autowired
    AuthorityService authorityService;

    @GetMapping("/queryall")
    public List<Authority> QueryAuthory(){
        return authorityService.QueryAuthority(0);
    }
}
