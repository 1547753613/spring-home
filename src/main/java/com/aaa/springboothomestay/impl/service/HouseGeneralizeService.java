package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.HouseGeneralize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseGeneralizeService {
    int insert(HouseGeneralize houseGeneralize);
    int delete(HouseGeneralize houseGeneralize);
    int update(HouseGeneralize houseGeneralize);
    List<HouseGeneralize> query();
}
