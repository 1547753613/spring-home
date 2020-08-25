package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.MenuRole;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface MenuRoleDao  extends Mapper<MenuRole>, MySqlMapper<MenuRole> {
}
