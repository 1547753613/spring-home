package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.Specifictype;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpecifictypeService {
    public int insert(Specifictype specifictype);
    public int update(Specifictype specifictype);
    public int delete(Specifictype specifictype);
    public List<Specifictype> query();
}
