package com.aaa.springboothomestay.controller.back;

import com.aaa.springboothomestay.code.Result;
import com.aaa.springboothomestay.entity.Landlord;
import com.aaa.springboothomestay.impl.service.LandlordService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/landlord")
public class LandlordsController {

    @Autowired
    LandlordService landlordService;

    /**
     * 查询所有房东
     * @return
     */
    @GetMapping("select")
    public PageInfo<Landlord> SelectLandlordAll(Integer pageNum,Integer pageSize ,String realname){
        return landlordService.PageLandlord(pageNum,pageSize,realname);
    }

    /**
     *
     * @param id 锁定房东
     * @return
     */
    @PutMapping("lock")
    public Result LockLandlord(Integer id){

        return  landlordService.LockLandlord(id);
    }

    /**
     *
     * @param id 解锁房东
     * @return
     */

    @PutMapping("enlock")
    public Result EnLockload(Integer id){
        return landlordService.EnLockandlord(id);
    }

}
