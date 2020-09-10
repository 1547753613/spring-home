package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.aliyun.ALiNote;
import com.aaa.springboothomestay.entity.House;
import com.aaa.springboothomestay.entity.ResResult;
import com.aaa.springboothomestay.entity.User;
import com.aaa.springboothomestay.impl.HouseImpl;
import com.aaa.springboothomestay.impl.UserImpl;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.ClientException;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("muniao")
public class UserController {
    /**
     * 罗元超登陆
     */
    @Resource
    UserImpl userimpl;
    @Resource
    HouseImpl houseimp;
    @RequestMapping("/login")
    public String yuan()
    {
        return "qiantai/denglu/index";
    }
    @PostMapping("/denglu")
    public String login(String uname, String pass, Model model,HttpSession session){

        User user = userimpl.findByDenglu(uname,pass);
        if(user == null || !pass.equals(user.getPass())) {
            return "qiantai/denglu/index";
        }
        List<House> houses = houseimp.query();
       // System.out.println(houses);
        model.addAttribute("houses",houses);
        model.addAttribute("user",user);
        session.setAttribute("user",user);
        return "/qiantai/tujia";
    }




    /**
     * 注册
     * @param user
     * @param session
     * @return
     */
    @PostMapping("register")
    @ResponseBody
    public ResResult register(User user, HttpSession session, String yanzheng) {
        String verifyCode = (String)session.getAttribute("verifyCode");
        if(!verifyCode.equals(yanzheng)) {
            return new ResResult(false,"验证码不一致");
        }
        userimpl.zhuce(user);
        return new ResResult();
    }
    @PostMapping("getVerification")
    @ResponseBody
    public ResResult getVerification(String phone, HttpServletRequest req){
        if(!StringUtils.isEmpty(phone)){
            try {
                SendSmsResponse sendSmsResponse = ALiNote.sendSms(phone,req);
                String code = sendSmsResponse.getCode();
                if(!"OK".equals(code)) {
                    return new ResResult(false,"发送验证码时系统内部异常 : 可能原因  手机号不正确");
                }
            } catch (ClientException | com.aliyuncs.exceptions.ClientException e) {
                e.printStackTrace();
                return new ResResult(false,"发送验证码时系统内部异常");
            }
        }
        return new ResResult(true,"发送成功");

    }




    /**
     * 查询用户个人信息
     */
    @RequestMapping("/findUser")
    public String findUser(Model model, HttpSession httpSession){
        if (httpSession.getAttribute("user")==null){
            return "redirect:/muniao/login";
        }
        User map = (User) httpSession.getAttribute("user");
        int uid = map.getUid();
        List<User> userList = userimpl.findByIdUser(uid);
            model.addAttribute("userList",userList.get(0));
        return "/qiantai/usercenter-info";
    }
    /**
     * 修改头像
     */
    @RequestMapping("/UpdateHead")
    @ResponseBody
    public Object UpdateHead(MultipartFile file, HttpSession session) {
        JSONObject res = new JSONObject();
        JSONObject res1 = new JSONObject();
        //保存图片的路径
        String filePath = "D:\\images";
        if (!file.isEmpty()) {
            //文件的完整名称,如spring.jpeg
            String filename = file.getOriginalFilename();
            String filenewname= "/"+filename;
            //封装上传文件位置的全路径
            File targetFile = new File(filePath, filename);
            //把本地文件上传到封装上传文件位置的全路径
            try {
                //保存图片
                User map = (User) session.getAttribute("user");
                int uid = map.getUid();
                file.transferTo(targetFile);
                User user = new User();
                user.setUid(uid);
                user.setHead(filenewname);
                userimpl.UpdateLead(user);
                //获取用户的session信息
                res1.put("src", filePath);
                res.put("data", res1);
                res.put("code", 0);
                res.put("msg", "上传成功!");
            } catch (IOException e) {
                res.put("code", -1);
                res.put("msg", "端口出异常了!");
                e.printStackTrace();
            }
        } else {
            res.put("code", -1);
            res.put("msg", "请选择文件!");
        }
        return res;
    }
    //显示修改页面
    @RequestMapping("/updateusershow")
    public String updateusershow(Model model, HttpSession session) {
        User map = (User) session.getAttribute("user");
        int uid = map.getUid();
        List<User> userList = userimpl.findByIdUser(uid);
        model.addAttribute("userList",userList.get(0));
        return "/qiantai/userupdate";
    }
    //修改用户个人信息
    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam Map map ,HttpSession session) {
        User map1 = (User) session.getAttribute("user");
        int uid = map1.getUid();
        //创建用户对象
        User users = new User();
        //获取需要修改的值并修改实体类的属性值
        users.setUid(uid);
        users.setLearname((String) map.get("learname"));
        users.setPhone((String) map.get("phone"));
        int i = userimpl.UpdateUser(users);
        return "redirect:findUser";
    }

    //修改密码
    @RequestMapping("/updatepwd")
    public String updatepwd(@RequestParam Map map ,HttpSession session) {
        User map1 = (User) session.getAttribute("user");
        int uid = map1.getUid();
        //创建用户对象
        User users = new User();
        //获取需要修改的值并修改实体类的属性值
        users.setUid(uid);
        users.setPass((String) map.get("pass"));
        userimpl.UpdatePwd(users);
        return "redirect:login";
    }

    /**
     * 跳转到首页
     */

    @RequestMapping("toIndex")
    public String toIndex(Model model){
        List<House> houses = houseimp.findAllHouse();
        model.addAttribute("houses",houses);
        return "/qiantai/tujia";
    }

    //退出
    @RequestMapping("/logout")
    public String out(HttpServletRequest request)
    {
        request.getSession().removeAttribute("errand");
        request.getSession().removeAttribute("landlord");
        return "qiantai/denglu/index";
    }
}
