package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
public class HouseSup {
    //house_sup	房屋配套设施表
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//	int 	主键id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hid;//	int 	外键房屋id
    private Integer sid;//	int 	外键配套设施表
    private Integer state;//	int 	状态(0代表不具备,1代表具备设施)
    private Supporting supporting;
}
