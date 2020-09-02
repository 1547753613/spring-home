package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.User;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@org.apache.ibatis.annotations.Mapper
public interface UsersDao extends Mapper<User>, MySqlMapper<User> {
}
