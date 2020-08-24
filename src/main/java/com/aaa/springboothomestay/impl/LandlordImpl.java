package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.LandlordDao;
import com.aaa.springboothomestay.entity.Landlord;
import com.aaa.springboothomestay.impl.service.LandlordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LandlordImpl implements LandlordService {
    @Resource
    LandlordDao landlordDao;
    @Override
    public int add(Landlord landlord) {
        return landlordDao.insert(landlord);
    }

    @Override
    public int update(Landlord landlord) {
        return landlordDao.updateByPrimaryKeySelective(landlord);
    }

    @Override
    public List<Landlord> query() {
        return landlordDao.selectAll();
    }

    @Override
    public Landlord querybyid(int id) {
        return landlordDao.selectByPrimaryKey(id);
    }
}
