package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.Collect;

import java.util.List;

public interface User_CollectDao {
    List<Collect> findAllCollect(Collect collect);
}
