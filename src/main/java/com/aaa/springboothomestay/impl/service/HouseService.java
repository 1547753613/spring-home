package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.House;

import java.util.List;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HouseService {
    public int insert(House house);
    public int update(House house);
    public int delete(House house);
    public List<House> query();
    public House querybyid(House house);

    /**
     *
     * @param lid 房东id ,查询房东名下的房子
     * @return
     */
    public List<House> QueryHouseLid(Integer lid);
}
