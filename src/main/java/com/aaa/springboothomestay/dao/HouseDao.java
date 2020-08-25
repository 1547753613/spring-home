package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.House;

import java.util.List;

public interface HouseDao {
    List<House> findAllHouse();
}
