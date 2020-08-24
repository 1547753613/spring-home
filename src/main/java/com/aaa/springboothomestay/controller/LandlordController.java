package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.Landlord;
import com.aaa.springboothomestay.impl.LandlordImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@RequestMapping("Landlord")
@Controller
public class LandlordController {
    @Autowired
    LandlordImpl landlordimp;
    @RequestMapping("insert")
    @ResponseBody
    public int insert(Landlord landlord)
    {
//        landlord.setAccount("15503953309");
//        landlord.setAddress("中心花园路北300米");
//        landlord.setCity("文峰区");
//        landlord.setEmail("1352572800@qq.com");
//        landlord.setGreeting("本人热情好客，安阳也是古都，欢迎各位来参观旅游");
//        landlord.setHead("C:\\Users\\Administrator\\Desktop\\图集\\IMG20200820211721.jpg");
//        landlord.setIdcard("411123200105302018");
//        landlord.setIdcardimg("C:\\Users\\Administrator\\Desktop\\图集\\IMG20200820211721.jpg");
//        landlord.setLid(null);
//        landlord.setNativeplave("河南省安阳市文峰区");
//        landlord.setNickname("柳岩我爱你");
//        landlord.setPhone("15503953309");
//        landlord.setState(1);
//        landlord.setPass("dapengdapeng");
//        landlord.setRealname("大鹏");
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
}
