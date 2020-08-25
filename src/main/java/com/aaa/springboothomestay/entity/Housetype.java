package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Housetype {
    @Id
    private Integer id;//	int 	主键id
    private String hname;//	varchar	房源类型(别墅,四合院)
    private Double commission;//	double	抽成
    private String icon;//	varchar	图标
}
