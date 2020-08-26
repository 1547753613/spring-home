package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.HouseOtherDao;
import com.aaa.springboothomestay.entity.HouseOther;
import com.aaa.springboothomestay.impl.service.HouseOtherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class HouseOtherImpl implements HouseOtherService {
    @Resource
    HouseOtherDao houseOtherDao;
    @Override
    public int add(HouseOther houseOther) {
        return houseOtherDao.insert(houseOther);
    }

    @Override
    public int update(HouseOther houseOther) {
        return houseOtherDao.updateByPrimaryKeySelective(houseOther);
    }

    @Override
    public int delete(HouseOther houseOther) {
        return houseOtherDao.delete(houseOther);
    }

    @Override
    public List<HouseOther> query() {
        return houseOtherDao.selectAll();
    }
}
