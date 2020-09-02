package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.House;

import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HouseService {
    public int insert(House house);
    public int update(House house);
    public int delete(House house);
    public List<House> query();
    public List<House> querybyid(House house);

    /**
     *
     * @param lid 房东id ,查询房东名下的房子
     * @return
     */
    public List<House> QueryHouseLid(Integer lid);

    /**
     *
     * @param pageNum
     * @param pageSize
     * @param landname 分页查询房屋
     * @return
     */
    public PageInfo<House> PageInfoHouse(Integer pageNum,Integer pageSize,String landname);

    /**
     *
     * @param hid 房屋id,查询房屋
     * @return
     */
    public House QueryHouseHid(Integer hid);
    public List<House> findAllHouse();
}
