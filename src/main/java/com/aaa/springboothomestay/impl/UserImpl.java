package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.UserDao;
import com.aaa.springboothomestay.entity.User;
import com.aaa.springboothomestay.impl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public User findByDenglu(String uname, String pass) {
        return userDao.findByDenglu(uname, pass);
    }

    @Override
    public Integer zhuce(User user) {
        return userDao.zhuce(user);
    }
}
