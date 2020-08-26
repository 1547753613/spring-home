package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.code.Result;
import com.aaa.springboothomestay.code.ResultCode;
import com.aaa.springboothomestay.code.ResultUtil;
import com.aaa.springboothomestay.entity.Admins;
import com.aaa.springboothomestay.impl.service.AdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    AdminService adminService;

    @GetMapping("select")
    public PageInfo<Admins> QeuryAdminsAll(Integer pageNum, Integer pageSize ){
        PageInfo<Admins> pageInfo = adminService.PageAdmin(pageNum, pageSize);
        return pageInfo;
    }

    /**
     *
     * @param id 锁定员工
     * @return
     */
    @PutMapping("lock")
    public Result AdminLock(Integer id){
        Result result = new Result();
        Integer integer = adminService.LockAdmin(id);
        if (null!=integer){
            return ResultUtil.success(ResultCode.SUCCESS,"锁定成功");
        }
        System.out.println(id);
        return ResultUtil.error(ResultCode.ERROR, "锁定失败");

    }

    @PutMapping("enlock")
    public Result AdminEnLock(Integer id){
        Result result = new Result();
        Integer integer = adminService.EnLockAdmin(id);
        if (null!=integer){
            return ResultUtil.success(ResultCode.SUCCESS,"账户解封成功");
        }
        System.out.println(id);
        return ResultUtil.error(ResultCode.ERROR, "解封失败");

    }



}
