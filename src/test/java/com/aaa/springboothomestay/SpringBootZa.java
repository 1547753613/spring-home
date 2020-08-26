package com.aaa.springboothomestay;

import com.aaa.springboothomestay.controller.*;
import com.aaa.springboothomestay.dao.HouseGeneralizeDao;
import com.aaa.springboothomestay.entity.*;
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
    @Resource
    SpecifictypeController specifictypeController;
    @Resource
    BedTypeController bedTypeController;
    @Resource
    OtherTypesController otherTypesController;
    @Resource
    SupportingController supportingController;
    @Resource
    HouseController houseController;
    @Resource
    HouseGeneralizeController houseGeneralizeController;
    @Resource
    HouseBedController houseBedController;
    @Resource
    HouseSupController houseSupController;
    @Test
    public void test(){
        //System.out.println(houseTypeController.query());
//        Renttype renttype  = new Renttype();
//        renttype.setRid(1);
//        renttype.setIcon("C:\\Users\\Administrator\\Desktop\\图集\\2.jpg");
//       renttype.setTname("单间");
//        //System.out.println(rentTypeController.insert(renttype));
//        //System.out.println(renttype.getRid());
//        //System.out.println(rentTypeController.update(renttype));
//        renttype.setRid(1);
//        //System.out.println(rentTypeController.insert(renttype));
//        System.out.println(rentTypeController.delete(renttype));
//        System.out.println(rentTypeController.query());
//        Specifictype specifictype = new Specifictype();
//        specifictype.setSid(null);
//        specifictype.setSname("上古时期流传下来的四合院，据说乾隆皇帝曾经下江南时路过此地进门观看，并且慈禧老佛爷当年八国联军进京时也曾来此地避难");
//        specifictype.setId(1);
//        System.out.println(specifictypeController.insert(specifictype));
//        System.out.println(specifictypeController.query());
//        System.out.println(specifictypeController.insert(specifictype));
//        specifictype.setSname("这里是！！！康家大院！！！");
//        System.out.println(specifictypeController.query());
//        specifictype.setSid(2);
//        System.out.println(specifictypeController.update(specifictype));
//        System.out.println(specifictypeController.delete(specifictype));
//        Bedtype bedtype = new Bedtype();
//        bedtype.setBname("双人床");
//        bedtype.setBid(null);
//        bedtype.setParentid(0);
//        System.out.println(bedTypeController.insert(bedtype));
//        bedtype.setBid(1);
//        bedtype.setBname("五人豪华大床");
//        System.out.println(bedTypeController.update(bedtype));
//        bedtype.setBid(null);
//        System.out.println(bedTypeController.insert(bedtype));
//        bedtype.setBid(2);
//        System.out.println(bedTypeController.delete(bedtype));
//        System.out.println(bedTypeController.query());
//        Othertypes othertypes = new Othertypes();
//        othertypes.setId(null);
//        othertypes.setOname("押金");
//        System.out.println(otherTypesController.insert(othertypes));
//        othertypes.setOname("小费");
//        othertypes.setId(2);
//        System.out.println(otherTypesController.update(othertypes));
//        othertypes.setId(2);
//        System.out.println(otherTypesController.delete(othertypes));
//        System.out.println(otherTypesController.query());
//        Supporting supporting = new Supporting();
//        supporting.setId(null);
//        supporting.setParentid(0);
//        supporting.setIcon("C:\\Users\\Administrator\\Desktop\\图集\\2.jpg");
//        supporting.setSname("床上用品");
//        System.out.println(supportingController.insert(supporting));
//        supporting.setSname("洗漱用品");
//        System.out.println(supportingController.insert(supporting));
//        supporting.setSname("出门用品");
//        System.out.println(supportingController.insert(supporting));
//        supporting.setSname("游乐设施");
//        System.out.println(supportingController.insert(supporting));
//        supporting.setId(3);
//        supporting.setSname("向导服务");
//        System.out.println(supportingController.update(supporting));
//        supporting.setId(3);
//        System.out.println(supportingController.delete(supporting));
//        System.out.println(supportingController.query());
//        House house = new House();
//        house.setId(null);
//        house.setHname("天鑫现代城");
//        house.setSimg("C:\\Users\\Administrator\\Desktop\\图集\\2.jpg");//封面图
//        house.setHimg("C:\\Users\\Administrator\\Desktop\\图集\\2.jpg");//详情图
//        house.setLid(1);
//        house.setRid(1);
//        house.setFeature("附近有河");
//        house.setXcoord(4444.4444);
//        house.setYcoord(7777.7777);
//        house.setTraffic("漯河市郾襄路口");
//        house.setState(1);
//        house.setRim("周围临近高铁，离高铁特近");
//        System.out.println(houseController.insert(house));
//        house = null;
//        house.setId(1);
//        house.setTraffic("漯河市火车站附近");
//        System.out.println(houseController.update(house));
//        System.out.println(houseController.query());
//        HouseGeneralize houseGeneralize = new HouseGeneralize();
//        houseGeneralize.setId(null);
//        houseGeneralize.setHid(1);
//        houseGeneralize.setArea(131.0);
//        houseGeneralize.setRarea(1.0);
//        houseGeneralize.setCohabit(1);
//        houseGeneralize.setBedroom(1);
//        houseGeneralize.setWc(1);
//        houseGeneralize.setDrawing(1);
//        houseGeneralize.setKitchen(2);
//        houseGeneralize.setBalcony(2);
//        houseGeneralize.setWctype(0);
//        houseGeneralize.setCount(3);
//        //System.out.println(houseGeneralizeController.insert(houseGeneralize));
//        //System.out.println(houseGeneralizeController.query());
//        System.out.println(houseGeneralize.toString());
//        //System.out.println(houseGeneralizeController.insert(houseGeneralize));
//        houseGeneralize.setId(2);
//        System.out.println(houseGeneralizeController.update(houseGeneralize));
//        System.out.println(houseGeneralizeController.query());
//        HouseBed houseBed = new HouseBed();
//        houseBed.setId(null);
//        houseBed.setBid(1);
//        houseBed.setHid(1);
//        houseBed.setCount(2);
//        System.out.println(houseBedController.insert(houseBed));
//        System.out.println(houseBedController.query());
//        HouseSup houseSup = new HouseSup();
       // @GeneratedValue(strategy = GenerationType.IDENTITY)获取自增的id属性
//        houseSup.setId(null);
//        houseSup.setHid(1);
//        houseSup.setSid(1);
//        houseSup.setState(1);
        //System.out.println(houseSupController.insert(houseSup));
//        System.out.println(houseSup.getId());
//        houseSupController.insert(houseSup);
//        houseSup.setId(2);
//        houseSup.setSid(7);
//        System.out.println(houseSupController.update(houseSup));
//        System.out.println(houseSupController.query());
    }
}
