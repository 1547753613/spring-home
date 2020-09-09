package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.*;
import com.aaa.springboothomestay.impl.*;
import com.aaa.springboothomestay.impl.service.OrderDetailsService;
import com.aaa.springboothomestay.impl.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

@CrossOrigin
@RequestMapping("muniao/House")
@Controller
public class HouseController {
    @Resource
    LandlordImpl landlordimp;
    @Autowired
    OrderDetailsService orderDetailsService;
    @Autowired
    OrdersService ordersService;
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
    public Map<String,Object> map;
    @RequestMapping("insert")
    @ResponseBody
    public int insert(House house)
    {
        house.setLid(1);
        house.setState(0);
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
        Integer hid = hu.getId();
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


        for (int i = 0;i<houseBed.size();i++)
        {
            Bedtype bedtypes = bedTypeimp.bybidquery(houseBed.get(i).getBid());
            houseBed.get(i).setBedtype(bedtypes);
        }
        HouseGeneralize houseGeneralize = houseGeneralizeimp.byhidquery(hid);
        Housetype housetype = houseTypeimp.bysidquery(hu.getSid());
        List<Requiretype> requireType = new ArrayList<Requiretype>();
        for (int i = 0;i<houseRequire.size();i++) {
           Requiretype requiretype = requireTypeimp.byidquery(houseRequire.get(i).getRid());
           if(requireType!=null)
           {
               requireType.add(requiretype);
           }
        }
        Landlord landlord = landlordimp.querybyid(hu.getLid());
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
        model.addAttribute("housegeneralize",houseGeneralize);
        model.addAttribute("houseBedSize",houseBed.size());
        model.addAttribute("supportings",supportings);
        model.addAttribute("landlord",landlord);

        Order order = ordersService.SelectOrderId(hid);
        System.out.println(order);
        if (null!=order){
            order.setOrdersDetails(orderDetailsService.SelectOrderOid(order.getId()));
            model.addAttribute("order",order);
           // System.out.println(order);
        }

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
        List<Requiretype> query2 = requireTypeimp.query();
        md.addAttribute("requiretype",query2);
        List<Othertypes> othertypes = othertypesimp.query();
        md.addAttribute("othertypes",othertypes);
        List<Supporting> supportings = supportingimp.query();
        md.addAttribute("supportings",supportings);
        List<Bedtype> bedtype = bedTypeimp.query();
        md.addAttribute("bedtype",bedtype);
        List<Renttype> query = rentTypeimp.query();
        md.addAttribute("renttype",query);
        List<Housetype> query1 = houseTypeimp.query();
        md.addAttribute("housetype",query1);
        return "/qiantai/index";
    }
    @RequestMapping("inser")
    @ResponseBody
    public Integer inser(@RequestBody HashMap<String,Object> map)
    {
        System.out.println(map);
        String address =  (String) map.get("address");
        String hname = (String) map.get("hname");
        String simg = (String) map.get("simg");
        String himg = (String) map.get("himg");
        Integer rid = Integer.parseInt((String) map.get("rid"));
        Integer sid = Integer.parseInt((String) map.get("sid"));
        String feature = (String) map.get("feature");
        Double xcoord = Double.valueOf((String)map.get("xcoord")) ;
        Double ycoord = Double.valueOf((String) map.get("ycoord"));
        String traffic = (String) map.get("traffic");
        String rim = (String) map.get("rim");
        List<String> count2 = (List<String>) map.get("count");
        House house = new House();
        house.setHname(hname);
        house.setHimg(himg);
        house.setSimg(simg);
        house.setRid(rid);
        house.setSid(sid);
        house.setFeature(feature);
        house.setXcoord(xcoord);
        house.setYcoord(ycoord);
        house.setTraffic(traffic);
        house.setRim(rim);
        house.setLid(2);
        house.setState(1);
        houseimp.insert(house);
        Integer hid = house.getId();

        Double area = Double.valueOf((String) map.get("area"));
        List<String> cohabit = (List<String>)map.get("cohabit");
        Integer bedroom = Integer.parseInt((String) map.get("bedroom"));
        Integer wc = Integer.parseInt((String) map.get("wc"));
        Integer drawing = Integer.parseInt((String) map.get("drawing"));
        Integer kitchen = Integer.parseInt((String) map.get("kitchen"));
        Integer balcony = Integer.parseInt((String) map.get("balcony"));
        List<String> wctypes = (List<String>)map.get("wctype");
        Integer wctype = Integer.parseInt(wctypes.get(0));
        Integer count = 1;
        List<String> bids = (List<String>) map.get("bids");

        for (int i = 0;i<bids.size();i++)
        {
            HouseBed houseBed = new HouseBed();
            houseBed.setBid(Integer.parseInt(bids.get(i)));
            houseBed.setHid(hid);
            houseBed.setCount(Integer.parseInt(count2.get(i)));
            houseBedimp.insert(houseBed);
        }
        HouseGeneralize houseGeneralize = new HouseGeneralize();
        houseGeneralize.setArea(area);
        houseGeneralize.setCohabit(Integer.parseInt(cohabit.get(0)));
        houseGeneralize.setBedroom(bedroom);
        houseGeneralize.setWc(wc);
        houseGeneralize.setDrawing(drawing);
        houseGeneralize.setKitchen(kitchen);
        houseGeneralize.setBalcony(balcony);
        houseGeneralize.setWctype(wctype);
        houseGeneralize.setCount(1);
        houseGeneralize.setHid(hid);
        houseGeneralizeimp.insert(houseGeneralize);
        List<String> sids = (List<String>) map.get("sids");
        for (String id:sids)
        {
            HouseSup houseSup = new HouseSup();
            houseSup.setSid(Integer.parseInt(id));
            houseSup.setHid(hid);
            houseSup.setState(1);

            houseSupimp.insert(houseSup);
        }


        List<String> othercount = (List<String>) map.get("othercount");
        List<String> othermany = (List<String>) map.get("othermany");
        List<String> otherid = (List<String>) map.get("otherid");
        for (int i = 0;i<othercount.size();i++)
        {
            HouseOther houseOther = new HouseOther();
            houseOther.setCount(Integer.parseInt(othercount.get(i)));
            houseOther.setOid(Integer.parseInt(otherid.get(i)));
            houseOther.setMany(Double.valueOf(othermany.get(i)));
            houseOther.setHid(hid);
            houseOtherimp.add(houseOther);
        }


        Double workday = Double.valueOf((String) map.get("workday"));
        Double weekday = Double.valueOf((String) map.get("weekday"));
        Double holidays = Double.valueOf((String) map.get("Holidays"));
        HouseMany houseMany = new HouseMany();
        houseMany.setWeekend(weekday);
        houseMany.setWorkday(workday);
        houseMany.setHolidays(holidays);
        houseMany.setHid(hid);
        houseManyimp.insert(houseMany);

        Integer liblecount = Integer.parseInt((String) map.get("liblecount"));
        Integer days = Integer.parseInt((String) map.get("days"));
        String atcheck = (String) map.get("atcheck");
        String lastcheck = (String) map.get("lastcheck");
        String checkout = (String) map.get("checkout");
        HouseRules houseRules = new HouseRules();
        houseRules.setLiblecount(liblecount);
        houseRules.setDays(days);
        houseRules.setAtcheck(atcheck);
        houseRules.setLastcheck(lastcheck);
        houseRules.setCheckout(checkout);
        houseRules.setHid(hid);
        houseRulesimp.insert(houseRules);
        String city = (String) map.get("city");
        HouseAddress houseAddress = new HouseAddress();
        houseAddress.setCity(city);
        houseAddress.setAddress(address);
        houseAddress.setHid(hid);
       houseAddress.setExplains("无");
       houseAddress.setCard(0);
       houseAddress.setPlot("");
       houseAddressimp.insert(houseAddress);
        return 1;
    }

}
