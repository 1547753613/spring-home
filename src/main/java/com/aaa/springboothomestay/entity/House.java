package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//	int 	主键id
    private String hname;//	varchar	房源名称
    private String simg;//	varchar	封面图
    private String himg;//	varchar	详情图
    private Integer lid;//	int 	外键房东表
    private Integer rid;//	int 	外键出租方式表
    private Integer sid;//	int 	房源具体类型表
    private String feature;//	varchar	房源特色
    private Double xcoord;//	double	地图x轴
    private Double ycoord;//	double	地图y轴
    private String traffic;//	varchar	交通位置
    private Integer state;//	int 	状态
    private String rim;//	varchar	周边介绍
//    private List<HouseRequire> house_require;
//    private List<HouseRules> house_rules;
//    private List<HouseAddress> house_address;
//    private List<HouseOther> house_other;
//    private List<HouseMany> house_many;
//    private List<HouseSup>  house_sup;
//    private List<HouseBed> house_bed;
//    private List<Specifictype> specifictype;
}
