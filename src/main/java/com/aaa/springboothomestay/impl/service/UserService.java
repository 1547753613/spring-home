package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User findByDenglu (String uname,String pass);
    Integer zhuce(User user);
}
