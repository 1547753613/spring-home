package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.Requiretype;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequireTypeService {
    public List<Requiretype> byhidquery(int id);
}
