package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface UserDao  {
    @Select("select * from user where uname = #{param1} and pass = #{param2}")
    User findByDenglu (String uname,String pass);
    @Insert("insert into user " +
            "(uname,pass,phone)" +
            "values" +
            "(#{uname},#{pass},#{phone})")
    Integer zhuce(User user);

}
