package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.Othertypes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OthertypesService {
    public int insert(Othertypes othertypes);
    public int update(Othertypes othertypes);
    public int delete(Othertypes othertypes);
    public List<Othertypes> query();
}
