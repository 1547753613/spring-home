package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.aliyun.AliOSS;
import com.aaa.springboothomestay.code.Result;
import com.aaa.springboothomestay.code.ResultCode;
import com.aaa.springboothomestay.code.ResultUtil;
import com.aaa.springboothomestay.entity.Admins;
import com.aaa.springboothomestay.util.MultipartFileToFile;
import com.aaa.springboothomestay.util.UUIDUtils;
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
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping("/getAuth")
    @ResponseBody
    public Admins getUser4(Authentication authentication){
        Admins person= (Admins) authentication.getPrincipal();

        return person;
    }

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
}
