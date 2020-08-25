package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.Bedtype;
import com.aaa.springboothomestay.impl.service.BedTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("BedType")
public class BedTypeController {
    @Resource
    BedTypeService bedTypeService;
    @RequestMapping("insert")
    @ResponseBody
    public int insert(Bedtype bedtype)
    {
        return bedTypeService.insert(bedtype);
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(Bedtype bedtype)
    {
        return bedTypeService.update(bedtype);
    }@RequestMapping("delete")
    @ResponseBody
    public int delete(Bedtype bedtype)
    {
        return bedTypeService.delete(bedtype);
    }@RequestMapping("query")
    @ResponseBody
    public List<Bedtype> query()
    {
        return bedTypeService.query();
    }
}
