package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.Housetype;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseTypeService {
    public List<Housetype> query();
    public int update(Housetype housetype);
    public int insert(Housetype housetype);
    public int delete(int id);



    public List<Housetype> querybyname(Housetype housetype);
}
