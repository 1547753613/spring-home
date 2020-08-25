package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Bedtype {
    @Id
    private Integer bid;//	int 	主键id
    private String bame;//	varchar	床型(双人床，单人床...)
    private Integer parentid;//	int 	父id

}
