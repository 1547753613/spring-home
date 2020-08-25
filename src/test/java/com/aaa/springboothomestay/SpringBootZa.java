package com.aaa.springboothomestay;

import com.aaa.springboothomestay.controller.*;
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
    }
}
