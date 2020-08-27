package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.House;
import com.aaa.springboothomestay.impl.HouseImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RequestMapping("muniao/House")
@Controller
public class HouseController {
    @Resource
    HouseImpl houseimp;
    @RequestMapping("insert")
    @ResponseBody
    public int insert(House house)
    {
        return houseimp.insert(house);
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(House house)
    {
        return houseimp.update(house);
    }
    @RequestMapping("delete")
    @ResponseBody
    public int delete(House house)
    {
        return houseimp.delete(house);
    }
    @RequestMapping("query")
    @ResponseBody
    public List<House> query()
    {
        return houseimp.query();
    }
    @RequestMapping("querybyid")
    public String queryById(Model model,House house)
    {
        //house.setId(1);
        System.out.println(house.getId()+"===================");
        House hu  = houseimp.querybyid(house);
        model.addAttribute("House",hu);
        return "/qiantai/xiangqing";
    }


}
