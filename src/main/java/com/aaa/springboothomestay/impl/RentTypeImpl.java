package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.RentTypeDao;
import com.aaa.springboothomestay.entity.Renttype;
import com.aaa.springboothomestay.impl.service.RentTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RentTypeImpl implements RentTypeService {
    @Resource
    RentTypeDao rentTypeDao;
    @Override
    public int insert(Renttype renttype) {
        return rentTypeDao.insert(renttype);
    }

    @Override
    public int update(Renttype renttype) {
        return rentTypeDao.updateByPrimaryKeySelective(renttype);
    }

    @Override
    public int delete(int id) {
        return rentTypeDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<Renttype> query() {
        return null;
    }
}
