package com.aaa.springboothomestay.entity;

import lombok.Data;

@Data
public class HouseRequire {
    //house_require	房屋要求表
    private Integer id;//	int 	主键id
    private Integer hid;//	int 	房屋id
    private Integer rid;//	int 	房屋要求类型表
    private Integer state;//	int 	0为否1为是

}
