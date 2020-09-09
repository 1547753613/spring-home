package com.aaa.springboothomestay.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Data
@Table(name = "orders")
public class Order {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public static void main(String[] args) {
        Date date=new Date(new java.util.Date().getTime());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String parse = dateFormat.format(date);
        Date date1=new Date((date.getTime()+60000*15));
        String parse1=dateFormat.format(date1);
        System.out.println(parse);
        System.out.println(parse1);

    }

}
