package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.UserDao;
import com.aaa.springboothomestay.entity.User;
import com.aaa.springboothomestay.impl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<User> findByIdUser(Integer uid) {
        return userDao.findByIdUser(uid);
    }

    @Override
    public int UpdateLead(User user) {
        return userDao.UpdateLead(user);
    }

    @Override
    public Integer UpdateUser(User user) {
        return userDao.UpdateUser(user);
    }

    @Override
    public Integer UpdatePwd(String pass) {
        return userDao.UpdatePwd(pass);
    }
}
