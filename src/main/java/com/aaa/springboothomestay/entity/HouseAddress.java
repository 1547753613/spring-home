package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class HouseAddress {
    //house_address	房屋位置表
    @Id
    private Integer id;//	int 	主键id
    private Integer hid;//	int 	外键房屋id
    private String city;//	varchar	房源位置省市
    private String plot;//	varchar	小区街道
    private Integer card;//	int 	门牌号
    private String address;//	varchar	具体位置
    private String explains;// 	varchar	更多说明
    private House house;
}
