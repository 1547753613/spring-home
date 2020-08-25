package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.dao.SupportintDao;
import com.aaa.springboothomestay.entity.Supporting;
import com.aaa.springboothomestay.impl.SupportingImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RequestMapping("Supporting")
@Controller
public class SupportingController {
    @Resource
    SupportingImpl supportintimp;
    @RequestMapping("insert")
    @ResponseBody
    public int insert(Supporting supporting)
    {
        return supportintimp.insert(supporting);
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(Supporting supporting)
    {
        return supportintimp.update(supporting);
    }
    @RequestMapping("delete")
    @ResponseBody
    public int delete(Supporting supporting)
    {
        return supportintimp.delete(supporting);
    }
    @RequestMapping("query")
    @ResponseBody
    public List<Supporting> query()
    {
        return supportintimp.query();
    }
}
