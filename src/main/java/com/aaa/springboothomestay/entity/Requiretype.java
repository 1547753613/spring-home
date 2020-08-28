package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Requiretype {
    @Id
    private int id;//	int 	主键id
    private String rname;//	varchar	要求(接待老人,携带宠物...)
}
