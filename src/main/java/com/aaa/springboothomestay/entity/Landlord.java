package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

@Data
public class Landlord {
    @Id
    private Integer lid;//	int 	主键编号
    private String nickname;//	varchar	昵称
    private String realname;//	varchar	真实姓名
    private String idcard;//	varchar	身份证
    private String idcardimg;//	varchar	身份证照片
    private String head;//	varchar	头像
    private String phone;//	varchar	手机号
    private String pass;//	varchar	密码
    @Column(name = "nativePlave")
    private String nativePlave;//	varchar	籍贯
    private String city;//	varchar	市区
    private String address;//	varchar	详情地址
    private String email;//	varchar	邮箱
    private String account;//varchar	账户
    private Integer state;//	int	状态
    private String greeting;//	varchar	房东欢迎语

    private List<House> houses;//房东名下房产
}
