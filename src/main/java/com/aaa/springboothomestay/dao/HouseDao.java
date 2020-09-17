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

    List<House> QueryHouseCondition(@Param("city")String city,@Param("days") Integer days);
    /**
     * 模糊插叙
     * @param days 天数
     * @param min
     * @param max
     * @param htid
     * @param reqid
     * @return
     */
    public List<House>FuzzySearchHouse(@Param("days") Integer days,@Param("min") Integer min,@Param("max")Integer max,@Param("htid")Integer htid,@Param("reqid")int[] reqid,@Param("size")Integer size);

}
