package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.Renttype;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentTypeService {
    public int insert(Renttype renttype);
    public int update(Renttype renttype);
    public int delete(int id);
    public List<Renttype> query();
}
