package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.House;
import com.aaa.springboothomestay.entity.HouseSup;
import com.aaa.springboothomestay.impl.HouseSupImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@CrossOrigin
@RequestMapping("HouseSup")
@Controller
public class HouseSupController {
    @Resource
    HouseSupImpl houseSupimp;
    @RequestMapping("insert")
    public String insert(HouseSup houseSup)
    {
        return houseSupimp.insert(houseSup)+"";
    }
    @RequestMapping("udpate")
    public String update(HouseSup houseSup)
    {
        return houseSupimp.update(houseSup)+"";
    }
    @RequestMapping("delete")
    public String delete(HouseSup houseSup)
    {
        return houseSupimp.delete(houseSup)+"";
    }
    @RequestMapping("query")
    public String query()
    {
        return houseSupimp.query().toString();
    }
}
