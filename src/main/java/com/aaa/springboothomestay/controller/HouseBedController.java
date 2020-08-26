package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.HouseBed;
import com.aaa.springboothomestay.impl.HouseBedImpl;
import com.aaa.springboothomestay.impl.service.HouseBedService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RequestMapping("HouseBed")
@Controller
public class HouseBedController {
    @Resource
    HouseBedImpl houseBedService;
    @RequestMapping("insert")
    @ResponseBody
    public int insert(HouseBed houseBed)
    {
        return houseBedService.insert(houseBed);
    }
    @RequestMapping("update")
    @ResponseBody
    public int udpate(HouseBed houseBed)
    {
        return houseBedService.update(houseBed);
    }@RequestMapping("delete")
    @ResponseBody
    public int delete(HouseBed houseBed)
    {
        return houseBedService.insert(houseBed);
    }
    @RequestMapping("query")
    @ResponseBody
    public List<HouseBed> query()
    {
        return houseBedService.query();
    }
}
