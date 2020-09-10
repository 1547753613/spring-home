package com.aaa.springboothomestay.util;

import com.alipay.api.AlipayApiException;

public interface PayService {


    String aliPay(AlipayBean alipayBean) throws AlipayApiException;

}
