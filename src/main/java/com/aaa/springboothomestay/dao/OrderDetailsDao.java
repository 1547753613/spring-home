package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.OrdersDetails;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.Date;

@org.apache.ibatis.annotations.Mapper
public interface OrderDetailsDao extends Mapper<OrdersDetails> {
}
