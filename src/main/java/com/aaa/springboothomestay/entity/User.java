package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "user")
public class User {
    @Id
    private Integer uid;//	int	主键编号
    private String uname;//	varchar	昵称
    private String phone;//	varchar	手机号
    private String pass;//	varchar	密码
    private String head;//	varchar	头像
    private String idcard;//	varchar	身份证
    private Integer state;//	int	状态
    private String learname;//	varchar	真实姓名

}
