package com.aaa.springboothomestay.controller.back;

import com.aaa.springboothomestay.dao.HouseDao;
import com.aaa.springboothomestay.entity.House;
import com.aaa.springboothomestay.entity.User;
import com.aaa.springboothomestay.impl.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/muniao")
public class QianTaiHouseController {

    @Autowired
    HouseService houseService;
    @Resource
    HouseDao houseDao;

    @GetMapping("QueryHouseCity")
    @ResponseBody
    public List<House> QueryHouseCity(String city){
        List<House> houses = houseDao.QueryHouseCity(city);
        return houses;
    }

    @GetMapping("QueryHouseCondition")
    public String QueryHouseCondition(String city, Integer days, Date startDate, Date endDate, Model model){
       // System.out.println(startDate);
        List<House> houses = houseDao.QueryHouseCondition(city, days);
        model.addAttribute("houses",houses);
        model.addAttribute("startDate",startDate);
        model.addAttribute("endDate",endDate);
        model.addAttribute("city",city);
        return  "qiantai/sousuo";
    }

    @GetMapping("reserveHouse")
    public String reserveHouse(Model model, HttpSession httpSession,String start,String end,Integer days,Double price,Integer hid ){
        Object user = httpSession.getAttribute("user");
        if (null!=user){
            User use= (User) user;
            House house = houseService.QueryHouseHid(hid);

            model.addAttribute("user",use);
            model.addAttribute("start",start);
            model.addAttribute("end",end);
            model.addAttribute("days",days);
            model.addAttribute("room",price);
            model.addAttribute("house",house);
            //System.out.println(use.getUid());
        }

        return "qiantai/shenqing";
    }


}
