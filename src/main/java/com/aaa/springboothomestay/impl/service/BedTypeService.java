package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.Bedtype;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BedTypeService {
    public int insert(Bedtype bedtype);
    public int update(Bedtype bedtype);
    public int delete(Bedtype bedtype);
    public List<Bedtype> query();
}
