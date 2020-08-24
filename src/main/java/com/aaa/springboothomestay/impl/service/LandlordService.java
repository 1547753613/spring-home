package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.Landlord;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface LandlordService {
    public int add(Landlord landlord);
    public int update(Landlord landlord);
    public List<Landlord> query();
    public Landlord querybyid(int id);
}
