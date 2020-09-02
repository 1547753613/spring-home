package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.HouseSupDao;
import com.aaa.springboothomestay.entity.HouseSup;
import com.aaa.springboothomestay.impl.service.HouseSupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HouseSupImpl implements HouseSupService {
    @Resource
    HouseSupDao houseSupDao;
    @Override
    public int insert(HouseSup houseSup) {
        return houseSupDao.insert(houseSup);
    }

    @Override
    public int update(HouseSup houseSup) {
        return houseSupDao.updateByPrimaryKeySelective(houseSup);
    }

    @Override
    public int delete(HouseSup houseSup) {
        return houseSupDao.delete(houseSup);
    }

    @Override
    public List<HouseSup> query() {
        return houseSupDao.selectAll();
    }
    public List<HouseSup> byhidquery(int id)
    {
        HouseSup houseSup1 = new HouseSup();
        houseSup1.setHid(id);
        return houseSupDao.select(houseSup1);
    }
}
