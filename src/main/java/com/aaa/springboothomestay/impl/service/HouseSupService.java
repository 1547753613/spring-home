package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.HouseSup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseSupService {
    int insert(HouseSup houseSup);
    int update(HouseSup houseSup);
    int delete(HouseSup houseSup);
    List<HouseSup> query();
}
