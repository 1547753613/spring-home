package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
public class HouseOther {
    //house_other	房屋其他费用表
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//	int 	主键id
    private Integer hid;//	int 	房屋id
    private Integer oid;//	int 	其他费用类型表
    private Integer count;//	int 	数量
    private Double many;//	double	金额
    //private Othertypes othertypes;
}
