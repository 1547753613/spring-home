package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.code.Result;
import com.aaa.springboothomestay.code.ResultCode;
import com.aaa.springboothomestay.code.ResultUtil;
import com.aaa.springboothomestay.entity.MenuRole;
import com.aaa.springboothomestay.impl.service.AuthorityService;
import com.aaa.springboothomestay.impl.service.MenuRoleService;
import com.aaa.springboothomestay.util.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/authority")
public class AuthorityController {

    @Autowired
    AuthorityService authorityService;

    @Autowired
    MenuRoleService menuRoleService;

    @GetMapping("/queryall")
    public List<Authority> QueryAuthory(){
        return authorityService.QueryAuthority(0);
    }

    /**
     * 根据职位id查权限
     * @param rid
     * @return
     */
    @GetMapping("/queryrid")
    public List<Integer> QueryAuthoryRid(Integer rid){

        Set<MenuRole> menuRoles = menuRoleService.SelectMenuRid(rid);
        List<Integer> lists=menuRoles.stream().map(MenuRole->MenuRole.getMid()).collect(Collectors.toList());

        return lists;
    }

    @PutMapping("/addAuth")
    public Result AddAuth(int[] ints,Integer rid){
        Result result = new Result();

        Integer integer = menuRoleService.DeleteMenuRole(rid);
        if (null!=integer){
            Integer role = menuRoleService.AddMenuRole(ints, rid);
            return ResultUtil.success(ResultCode.SUCCESS, "修改权限成功");
        }

        return ResultUtil.error(ResultCode.ERROR, "修改权限失败");
    }
}
