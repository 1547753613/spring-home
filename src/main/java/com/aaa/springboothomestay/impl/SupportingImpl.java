package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.SupportintDao;
import com.aaa.springboothomestay.entity.Supporting;
import com.aaa.springboothomestay.impl.service.SupportingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SupportingImpl implements SupportingService {
    @Resource
    SupportintDao supportintDao;
    @Override
    public int insert(Supporting supporting) {
        return supportintDao.insert(supporting);
    }

    @Override
    public int update(Supporting supporting) {
        return supportintDao.updateByPrimaryKeySelective(supporting);
    }

    @Override
    public int delete(Supporting supporting) {
        return supportintDao.delete(supporting);
    }

    @Override
    public List<Supporting> query() {
        return supportintDao.selectAll();
    }

    /**
     *
     * @param id  房屋配套设施表
     * @return
     */
    public Supporting byidquery(int id)
    {
        return supportintDao.selectByPrimaryKey(id);
    }

}
