package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.HouseRequireDao;
import com.aaa.springboothomestay.entity.HouseRequire;
import com.aaa.springboothomestay.impl.service.HouseRequireService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class HouseRequireImpl implements HouseRequireService {
    @Resource
    HouseRequireDao houseRequireDao;
    @Override
    public int insert(HouseRequire houseRequire) {
        return houseRequireDao.insert(houseRequire);
    }

    @Override
    public int update(HouseRequire houseRequire) {
        return houseRequireDao.updateByPrimaryKeySelective(houseRequire);
    }

    @Override
    public int delete(HouseRequire houseRequire) {
        return houseRequireDao.delete(houseRequire);
    }

    @Override
    public List<HouseRequire> query() {
        return houseRequireDao.selectAll();
    }
}
