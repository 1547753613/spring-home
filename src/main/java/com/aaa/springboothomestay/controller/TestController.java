package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.aliyun.AliOSS;
import com.aaa.springboothomestay.code.Result;
import com.aaa.springboothomestay.code.ResultCode;
import com.aaa.springboothomestay.code.ResultUtil;
import com.aaa.springboothomestay.dao.OrdersDetailsDao;
import com.aaa.springboothomestay.entity.Admins;
import com.aaa.springboothomestay.entity.User;
import com.aaa.springboothomestay.impl.OrdersImpl;
import com.aaa.springboothomestay.impl.service.AdminService;
import com.aaa.springboothomestay.impl.service.UsersService;
import com.aaa.springboothomestay.util.AlipayConfigOne;
import com.aaa.springboothomestay.util.MultipartFileToFile;
import com.aaa.springboothomestay.util.UUIDUtils;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

@CrossOrigin
@Controller
@RequestMapping("muniao/test")
public class TestController {

    @Autowired
    UsersService usersService;

    @Autowired
    AdminService adminService;
    @Autowired
    OrdersDetailsDao orderDetailsDao;
    @Resource
    OrdersImpl ordersimp;
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


    @RequestMapping("/zftest")
    public void pay(HttpServletResponse rep,Double money,Integer oid,Integer od) throws AlipayApiException, IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfigOne.gatewayUrl, AlipayConfigOne.app_id, AlipayConfigOne.merchant_private_key, "json", AlipayConfigOne.charset, AlipayConfigOne.alipay_public_key, AlipayConfigOne.sign_type);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfigOne.return_url);
        alipayRequest.setNotifyUrl(AlipayConfigOne.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = UUID.randomUUID().toString().replace("-","");
        //付款金额，必填  (随机生成 0-1000)
        //String total_amount =String.valueOf(Math.floor(Math.random() * 1000+1));
        String check = out_trade_no.substring(0,5);
        orderDetailsDao.updatebyoid(oid,money,new Date(),check);
        ordersimp.updatebyoid(od,2);
        String total_amount =String.valueOf(money);
        //订单名称，必填
        String subject = "途家民宿住宿订单";
        //商品描述，可空
        String body = "在线支付";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");


        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        rep.setContentType("text/html;charset=" + AlipayConfigOne.charset);
        rep.getWriter().write(result);//直接将完整的表单html输出到页面
        rep.getWriter().flush();
        rep.getWriter().close();
    }
    @RequestMapping("/return_url.view")
    public String returnUrl(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws AlipayApiException, UnsupportedEncodingException, UnsupportedEncodingException {
        return "/qiantai/tujia";
    }
}
