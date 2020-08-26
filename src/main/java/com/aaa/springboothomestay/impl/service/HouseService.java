package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.House;

import java.util.List;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HouseService {
    List<House> findAllHouse();






    public int insert(House house);
    public int update(House house);
    public int delete(House house);
    public List<House> query();
}