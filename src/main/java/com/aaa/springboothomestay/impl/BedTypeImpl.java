package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.BedTypeDao;
import com.aaa.springboothomestay.entity.Bedtype;
import com.aaa.springboothomestay.impl.service.BedTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BedTypeImpl implements BedTypeService {
    @Resource
    BedTypeDao bedTypeDao;

    @Override
    public int insert(Bedtype bedtype) {
        return bedTypeDao.insert(bedtype);
    }

    @Override
    public int update(Bedtype bedtype) {
        return bedTypeDao.updateByPrimaryKey(bedtype);
    }

    @Override
    public int delete(Bedtype bedtype) {
        return bedTypeDao.delete(bedtype);
    }

    @Override
    public List<Bedtype> query() {
        return bedTypeDao.selectAll();
    }
    public List<Bedtype> bybidquery(int id)
    {
        Bedtype bedtype = new Bedtype();
        bedtype.setBid(id);
        return bedTypeDao.select(bedtype);
    }
}
