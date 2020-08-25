package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.Othertypes;
import com.aaa.springboothomestay.impl.OthertypesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RequestMapping("OtherTypes")
@Controller
public class OtherTypesController {
    @Resource
    OthertypesImpl othertypesimp;
    @RequestMapping("insert")
    @ResponseBody
    public int insert(Othertypes othertypes)
    {
        return othertypesimp.insert(othertypes);
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(Othertypes othertypes)
    {
        return othertypesimp.update(othertypes);
    }
    @RequestMapping("delete")
    @ResponseBody
    public int delete(Othertypes othertypes)
    {
        return othertypesimp.delete(othertypes);
    }
    @RequestMapping("query")
    @ResponseBody
    public List<Othertypes> query()
    {
        return othertypesimp.query();
    }
}
