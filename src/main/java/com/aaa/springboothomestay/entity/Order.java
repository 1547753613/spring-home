package com.aaa.springboothomestay.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@Table(name = "orders")
public class Order {
    @Id
    private Integer id;//	varchar	主键
    private Integer hid;//	int	房屋表外键
    private Integer uid;//	int	用户表外键
    private Integer status;//	int	1待支付，2待入住，3待退房，4已完成，5已关闭，6待处理，7已处理,8维权订单'
    private String cdemo;//	varchar	取消原因说明
    private String protect;//	varchar	维权说明
    private String demo;//	varchar	订单处理结果
    private Integer aid;//	int	管理员id
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column
    private Date createtime;//	date	订单创建时间
    private House house;
    private User user;
    private OrdersDetails ordersDetails;

}
