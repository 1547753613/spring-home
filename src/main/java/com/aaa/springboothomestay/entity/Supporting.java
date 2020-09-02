package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Supporting {
    @Id
    private Integer id;//	int 	主键id
    private String sname;//	varchar	配套设施
    private Integer parentid;//	int 	父id
    private String icon;//	varchar	图标
}
