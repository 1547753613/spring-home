package com.aaa.springboothomestay.controller.back;

import com.aaa.springboothomestay.entity.House;
import com.aaa.springboothomestay.impl.service.HouseService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/house")
public class Housecontroller {
    @Autowired
    HouseService houseService;

    @GetMapping("select")
    public PageInfo<House> PageInfoHouse(Integer pageNum,Integer pageSize,String realname){
        return houseService.PageInfoHouse(pageNum, pageSize, realname);
    }

    @PostMapping("select")
    public House findHouseHid(Integer hid){
        return  houseService.QueryHouseHid(hid);
    }
}
