package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Fince {
    //fince	财务流水表
    @Id
    private Integer id;//	int 	主键id
    private Integer fid;//	int 	财务流水类型表外键
    private Integer oid;//	int 	订单表外键
    private Double price;//	double	金额

}
