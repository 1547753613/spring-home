package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.HouseAddress;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface HouseAddressDao extends Mapper<HouseAddress> {
    List<HouseAddress> findByCity(String city);
}
