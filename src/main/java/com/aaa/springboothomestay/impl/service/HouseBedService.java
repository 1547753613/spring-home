package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.HouseBed;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseBedService {
    int insert(HouseBed houseBed);
    int update(HouseBed houseBed);
    int delete(HouseBed houseBed);
    List<HouseBed> query();
}
