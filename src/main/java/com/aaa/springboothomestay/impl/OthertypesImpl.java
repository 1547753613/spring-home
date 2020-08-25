package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.OthertypesDao;
import com.aaa.springboothomestay.entity.Othertypes;
import com.aaa.springboothomestay.impl.service.OthertypesService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OthertypesImpl implements OthertypesService {
    @Resource
    OthertypesDao othertypesDao;

    @Override
    public int insert(Othertypes othertypes) {
        return othertypesDao.insert(othertypes);
    }

    @Override
    public int update(Othertypes othertypes) {
        return othertypesDao.updateByPrimaryKeySelective(othertypes);
    }

    @Override
    public int delete(Othertypes othertypes) {
        return othertypesDao.delete(othertypes);
    }

    @Override
    public List<Othertypes> query() {
        return othertypesDao.selectAll();
    }
}
