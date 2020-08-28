package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.House;
import com.aaa.springboothomestay.entity.HouseRules;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseRulesService {
    int insert(HouseRules houseRules);
    int update(HouseRules houseRules);
    int delete(HouseRules houseRules);
    List<HouseRules> query();
}
