package com.aaa.springboothomestay;

import com.aaa.springboothomestay.controller.HouseTypeController;
import com.aaa.springboothomestay.controller.RentTypeController;
import com.aaa.springboothomestay.entity.Renttype;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringBootZa {
    @Resource
    HouseTypeController houseTypeController;
    @Resource
    RentTypeController rentTypeController;
    @Test
    public void test(){
        //System.out.println(houseTypeController.query());
//        Renttype renttype  = new Renttype();
////        renttype.setRid(1);
////        renttype.setIcon("C:\\Users\\Administrator\\Desktop\\图集\\2.jpg");
////        renttype.setTname("单间");
//        //System.out.println(rentTypeController.insert(renttype));
//        //System.out.println(renttype.getRid());
//        //System.out.println(rentTypeController.update(renttype));
//        renttype.setRid(1);
//        //System.out.println(rentTypeController.insert(renttype));
//        System.out.println(rentTypeController.delete(renttype));
//        System.out.println(rentTypeController.query());
    }
}
