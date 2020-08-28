package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.HouseBedDao;
import com.aaa.springboothomestay.entity.HouseBed;
import com.aaa.springboothomestay.impl.service.HouseBedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HouseBedImpl implements HouseBedService {
    @Resource
    HouseBedDao houseBedDao;
    @Override
    public int insert(HouseBed houseBed) {
        return houseBedDao.insert(houseBed);
    }

    @Override
    public int update(HouseBed houseBed) {
        return houseBedDao.updateByPrimaryKeySelective(houseBed);
    }

    @Override
    public int delete(HouseBed houseBed) {
        return houseBedDao.delete(houseBed);
    }

    @Override
    public List<HouseBed> query() {
        return houseBedDao.selectAll();
    }

    public List<HouseBed> byhidquery(int id)
    {
        HouseBed houseBed = new HouseBed();
        houseBed.setHid(id);
        return houseBedDao.select(houseBed);
    }
}
