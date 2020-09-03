package com.aaa.springboothomestay.controller.back;

import com.aaa.springboothomestay.dao.HouseDao;
import com.aaa.springboothomestay.entity.House;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/muniao")
public class QianTaiHouseController {

    @Resource
    HouseDao houseDao;

    @GetMapping("/QueryHouseCity")
    @ResponseBody
    public List<House> QueryHouseCity(String city){
        List<House> houses = houseDao.QueryHouseCity(city);
        return houses;
    }
}
