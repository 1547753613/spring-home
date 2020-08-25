package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.Specifictype;
import com.aaa.springboothomestay.impl.SpecifictypeImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("Specifictype")
public class SpecifictypeController {
    @Resource
    SpecifictypeImpl specifictypeimp;
    @RequestMapping("insert")
    @ResponseBody
    public int insert(Specifictype specifictype)
    {
        return specifictypeimp.insert(specifictype);
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(Specifictype specifictype)
    {
        return specifictypeimp.update(specifictype);
    }
    @RequestMapping("delete")
    @ResponseBody
    public int delete(Specifictype specifictype)
    {
        return specifictypeimp.delete(specifictype);
    }
    @RequestMapping("query")
    @ResponseBody
    public List<Specifictype> query()
    {
        return specifictypeimp.query();
    }
}
