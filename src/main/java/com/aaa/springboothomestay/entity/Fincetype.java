package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Fincetype {
    //fincetype	财务流水类型表
    @Id
    private Integer id;//	int 	主键id
    private String fname;//	varchar	财务类型(收入,支出,流动资金)
}
