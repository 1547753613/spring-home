package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Othertypes {
    @Id
    private Integer id;//	int 	主键id
    private String oname;//	varchar	其他收费类型(收取押金，加客)
}
