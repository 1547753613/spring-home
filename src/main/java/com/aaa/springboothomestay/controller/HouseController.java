package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.*;
import com.aaa.springboothomestay.impl.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("muniao/House")
@Controller
public class HouseController {
    @Resource
    RentTypeImpl rentTypeimp;
    @Resource
    HouseImpl houseimp;
    @Resource
    RequireTypeImpl requireTypeimp;
    @Resource
    HouseRequireImpl houseRequireimp;
    @Resource
    HouseRulesImpl houseRulesimp;
    @Resource
    HouseAddressImpl houseAddressimp;
    @Resource
    OthertypesImpl othertypesimp;
    @Resource
    HouseOtherImpl houseOtherimp;
    @Resource
    HouseManyImpl houseManyimp;
    @Resource
    HouseSupImpl houseSupimp;
    @Resource
    HouseBedImpl houseBedimp;
    @Resource
    BedTypeImpl bedTypeimp;
    @Resource
    HouseGeneralizeImpl houseGeneralizeimp;
    @Resource
    HouseTypeImpl houseTypeimp;
    @Resource
    SupportingImpl supportingimp;
    @RequestMapping("insert")
    @ResponseBody
    public int insert(House house)
    {
        return houseimp.insert(house);
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(House house)
    {
        return houseimp.update(house);
    }
    @RequestMapping("delete")
    @ResponseBody
    public int delete(House house)
    {
        return houseimp.delete(house);
    }
    @RequestMapping("query")
    @ResponseBody
    public List<House> query()
    {
        return houseimp.query();
    }
    @RequestMapping("querybyid")
    public String queryById(Model model,House house) throws Exception
    {
        House hu  = houseimp.querybyid(house).get(0);
        int hid = hu.getId();
        List<HouseRequire> houseRequire = houseRequireimp.byhidquery(hid);
        HouseRules houseRules = houseRulesimp.byhidquery(hid);
        HouseAddress houseAddress = houseAddressimp.byhidquery(hid);
        List<HouseOther> houseOther = houseOtherimp.query(hid);
        for (int i = 0;i<houseOther.size();i++)
        {
            houseOther.get(i).setOthertypes(othertypesimp.byidquery(houseOther.get(i).getOid()));
        }
        HouseMany houseMany = houseManyimp.byhidquery(hid);
        List<HouseSup> houseSup = houseSupimp.byhidquery(hid);
        List<Supporting> supportings = new ArrayList<Supporting>();
        for (int i = 0;i<houseSup.size();i++)
        {
            int a = houseSup.get(i).getSid();
            Supporting supporting =  supportingimp.byidquery(a);
            if(supporting!=null)
            {
                supportings.add(supporting);
            }
            houseSup.get(i).setSupporting(supporting);
//            System.out.println(houseSup.get(i).getSupporting());
        }
        List<HouseBed> houseBed = houseBedimp.byhidquery(hid);
        List<Bedtype> bedType = bedTypeimp.bybidquery(hid);
        HouseGeneralize houseGeneralize = houseGeneralizeimp.byhidquery(hid);
        Housetype housetype = houseTypeimp.bysidquery(hu.getSid());
//        System.out.println(houseRequire.getRid());
        List<Requiretype> requireType = new ArrayList<Requiretype>();
        for (int i = 0;i<houseRequire.size();i++) {
           Requiretype requiretype = requireTypeimp.byidquery(houseRequire.get(i).getRid());
           if(requireType!=null)
           {
               requireType.add(requiretype);
           }
        }
        model.addAttribute("house",hu);
        model.addAttribute("requireType",requireType);
        model.addAttribute("houseRequire",houseRequire);
        model.addAttribute("houseRules",houseRules);
        Double x = houseMany.getHolidays();
        Double y = houseMany.getWeekend();
        Double z = houseMany.getWorkday();
        Double min = ((x < y) ? x : y)<z?((x < y) ? x : y):z;
        model.addAttribute("min",min);
        model.addAttribute("houseAddress",houseAddress);
        model.addAttribute("houseOther",houseOther);
        model.addAttribute("houseMany",houseMany);
        model.addAttribute("houseSup",houseSup);
        model.addAttribute("houseBed",houseBed);
        model.addAttribute("bedType",bedType);
        model.addAttribute("housegeneralize",houseGeneralize);
        model.addAttribute("houseBedSize",houseBed.size());
        model.addAttribute("supportings",supportings);
        return "/qiantai/xiangqing";
    }
    @RequestMapping("fdlogin")
    public String tofd()
    {
        return "/qiantai/MoveHouse";
    }
    @RequestMapping("toinsert")
    public String toindex(Model md)
    {
        List<Renttype> query = rentTypeimp.query();
        md.addAttribute("renttype",query);
        List<Housetype> query1 = houseTypeimp.query();
        md.addAttribute("housetype",query1);
        return "/qiantai/index";
    }
}
