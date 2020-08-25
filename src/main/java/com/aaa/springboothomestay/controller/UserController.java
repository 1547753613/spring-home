package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.User;
import com.aaa.springboothomestay.impl.UserImpl;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    UserImpl userimpl;
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
        model.addAttribute("user",user);
        session.setAttribute("user",user);
        return "/qiantai/tujia";
    }

    /**
     * 查询用户个人信息
     */
    @RequestMapping("/findUser")
    public String findUser(Model model, HttpSession httpSession){
        if (httpSession.getAttribute("user")==null){
           // System.out.println(1);

            return "redirect:/login";
        }

       User map = (User) httpSession.getAttribute("user");
        int uid = map.getUid();

        List<User> userList = userimpl.findByIdUser(uid);
        System.out.println(userimpl.findByIdUser(uid));
        model.addAttribute("userList",userList.get(0));
        return "/qiantai/usercenter-info";
    }

    /**
     * 修改头像
     */
    @RequestMapping("/UpdateHead")
    @ResponseBody
    public Object usersImageUpload(MultipartFile file, HttpSession session) {
        JSONObject res = new JSONObject();
        JSONObject res1 = new JSONObject();
        //保存图片的路径
        String filePath = "D:\\images";
        if (!file.isEmpty()) {
            //文件的完整名称,如spring.jpeg
            String filename = file.getOriginalFilename();
            //获取时间戳
            String newDatetime = String.valueOf(System.currentTimeMillis());
            //文件后缀,如.jpegxx
            String suffix = filename.substring(filename.lastIndexOf("."));
            // 生成文件新的名字
            String newFileName = UUID.randomUUID() + "-" + newDatetime + suffix;

            String dateFileName = newFileName ;
            //封装上传文件位置的全路径
            File targetFile = new File(filePath, newFileName);
            //把本地文件上传到封装上传文件位置的全路径
            try {
                //保存图片
                User map = (User) session.getAttribute("user");
                int uid = map.getUid();
                file.transferTo(targetFile);
                User user = new User();
                user.setUid(uid);
                user.setHead(dateFileName);
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


    //修改用户个人信息
    @RequestMapping("/updatepwd")
    public String UpdatePwd(@RequestParam Map map ,HttpSession session,String pass) {
        System.out.println("进");
        User map1 = (User) session.getAttribute("user");
        int uid = map1.getUid();
        //创建用户对象
        User users = new User();
        //获取需要修改的值并修改实体类的属性值
        users.setUid(uid);
        users.setPass((String) map.get("pass"));
        int i = userimpl.UpdatePwd(pass);
        System.out.println(userimpl.UpdatePwd(pass));
        return "redirect:findUser";
    }



}
