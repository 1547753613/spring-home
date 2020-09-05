package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.Landlord;
import org.apache.ibatis.annotations.Select;

public interface Land_LandIordDao {
    @Select("select * from landlord where nickname = #{param1} and pass = #{param2}")
    Landlord findLandIord (String nickname, String pass);

}
