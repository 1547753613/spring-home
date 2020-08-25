package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.House;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface HouseDao extends Mapper<House> {



    List<House> findAllHouse();
}
