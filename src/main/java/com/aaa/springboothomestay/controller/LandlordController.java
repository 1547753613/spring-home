package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.code.Result;
import com.aaa.springboothomestay.entity.Landlord;
import com.aaa.springboothomestay.impl.LandlordImpl;
import com.aaa.springboothomestay.util.IdentityCardOCR;
import com.aaa.springboothomestay.util.MultipartFileToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("muniao/Landlord")
@Controller
public class LandlordController {
    @Resource
    LandlordImpl landlordimp;
    @Resource
    TestController testController;
    @RequestMapping("insert")
    @ResponseBody
    public int insert(Landlord landlord)
    {
        System.out.println(landlord+"=====================");
        landlord.setEmail(0);
        landlord.setState(1);
        return landlordimp.add(landlord);
    }
    @RequestMapping("query")
    @ResponseBody
    public List<Landlord> query()
    {
        return landlordimp.query();
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(Landlord landlord)
    {
//        landlord.setLid(1);
//        landlord.setGreeting("我家安阳半条街，有啥事找我就完事了");
        return landlordimp.update(landlord);
    }
    @RequestMapping("querybyid")
    @ResponseBody
    public Landlord querybyid(int id)
    {
        return landlordimp.querybyid(id);
    }
    @RequestMapping("tolandlord")
    public String tolandlord()
    {
        return "/qiantai/MOveH";
    }
    @RequestMapping("uploadcardimg")
    @ResponseBody
    public Map<String,Object> cardcheck(MultipartFile file) throws Exception {
        File file1 = MultipartFileToFile.multipartFileToFile(file);
        IdentityCardOCR identityCardOCR = new IdentityCardOCR();
        Result result = testController.upload(file);
        Map<String,Object> map = identityCardOCR.discern(file1.getAbsolutePath());
        map.put("imgpath",result);
        return map;
    }
    @RequestMapping("headimg")
    @ResponseBody
    public synchronized Map<String,Object> headimg(MultipartFile file) throws Exception {
        Result result = testController.upload(file);
        Map<String,Object> map = (Map<String, Object>) result.getData();
        System.out.println(map);
        return map;
    }
}
