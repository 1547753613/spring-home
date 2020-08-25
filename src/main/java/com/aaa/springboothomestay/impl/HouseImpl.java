package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.HouseDao;
import com.aaa.springboothomestay.entity.House;
import com.aaa.springboothomestay.impl.service.HouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HouseImpl implements HouseService {
    @Resource
    HouseDao houseDao;

    @Override
    public List<House> findAllHouse() {
        return houseDao.findAllHouse();
    }
}
