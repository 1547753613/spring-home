package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.HouseAddress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseAddressService {
    int insert(HouseAddress houseAddress);
    int udpate(HouseAddress houseAddress);
    int delete(HouseAddress houseAddress);
    List<HouseAddress> query();
    List<HouseAddress> findByCity(String city);
}
