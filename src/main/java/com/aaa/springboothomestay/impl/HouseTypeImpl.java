package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.HouseTypeDao;
import com.aaa.springboothomestay.entity.Housetype;
import com.aaa.springboothomestay.impl.service.HouseTypeService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HouseTypeImpl implements HouseTypeService {
    @Resource
    HouseTypeDao houseTypeDao;
    @Override
    public List<Housetype> query() {
        return houseTypeDao.selectAll();
    }

    @Override
    public int update(Housetype housetype) {
        return houseTypeDao.updateByPrimaryKeySelective(housetype);
    }

    @Override
    public int insert(Housetype housetype) {
        return houseTypeDao.insert(housetype);
    }

    @Override
    public int delete(int id) {
        return houseTypeDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<Housetype> querybyname(Housetype housetype) {
        Example example = new Example(housetype.getClass());
        // where 条件
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(housetype.getHname());
        return houseTypeDao.selectByExample(example);
    }
}
