package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.SpecifictypeDao;
import com.aaa.springboothomestay.entity.Specifictype;
import com.aaa.springboothomestay.impl.service.SpecifictypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SpecifictypeImpl implements SpecifictypeService {
    @Resource
    SpecifictypeDao specifictypeDao;
    @Override
    public int insert(Specifictype specifictype) {
        return specifictypeDao.insert(specifictype);
    }

    @Override
    public int update(Specifictype specifictype) {
        return specifictypeDao.updateByPrimaryKeySelective(specifictype);
    }

    @Override
    public int delete(Specifictype specifictype) {
        return specifictypeDao.delete(specifictype);
    }

    @Override
    public List<Specifictype> query() {
        return specifictypeDao.selectAll();
    }
}
