package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.RequireTypeDao;
import com.aaa.springboothomestay.entity.Requiretype;
import com.aaa.springboothomestay.impl.service.RequireTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RequireTypeImpl implements RequireTypeService {
    @Resource
    RequireTypeDao requireTypeDao;
    @Override
    public List<Requiretype> byhidquery(int id) {
        Requiretype requireType = new Requiretype();
        requireType.setId(id);
        return requireTypeDao.select(requireType);
    }
    @Override
    public Requiretype byidquery(int id)
    {
        return requireTypeDao.selectByPrimaryKey(id);
    }
    public List<Requiretype> query(){
        return requireTypeDao.selectAll();
    }
}
