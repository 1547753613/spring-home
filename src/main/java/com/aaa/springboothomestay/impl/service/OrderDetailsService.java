package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.OrdersDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface OrderDetailsService {

    public OrdersDetails SelectOrderOid(Integer oid);

    /**
     *
     * @param ordersDetails 添加订单详情
     * @return
     */
    public Integer AddOrdersDetails(OrdersDetails ordersDetails);
}
