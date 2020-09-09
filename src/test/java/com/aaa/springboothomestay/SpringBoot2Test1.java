package com.aaa.springboothomestay;


import com.aaa.springboothomestay.dao.HouseDao;
import com.aaa.springboothomestay.dao.OrdersDao;
import com.aaa.springboothomestay.entity.*;
import com.aaa.springboothomestay.impl.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringBoot2Test1 {
    @Resource
    HouseDao houseDao;

    @Autowired
    AdminService adminService;

    @Autowired
    RoleService roleService;

    @Autowired
    MenuRoleService menuRoleService;
    @Autowired
    MenuService menuService;

    @Resource
    OrdersDao ordersDao;




//    @Autowired
//    AuthorityService authorityService;

    @Test
    public void t13(){
        System.out.println(ordersDao.SelectOrderId(1));
    }
   @Test
   public void t2(){

       House house = houseDao.findHouseHid(1);
       Renttype renttype = house.getRenttype();
       Housetype housetype = house.getHousetype();
       HouseGeneralize houseGeneralize = house.getHouseGeneralize();
       List<HouseBed> houseBeds = house.getHouseBeds();
       List<HouseSup> houseSups = house.getHouseSups();
       HouseMany houseMany = house.getHouseMany();
       List<HouseOther> houseOthers = house.getHouseOthers();
       HouseAddress address = house.getHouseAddress();
       HouseRules houseRules = house.getHouseRules();
       List<HouseRequire> houseRequires = house.getHouseRequires();
       System.out.println(houseRequires);
       System.out.println(houseRules);
       System.out.println(address);
       System.out.println(houseOthers);
       System.out.println(houseMany);
       System.out.println(renttype);
       System.out.println(housetype);
       System.out.println(houseGeneralize);
       System.out.println(houseBeds);
       System.out.println(houseSups);
   }

    @Test
    public void t4(){
        Admins admins = adminService.FindAdminName("Admin");
        Integer rid = admins.getRid();
        Set<MenuRole> menuRoles = menuRoleService.SelectMenuRid(rid);
        List<Integer> lists=menuRoles.stream().map(MenuRoles->MenuRoles.getMid()).collect(Collectors.toList());

        List<Menu> menus = menuService.SelectMenuId(lists);
        Role role = roleService.SelectRoleId(rid);
        //System.out.println(role);
       // System.out.println(menus);
       // System.out.println(menuRoles);
    }

    @Test
    public void t1(){
        System.out.println(1);
        System.out.println(menuService.SelectMenuParentId(2));
    }

}
