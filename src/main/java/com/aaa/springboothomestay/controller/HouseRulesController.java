package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.HouseRules;
import com.aaa.springboothomestay.impl.HouseRulesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@CrossOrigin
@RequestMapping("HouseRules")
@Controller
public class HouseRulesController {
    @Resource
    HouseRulesImpl houseRulesImpl;
    @RequestMapping("insert")
    public String insert(HouseRules houseRules)
    {
        return houseRulesImpl.insert(houseRules)+"";
    }
    @RequestMapping("update")
    public String update(HouseRules houseRules)
    {
        return houseRulesImpl.update(houseRules)+"";
    }
    @RequestMapping("delete")
    public String delete(HouseRules houseRules)
    {
        return houseRulesImpl.delete(houseRules)+"";
    }
    @RequestMapping("query")
    public String query()
    {
        return houseRulesImpl.query().toString();
    }

}
