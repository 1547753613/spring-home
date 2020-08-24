package com.aaa.springboothomestay;

import com.aaa.springboothomestay.controller.HouseTypeController;
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
    @Test
    public void test(){
        System.out.println(houseTypeController.query());
    }
}
