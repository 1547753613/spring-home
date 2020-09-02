package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.UsersDao;
import com.aaa.springboothomestay.entity.Admins;
import com.aaa.springboothomestay.entity.Landlord;
import com.aaa.springboothomestay.entity.User;
import com.aaa.springboothomestay.impl.service.UsersService;
import com.aaa.springboothomestay.util.PageEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UsersImpl implements UsersService {

    @Resource
    UsersDao usersDao;

    /**
     *
     * @param pageNum 第几页
     * @param pageSize 每页数据
     * @param realname  模糊查询
     * @return
     */
    @Override
    public PageInfo<User> SelectUserAll(Integer pageNum, Integer pageSize, String realname) {
        List<User> users;
        PageEntity pageEntity=new PageEntity(pageNum,pageSize);
        PageHelper.startPage(pageEntity.getPageNum(),pageEntity.getPageSize());
        if (null!=realname){
            realname="%"+realname+"%";
            Example example=new Example(User.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("uname",realname);
             users = usersDao.selectByExample(example);

        }else {
             users = usersDao.selectAll();
        }
        PageInfo<User> pageInfo= new PageInfo<User>(users);


        return pageInfo;
    }

    @Override
    public User SelectUserId(Integer uid) {

        User user = usersDao.selectByPrimaryKey(uid);
        return user;
    }
}
