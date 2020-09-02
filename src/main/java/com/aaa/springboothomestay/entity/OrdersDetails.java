package com.aaa.springboothomestay.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "orders_details")
public class OrdersDetails {
    @Id
    private Integer id;//	int	主键
    private Integer oid;//	varchar	订单表外键
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column
    private Date checkdate;//	date	入住时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column
    private Date leavedate;//	date	离开时间
    private Integer day;//	int	天数
    private  Integer housecount;//	int	房屋套数
    private Integer checkcount;//	int	入住人数
    private String checkname;//	varchar	入住人
    private String phone;//	varchar	手机号
    private Double price;//	double	订单总价
    private Double amount;//	double	实付金额
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column
    private Date paytime;//	date	支付时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column
    private Date totime;//	date	实际入住时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column
    private Date gotime;//	date	实际离开时间

}
