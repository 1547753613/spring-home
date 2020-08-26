package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.HouseGeneralize;
import com.aaa.springboothomestay.impl.HouseGeneralizeImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RequestMapping("HouseGeneralize")
@Controller
public class HouseGeneralizeController {
    @Resource
    HouseGeneralizeImpl houseGeneralizeimp;
    @RequestMapping("insert")
    @ResponseBody
    public int insert(HouseGeneralize houseGeneralize)
    {
        return houseGeneralizeimp.insert(houseGeneralize);
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(HouseGeneralize houseGeneralize)
    {
        return houseGeneralizeimp.update(houseGeneralize);
    }
    @RequestMapping("delete")
    @ResponseBody
    public int delete(HouseGeneralize houseGeneralize)
    {
        return houseGeneralizeimp.delete(houseGeneralize);
    }
    @RequestMapping("query")
    @ResponseBody
    public List<HouseGeneralize> query()
    {
        return houseGeneralizeimp.query();
    }
}
