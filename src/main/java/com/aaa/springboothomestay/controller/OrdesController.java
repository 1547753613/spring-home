package com.aaa.springboothomestay.controller;
import com.aaa.springboothomestay.entity.Orders;
import com.aaa.springboothomestay.entity.User;
import com.aaa.springboothomestay.impl.OrdersImpl;
import com.aaa.springboothomestay.impl.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("muniao")
public class OrdesController {
    @Resource
    private OrdersService ordersService;
    @Resource
    OrdersImpl  ordersimpl;

    /**
     * 查询所有订单
     * @param model
     * @param httpSession
     * @return
     */
    @RequestMapping("/toList")
    public String toList(Model model, HttpSession httpSession,Integer status){
        User map = (User) httpSession.getAttribute("user");
        Integer uid = map.getUid();
        List<Orders> list = ordersService.findAllOrders(uid,status);
        System.out.println(list);
        model.addAttribute("list",list);
        return "/qiantai/orders";
    }
    @RequestMapping("/toOrder")
    @ResponseBody
    public List<Orders> toOrder( HttpSession httpSession,Integer status){
        User map = (User) httpSession.getAttribute("user");
        Integer uid = map.getUid();
        List<Orders> list = ordersService.findAllOrders(uid,status);
        return list;
    }

    /**
     * 订单详情
     */
    @RequestMapping("/findById")
    public String findById(Model model,Integer id){
        List<Orders> lists = ordersService.finById(id);
        model.addAttribute("lists",lists);
        System.out.println(lists);
        return "/qiantai/orders-xq";
    }

    /**
     *跳转申请页面
     * @param model
     * @param
     * @return
     */
    @RequestMapping("chexiaoShow")
    public String chexiaoShow(Model model,Integer status){
        List<Orders> chexiao = ordersService.findShow(status);
        if (status==3 || status==4 || status==5 || status==6 || status==7){
            return "redirect:toList";
        }
        model.addAttribute("chexiao",chexiao.get(0));
        return "/qiantai/chexiaoShow";
    }

    /**
     * 撤销订单
     * @param map
     * @return
     */
    @RequestMapping("chexiao")
    public String chexiao(@RequestParam Map map){
        Orders orders = new Orders();
        orders.setId(map.get("id")+"");
        orders.setCdemo((String) map.get("cdemo"));
        ordersService.updateChexiao(orders);
        return "redirect:toList";
    }

    /**
     * 跳转申请页面
     * @param model
     * @param
     * @return
     */
    @RequestMapping("tuifangShow")
    public String tuifangShow(Model model,Integer status){
        List<Orders> tuifang = ordersService.findShow(status);
        if (status==1 || status==3 || status==4 || status==5 || status==6 || status==7){
            return "redirect:toList";
        }
        model.addAttribute("tui",tuifang.get(0));
        return "/qiantai/tuifangShow";
    }

    /**
     * 退房
     * @param map
     * @return
     */
    @RequestMapping("tuifang")
    public String tuifang(@RequestParam Map map){
        Orders orders = new Orders();
        orders.setId(map.get("id")+"");
        orders.setCdemo((String) map.get("cdemo"));
        ordersService.updatetuifang(orders);
        return "redirect:toList";
    }

    /**
     * 确认订单
     * @param
     * @return
     */
    @RequestMapping("queren")
    public String queren(Integer status){
        if (status==1 || status==2 || status==3 || status==4 || status==5 || status==6){
            return "redirect:toList";
        }else {
            ordersService.queren(status);
            return "redirect:toList";
        }
    }

    @RequestMapping("querenbylid")
    public String querenbylid(Integer status){
        if (status==1 || status==2 || status==3 || status==4 || status==5 || status==6){
            return "redirect:toList";
        }else {
            ordersService.queren(status);
            return "redirect:toList";
        }
    }

    @RequestMapping("landorder")
    public String tolorder(Integer lid,Integer status,Model md)
    {
        if(status==null)
        {
            status = 0;
        }
        List<Orders> bylidquery = ordersimpl.bylidquery(lid,status);
        md.addAttribute("list",bylidquery);
        md.addAttribute("lid",lid);
        return "/qiantai/landlordOrder";
    }
    @RequestMapping("landlordorder")
    @ResponseBody
    public List<Orders> bylid(Integer lid,Integer status)
    {
        return ordersimpl.bylidquery(lid,status);
    }
    @RequestMapping("updatebyoid")
    public String updatebyoid(Integer status,Integer oid,Integer lid,Model md)
    {
        System.out.println(oid+""+status);
        int i = ordersimpl.updatebyoid(oid,status);
        status = 0;
        List<Orders> bylidquery = ordersimpl.bylidquery(lid,status);
        md.addAttribute("list",bylidquery);
        return "/qiantai/landlordOrder";
    }
}
