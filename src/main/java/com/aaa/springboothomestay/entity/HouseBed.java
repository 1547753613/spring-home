package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class HouseBed {
    @Id
   private Integer id;//	int 	主键id
   private Integer hid;//	int 	外键房屋id
   private Integer bid;//	int 	外键床型表id
   private Integer count;//	int 	床数量
}
