package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.HouseOther;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseOtherService {
    int add(HouseOther houseOther);
    int update(HouseOther houseOther);
    int delete(HouseOther houseOther);
    List<HouseOther> query();
}
