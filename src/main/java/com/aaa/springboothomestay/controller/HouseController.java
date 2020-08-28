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
    public String queryById(Model model,House house)
    {
        House hu  = houseimp.querybyid(house).get(0);
        int hid = hu.getId();
        HouseRequire houseRequire = houseRequireimp.byhidquery(hid);
        HouseRules houseRules = houseRulesimp.byhidquery(hid);
        HouseAddress houseAddress = houseAddressimp.byhidquery(hid);
        List<HouseOther> houseOther = houseOtherimp.query(hid);
        List<Othertypes> othertypes = new ArrayList<Othertypes>();
        for (int i = 0;i<houseOther.size();i++)
        {
            othertypes.add(othertypesimp.byidquery(houseOther.get(i).getOid()));
        }
        HouseMany houseMany = houseManyimp.byhidquery(hid);
        HouseSup houseSup = houseSupimp.byhidquery(hid);
        List<HouseBed> houseBed = houseBedimp.byhidquery(hid);
        Bedtype bedType = bedTypeimp.bybidquery(hid);
        HouseGeneralize houseGeneralize = houseGeneralizeimp.byhidquery(hid);
        Housetype housetype = houseTypeimp.bysidquery(house.getSid());
        Supporting supporting = supportingimp.byidquery(houseSup.getSid());
        System.out.println(houseRequire.getRid());
        List<Requiretype> requireType = requireTypeimp.byhidquery(houseRequire.getRid());
        model.addAttribute("house",hu);
        model.addAttribute("requireType",requireType);
        model.addAttribute("houseRequire",houseRequire);
        model.addAttribute("houseRules",houseRules);
        model.addAttribute("houseAddress",houseAddress);
        model.addAttribute("houseOther",houseOther);
        model.addAttribute("othertypes",othertypes);
        model.addAttribute("houseMany",houseMany);
        model.addAttribute("houseSup",houseSup);
        model.addAttribute("houseBed",houseBed);
        model.addAttribute("bedType",bedType);
        model.addAttribute("housegeneralize",houseGeneralize);
        model.addAttribute("supporting",supporting);
        return "/qiantai/xiangqing";
    }


}
