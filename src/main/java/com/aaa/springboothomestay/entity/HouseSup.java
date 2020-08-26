package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class HouseSup {
    //house_sup	房屋配套设施表
    @Id
    private Integer id;//	int 	主键id
    private Integer hid;//	int 	外键房屋id
    private Integer sid;//	int 	外键配套设施表
    private Integer state;//	int 	状态(0代表不具备,1代表具备设施)
}
