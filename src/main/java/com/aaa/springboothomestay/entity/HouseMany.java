package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class HouseMany {
    //house_many	房屋价格表
    @Id
    private Integer id;//	int 	主键id
    private Double workday;//	double	工作日
    private Double weekend;//	double	周末
    private Double Holidays;//	double	节假日
    private Integer hid;//	int 	外键房屋id
}
