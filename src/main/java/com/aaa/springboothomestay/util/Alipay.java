package com.aaa.springboothomestay.util;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alipay {
    @Autowired
    AlipayConfig alipayConfig;
    /**
     * 支付接口
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    public String pay(AlipayBean alipayBean) throws AlipayApiException {
        System.out.println("pay"+alipayBean);
        // 1、获得初始化的AlipayClient   请求网关路径
        String serverUrl = alipayConfig.getGatewayUrl();
        System.out.println("config"+serverUrl);
        //appid 切换为沙箱的 appid
        String appId = alipayConfig.getAppId();
        System.out.println("沙箱的appid："+appId);
        //私钥
        String privateKey = alipayConfig.getPrivateKey();
        System.out.println("私钥的东西："+privateKey);
        String format = "json";
        String charset = alipayConfig.getCharset();
        System.out.println("私钥的东西："+charset);
        //公钥
        String alipayPublicKey = alipayConfig.getPublicKey();
        String signType = alipayConfig.getSignType();
        String returnUrl = alipayConfig.getReturnUrl();
        String notifyUrl = alipayConfig.getNotifyUrl();
        //AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do","2016072200101XXXX","请复制第1步中生成的密钥中的商户应用私钥","json","utf-8","沙箱环境RSA2支付宝公钥","RSA2");
        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, alipayPublicKey, signType);
        System.out.println("aplipayClient:"+alipayClient.toString());
        // 2、设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        // 页面跳转同步通知页面路径
        alipayRequest.setReturnUrl(returnUrl);
        System.out.println(returnUrl);
        // 服务器异步通知页面路径
        alipayRequest.setNotifyUrl(notifyUrl);
        // 封装参数
        alipayRequest.setBizContent(JSON.toJSONString(alipayBean));
        // 3、请求支付宝进行付款，并获取支付结果
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        // 返回付款信息
        return result;
    }


}
