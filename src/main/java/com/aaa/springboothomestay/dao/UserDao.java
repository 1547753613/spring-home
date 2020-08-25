package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserDao  {
    @Select("select * from user where uname = #{param1} and pass = #{param2}")
    User findByDenglu (String uname,String pass);
    @Insert("insert into user " +
            "(uname,pass,phone)" +
            "values" +
            "(#{uname},#{pass},#{phone})")
    Integer zhuce(User user);

    /**
     * 查询用户个人信息
     * @param uid
     * @return
     */
    List<User> findByIdUser(Integer uid);

    /**
     * 修改头像
     * @param user
     * @return
     */
    Integer UpdateLead(User user);

    /**
     * 修改用户个人信息
     */
    Integer UpdateUser(User user);

    /**
     * 修改密码
     * @param pass
     * @return
     */
    Integer UpdatePwd(String pass);





}
