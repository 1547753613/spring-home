package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Renttype {
    @Id
    private Integer rid;//	int 	主键id
    private String tname;//	varchar	出租类型(整套，单间)
    private String icon;//	varchar	图标

}
