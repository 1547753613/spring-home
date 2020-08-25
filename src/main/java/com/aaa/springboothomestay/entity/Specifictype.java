package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Specifictype {
    @Id
    private Integer sid;//	int 	主键id
    private String sname;//	varchar	房源具体类型
    private Integer id;//	int 	外键房源类型表

}
