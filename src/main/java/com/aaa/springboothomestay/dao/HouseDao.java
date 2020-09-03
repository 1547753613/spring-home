package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.House;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;
@org.apache.ibatis.annotations.Mapper
public interface HouseDao extends Mapper<House> {
    List<House> ByIdfindAll(Integer id);
    List<House> findAllHouse();

    /**
     * cth 根据房东姓名查房屋,模糊查询
     * @param landName
     * @return
     */
    List<House> findHouseLandName(@Param("name") String landName);

    House findHouseHid(@Param("hid") Integer hid);

    List<House> QueryHouseCity(@Param("city") String city);

}
