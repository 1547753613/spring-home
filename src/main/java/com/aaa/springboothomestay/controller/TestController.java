package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.aliyun.AliOSS;
import com.aaa.springboothomestay.code.Result;
import com.aaa.springboothomestay.code.ResultCode;
import com.aaa.springboothomestay.code.ResultUtil;
import com.aaa.springboothomestay.entity.Admins;
import com.aaa.springboothomestay.entity.User;
import com.aaa.springboothomestay.impl.service.AdminService;
import com.aaa.springboothomestay.impl.service.OrdersService;
import com.aaa.springboothomestay.impl.service.UsersService;
import com.aaa.springboothomestay.util.MultipartFileToFile;
import com.aaa.springboothomestay.util.UUIDUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    OrdersService ordersService;

    @Autowired
    UsersService usersService;

    @Autowired
    AdminService adminService;

    @GetMapping("SelectOrdersCount")
    @ResponseBody
    public Integer SelectOrdersCount(String date){
        return  ordersService.SelectOrdersCount(date);
    }

    /**
     * 查看当前认证对象
     * @param authentication
     * @return
     */
    @RequestMapping("/getAuth")
    @ResponseBody
    public Admins getUser4(Authentication authentication){
        Admins person= (Admins) authentication.getPrincipal();

        return person;
    }

    /**
     * 上传图片
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("upload")
    @ResponseBody
    public Result upload(MultipartFile file) throws Exception {
        Result result = new Result();
        String upload="";
        if (null!=file){
            String contentType = file.getContentType();
            if (contentType.equals("image/png")||contentType.equals("image/jpeg")||contentType.equals("image/jpg")) {


                try {
                    String name = UUIDUtils.ImgName();

                     upload = AliOSS.upload(name, file);

                } catch (Exception e) {
                    return ResultUtil.error(ResultCode.ERROR, "文件上传失败");

                }
            }else {
                return ResultUtil.error(ResultCode.ERROR, "上传文件类型请选择图片格式");
            }
         //   System.out.println(upload);
            Map<String,Object>map=new HashMap<>();
            map.put("msg","上传成功");
            map.put("head",upload);
            return ResultUtil.success(ResultCode.SUCCESS,map);
        }

        return ResultUtil.error(ResultCode.ERROR, "文件上传失败");

    }

    /**
     * 查询账号是否存在
     * @param aname
     * @return
     */
    @GetMapping("findname")
    @ResponseBody

    public Integer FindName(String aname){
        Admins admins = adminService.FindAdminName(aname);
        if (null==admins){
            return 0;

        }
        return 1;
    }

    /**
     * 校验身份证是否存在
     * @param idcard
     * @return
     */
    @GetMapping("checkIdcard")
    @ResponseBody
    public Boolean CheckIdcard(String idcard){
        return adminService.CheckIdcard(idcard);
    }

    @GetMapping("userAll")
    @ResponseBody
    public PageInfo<User> SelectUserAll(Integer pageNum, Integer pageSize, String realname){
        return usersService.SelectUserAll(pageNum, pageSize, realname);
    }

    @GetMapping("/invalidateSession")
    @ResponseBody
    public Integer invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            request.getSession().invalidate();
        }
        //System.out.println(session);
        return 1;
    }
}
