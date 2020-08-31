package com.aaa.springboothomestay.entity;
import lombok.Data;
import javax.persistence.Id;
import java.util.Date;

@Data
public class HouseRules {
    //house_rules	房屋规则表
    @Id
    private Integer id;//	int 	主键id
    private Integer hid;//	int 	外键房屋id
    private Integer liblecount;//	int 	易住人数
    private Integer days;//	int 	最少入住天数
    private String atcheck;//	date	最早入住时间
    private String lastcheck;//	date	最晚入住时间
    private Integer rules;//	int 	更换频次(0为一客一换,1为一天一换)
    private Integer uid;//	int 	外键退订规则表
    private String checkout;//	date	最晚退房时间

    private Unsubscribe unsubscribe;//退订规则
}
