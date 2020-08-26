package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.HouseMany;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseManyService {
    int insert(HouseMany houseMany);
    int delete(HouseMany houseMany);
    int update(HouseMany houseMany);
    List<HouseMany> query();
}
