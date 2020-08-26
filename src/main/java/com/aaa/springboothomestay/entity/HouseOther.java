package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class HouseOther {
    //house_other	房屋其他费用表
    @Id
    private Integer id;//	int 	主键id
    private Integer hid;//	int 	房屋id
    private Integer oid;//	int 	其他费用类型表
    private Integer count;//	int 	数量
    private Double many;//	double	金额
}
