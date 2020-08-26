package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.HouseOther;
import com.aaa.springboothomestay.impl.HouseOtherImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@CrossOrigin
@RequestMapping("HouseOther")
@Controller
public class HouseOtherController {
    @Resource
    HouseOtherImpl houseOtherimp;
    @RequestMapping("insert")
    public String insert(HouseOther houseOther)
    {
        return houseOtherimp.add(houseOther)+"";
    }
    @RequestMapping("update")
    public String update(HouseOther houseOther)
    {
        return houseOtherimp.update(houseOther)+"";
    }
    @RequestMapping("delete")
    public String query()
    {
        return houseOtherimp.query().toString();
    }
}
