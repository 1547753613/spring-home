package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.Housetype;
import com.aaa.springboothomestay.impl.HouseTypeImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RequestMapping("HouseType")
@Controller
public class HouseTypeController {
    @Resource
    HouseTypeImpl houseTypeimp;
    @RequestMapping("insert")
    @ResponseBody
    public int insert(Housetype housetype)
    {
        return houseTypeimp.insert(housetype);
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(Housetype housetype)
    {
        return houseTypeimp.update(housetype);
    }
    @RequestMapping("delete")
    @ResponseBody
    public int delete(int id)
    {
        return houseTypeimp.delete(id);
    }
    @RequestMapping("querybyname")
    @ResponseBody
    public int querybyname(Housetype housetype)
    {
        return houseTypeimp.querybyname(housetype).size();
    }@RequestMapping("query")
    @ResponseBody
    public List<Housetype> query()
    {
        return houseTypeimp.query();
    }
}
