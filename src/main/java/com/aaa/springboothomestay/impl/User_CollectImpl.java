package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.User_CollectDao;
import com.aaa.springboothomestay.entity.Collect;
import com.aaa.springboothomestay.impl.service.User_CollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class User_CollectImpl implements User_CollectService {

    @Resource
    User_CollectDao user_collectDao;


    @Override
    public List<Collect> findAllCollect(Collect collect) {
        return user_collectDao.findAllCollect(collect);
    }
}
