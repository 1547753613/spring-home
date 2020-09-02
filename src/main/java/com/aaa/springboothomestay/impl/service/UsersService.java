package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {

    /**
     *
     * @param pageNum 第几页
     * @param PageSize 每页数据
     * @param realname  模糊查询
     * @return
     */
    public PageInfo<User> SelectUserAll(Integer pageNum,Integer PageSize,String realname);

    /**
     *
     * @param uid 根据用户id查用户
     * @return
     */
    public User    SelectUserId(Integer uid);
}
