package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.HouseGeneralizeDao;
import com.aaa.springboothomestay.entity.HouseGeneralize;
import com.aaa.springboothomestay.impl.service.HouseGeneralizeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class HouseGeneralizeImpl implements HouseGeneralizeService {
    @Resource
    HouseGeneralizeDao houseGeneralizeDao;
    @Override
    public int insert(HouseGeneralize houseGeneralize) {
        return houseGeneralizeDao.insert(houseGeneralize);
    }

    @Override
    public int delete(HouseGeneralize houseGeneralize) {
        return houseGeneralizeDao.delete(houseGeneralize);
    }

    @Override
    public int update(HouseGeneralize houseGeneralize) {
        return houseGeneralizeDao.updateByPrimaryKeySelective(houseGeneralize);
    }

    @Override
    public List<HouseGeneralize> query() {
        return houseGeneralizeDao.selectAll();
    }
    public HouseGeneralize byhidquery(int id)
    {
        HouseGeneralize houseGeneralize = new HouseGeneralize();
        houseGeneralize.setHid(id);
        return (HouseGeneralize) houseGeneralizeDao.select(houseGeneralize).get(0);
    }
}
