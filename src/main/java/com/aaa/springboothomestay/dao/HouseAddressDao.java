package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.HouseAddress;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface HouseAddressDao extends Mapper<HouseAddress> {
    @Select("select * from house_address ha " +
            " left join house h on ha.hid = h.id" +
            " where ha.city = #{city} ")
    List<HouseAddress> findByCity(String city);
}
