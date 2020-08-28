package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.HouseRulesDao;
import com.aaa.springboothomestay.entity.HouseRules;
import com.aaa.springboothomestay.impl.service.HouseRulesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class HouseRulesImpl implements HouseRulesService {
    @Resource
    HouseRulesDao houseRulesDao;
    @Override
    public int insert(HouseRules houseRules) {
        return houseRulesDao.insert(houseRules);
    }

    @Override
    public int update(HouseRules houseRules) {
        return houseRulesDao.updateByPrimaryKeySelective(houseRules);
    }

    @Override
    public int delete(HouseRules houseRules) {
        return houseRulesDao.delete(houseRules);
    }

    @Override
    public List<HouseRules> query() {
        return houseRulesDao.selectAll();
    }
    public HouseRules byhidquery(int id)
    {
        HouseRules houseRules = new HouseRules();
        houseRules.setHid(id);
        return houseRulesDao.select(houseRules).get(0);
    }
}
