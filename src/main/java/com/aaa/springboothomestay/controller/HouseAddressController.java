package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.House;
import com.aaa.springboothomestay.entity.HouseAddress;
import com.aaa.springboothomestay.impl.HouseAddressImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RequestMapping("/muniao")
@Controller
public class HouseAddressController {
    @Resource
    HouseAddressImpl houseAddressImpl;
    @RequestMapping("insert")
    public String insert(HouseAddress houseAddress)
    {
        return houseAddressImpl.insert(houseAddress)+"";
    }
    @RequestMapping("update")
    public String update(HouseAddress houseAddress)
    {
        return houseAddressImpl.udpate(houseAddress)+"";
    }
    @RequestMapping("delete")
    public String delete(HouseAddress houseAddress)
    {
        return houseAddressImpl.delete(houseAddress)+"";
    }
    @RequestMapping("query")
    public String query()
    {
        return houseAddressImpl.query().toString();
    }
    @RequestMapping("/weizhimincheng")
    @ResponseBody
    public List<HouseAddress> findByCity(String city , Model model)
    {
        List<HouseAddress> luo = houseAddressImpl.findByCity(city);
        System.out.println(luo);

        model.addAttribute("house",luo);
        return luo;
    }
}
