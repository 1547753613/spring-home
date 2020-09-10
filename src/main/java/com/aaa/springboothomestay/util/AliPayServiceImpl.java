package com.aaa.springboothomestay.util;

import com.alipay.api.AlipayApiException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AliPayServiceImpl implements PayService {
    @Resource
    private Alipay alipay;
    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }
}
