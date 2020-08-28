package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
public class HouseBed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;//	int 	主键id
   private Integer hid;//	int 	外键房屋id
   private Integer bid;//	int 	外键床型表id
   private Integer count;//	int 	床数量
   private Bedtype bedtype;
}
