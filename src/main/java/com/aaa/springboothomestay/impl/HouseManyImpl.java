package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.HouseManyDao;
import com.aaa.springboothomestay.entity.HouseMany;
import com.aaa.springboothomestay.impl.service.HouseManyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HouseManyImpl implements HouseManyService {
@Resource
    HouseManyDao houseManyDao;
    @Override
    public int insert(HouseMany houseMany) {
        return houseManyDao.insert(houseMany);
    }

    @Override
    public int delete(HouseMany houseMany) {
        return houseManyDao.delete(houseMany);
    }

    @Override
    public int update(HouseMany houseMany) {
        return houseManyDao.updateByPrimaryKeySelective(houseMany);
    }

    @Override
    public List<HouseMany> query() {
        return houseManyDao.selectAll();
    }
}
