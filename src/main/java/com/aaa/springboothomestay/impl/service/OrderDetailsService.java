package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.OrdersDetails;
import org.springframework.stereotype.Service;

@Service
public interface OrderDetailsService {

    public OrdersDetails SelectOrderOid(Integer oid);
}
