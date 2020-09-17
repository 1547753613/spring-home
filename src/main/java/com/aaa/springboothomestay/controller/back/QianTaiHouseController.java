package com.aaa.springboothomestay.controller.back;

import com.aaa.springboothomestay.dao.HouseDao;
import com.aaa.springboothomestay.dao.OrderDao;
import com.aaa.springboothomestay.dao.OrderDetailsDao;
import com.aaa.springboothomestay.dao.OrdersDao;
import com.aaa.springboothomestay.entity.House;
import com.aaa.springboothomestay.entity.Order;
import com.aaa.springboothomestay.entity.Orders;
import com.aaa.springboothomestay.entity.User;
import com.aaa.springboothomestay.impl.service.HouseService;
import com.aaa.springboothomestay.impl.service.HouseTypeService;
import com.aaa.springboothomestay.impl.service.OrdersService;
import com.aaa.springboothomestay.impl.service.RequireTypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/muniao")
public class QianTaiHouseController {
    @Autowired
    HouseTypeService houseTypeService;

    @Autowired
    RequireTypeService requireTypeService;

    @Autowired
    OrdersService ordersService;

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
        model.addAttribute("requiretypes",requireTypeService.SelectRequiretypeAll());//服务要求
        model.addAttribute("housetypes",houseTypeService.query());
        return  "qiantai/sousuo";
    }

    @GetMapping("reserveHouse")
    public String reserveHouse(Model model, HttpSession httpSession,String start,String end,Integer days,Double price,Integer hid ){
        Object user = httpSession.getAttribute("user");
        if (null!=user){
            User use= (User) user;
            House house = houseService.QueryHouseHid(hid);

            model.addAttribute("user",use);//当前登录用户
            model.addAttribute("start",start);//入住日期
            model.addAttribute("end",end);//离开日期
            model.addAttribute("days",days);//入住天数
            model.addAttribute("room",price);//单价
            model.addAttribute("house",house);//房间
            System.out.println(start+""+end);
            //System.out.println(use.getUid());
        }

        return "qiantai/shenqing";
    }

    @PostMapping("addOrders")
    public String AddOrders(Order orders,Model model){
        orders.setCreatetime(new Date(System.currentTimeMillis()));

        Integer integer = ordersService.AddOrders(orders);
        orders.setId(integer);
        System.out.println(orders);
        model.addAttribute("orders",orders);
        /*System.out.println(integer);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date((orders.getCreatetime().getTime()+60000*15));
        String parse=dateFormat.format(date);*/
        return "qiantai/zifu";
    }

    @GetMapping("fuzzySearch")
    @ResponseBody
    public List<House> FuzzySearchHouse(Integer days,Integer min,Integer max, Integer htid,int[] reqid){

        //   System.out.println(houseDao.FuzzySearchHouse(days, min, max, htid, Arrays.stream(reqid).boxed().collect(Collectors.toList())).size());
        int size=reqid==null?0:reqid.length;
        List<House> houses = houseDao.FuzzySearchHouse(days, min, max, htid, reqid,size);

        return houses;
    }

}
