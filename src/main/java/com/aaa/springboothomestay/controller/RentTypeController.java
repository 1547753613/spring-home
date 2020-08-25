package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.Renttype;
import com.aaa.springboothomestay.impl.RentTypeImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RequestMapping("RentType")
@Controller
public class RentTypeController {
    @Resource
    RentTypeImpl rentType;
    @RequestMapping("insert")
    @ResponseBody
    public int insert(Renttype renttype)
    {
        return rentType.insert(renttype);
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(Renttype renttype)
    {
        return rentType.update(renttype);
    }
    @RequestMapping("delete")
    @ResponseBody
    public int delete(Renttype renttype)
    {
        return rentType.delete(renttype);
    }
    @RequestMapping("query")
    @ResponseBody
    public List<Renttype> query()
    {
        return rentType.query();
    }

}
