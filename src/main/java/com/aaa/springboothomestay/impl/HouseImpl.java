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
    public int insert(House house) {
        return houseDao.insert(house);
    }

    @Override
    public int update(House house) {
        return houseDao.updateByPrimaryKeySelective(house);
    }

    @Override
    public int delete(House house) {
        return houseDao.delete(house);
    }

    @Override
    public List<House> query() {
        return houseDao.selectAll();
    }

    @Override
    public List<House> querybyid(House house) {
        return houseDao.ByIdfindAll(house.getId());
    }
}
