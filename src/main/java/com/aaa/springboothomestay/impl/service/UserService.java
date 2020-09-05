package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User findByDenglu (String uname,String pass);
    Integer zhuce(User user);


    /**
     * 查询用户个人信息
     */
    List<User> findByIdUser(Integer uid);

    /**
     * 修改头像
     * @param user
     * @return
     */
    int UpdateLead(User user);

    /**
     * 修改用户个人信息
     * @param user
     * @return
     */
    Integer UpdateUser(User user);

    /**
     * 修改密码
     * @param pass
     * @return
     */
    Integer UpdatePwd(String pass);
}
