package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.House;
import com.aaa.springboothomestay.entity.HouseRequire;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseRequireService {
    int insert(HouseRequire houseRequire);
    int update(HouseRequire houseRequire);
    int delete(HouseRequire houseRequire);
    List<HouseRequire> query();
}
