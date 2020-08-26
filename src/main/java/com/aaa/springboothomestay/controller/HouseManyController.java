package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.HouseMany;
import com.aaa.springboothomestay.impl.HouseManyImpl;
import com.aaa.springboothomestay.impl.service.HouseManyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@CrossOrigin
@RequestMapping("HouseMany")
@Controller
public class HouseManyController {
    @Resource
    HouseManyImpl houseManyimpl;
    @RequestMapping("insert")
    public String insert(HouseMany houseMany)
    {
        return houseManyimpl.insert(houseMany)+"";
    }
    @RequestMapping("update")
    public String update(HouseMany houseMany)
    {
        return houseManyimpl.update(houseMany)+"";
    }
    @RequestMapping("delete")
    public String delete(HouseMany houseMany)
    {
        return houseManyimpl.delete(houseMany)+"";
    }
    @RequestMapping("query")
    public String query()
    {
        return houseManyimpl.query().toString();
    }
}
