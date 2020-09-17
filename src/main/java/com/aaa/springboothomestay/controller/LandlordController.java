package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.code.Result;
import com.aaa.springboothomestay.dao.OrdersDetailsDao;
import com.aaa.springboothomestay.entity.Landlord;
import com.aaa.springboothomestay.impl.LandlordImpl;
import com.aaa.springboothomestay.impl.OrdersImpl;
import com.aaa.springboothomestay.util.AlipayConfigOne;
import com.aaa.springboothomestay.util.IdentityCardOCR;
import com.aaa.springboothomestay.util.MultipartFileToFile;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RequestMapping("muniao/Landlord")
@Controller
public class LandlordController {
    @Resource
    LandlordImpl landlordimp;
    @Resource
    TestController testController;
    @Autowired
    OrdersDetailsDao orderDetailsDao;
    @Resource
    OrdersImpl ordersimp;
    @RequestMapping("insert")
    @ResponseBody
    public int insert(Landlord landlord)
    {
        System.out.println(landlord+"=====================");
        landlord.setEmail(0);
        landlord.setState(1);
        return landlordimp.add(landlord);
    }
    @RequestMapping("query")
    @ResponseBody
    public List<Landlord> query()
    {
        return landlordimp.query();
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(Landlord landlord)
    {
//        landlord.setLid(1);
//        landlord.setGreeting("我家安阳半条街，有啥事找我就完事了");
        return landlordimp.update(landlord);
    }
    @RequestMapping("querybyid")
    @ResponseBody
    public Landlord querybyid(int id)
    {
        return landlordimp.querybyid(id);
    }
    @RequestMapping("tolandlord")
    public String tolandlord()
    {
        return "/qiantai/MOveH";
    }
    @RequestMapping("uploadcardimg")
    @ResponseBody
    public Map<String,Object> cardcheck(MultipartFile file) throws Exception {
        File file1 = MultipartFileToFile.multipartFileToFile(file);
        IdentityCardOCR identityCardOCR = new IdentityCardOCR();
        Result result = testController.upload(file);
        Map<String,Object> map = identityCardOCR.discern(file1.getAbsolutePath());
        map.put("imgpath",result);
        return map;
    }
    @RequestMapping("headimg")
    @ResponseBody
    public synchronized Map<String,Object> headimg(MultipartFile file) throws Exception {
        Result result = testController.upload(file);
        Map<String,Object> map = (Map<String, Object>) result.getData();
        return map;
    }
    @RequestMapping("/zftest")
    public void pay(HttpServletResponse rep, Double money, Integer oid, Integer od) throws AlipayApiException, IOException {
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
        ordersimp.updatebyoid(od,3);
        System.out.println(od);
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
    public String returnUrl(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws AlipayApiException, UnsupportedEncodingException, UnsupportedEncodingException {
        return "/qiantai/tujia";
    }

}
