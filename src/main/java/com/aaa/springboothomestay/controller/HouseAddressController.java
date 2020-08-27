package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.HouseAddress;
import com.aaa.springboothomestay.impl.HouseAddressImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@CrossOrigin
@RequestMapping("HouseAddress")
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
}
