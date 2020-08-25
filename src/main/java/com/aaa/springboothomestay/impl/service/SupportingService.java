package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.Supporting;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupportingService {
    public int insert(Supporting supporting);
    public int update(Supporting supporting);
    public int delete(Supporting supporting);
    public List<Supporting> query();
}
