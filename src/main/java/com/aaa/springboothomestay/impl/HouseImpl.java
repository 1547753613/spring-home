package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.HouseDao;
import com.aaa.springboothomestay.entity.Admins;
import com.aaa.springboothomestay.entity.House;
import com.aaa.springboothomestay.impl.service.HouseService;
import com.aaa.springboothomestay.util.PageEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HouseImpl implements HouseService {
    @Resource
    HouseDao houseDao;


    @Override
    public int insert(House house) {
        return houseDao.insert(house);
    }

    @Override
    public int update(House house) {
        return houseDao.updateByPrimaryKeySelective(house);
    }

    @Override
    public int delete(House house) {
        return houseDao.delete(house);
    }

    @Override
    public List<House> query() {
        return houseDao.selectAll();
    }

    @Override
    public List<House> querybyid(House house) {
        return houseDao.ByIdfindAll(house.getId());
    }

    /**
     *
     * @param lid 房东id ,查询房东名下的房子
     * @return
     */
    @Override
    public List<House> QueryHouseLid(Integer lid) {
        House house=new House();
        house.setLid(lid);
        List<House> houses = houseDao.select(house);
        return houses;
    }

    @Override
    public List<House> findAllHouse() {
        return houseDao.findAllHouse();
    }

    @Override
    public PageInfo<House> PageInfoHouse(Integer pageNum, Integer pageSize, String landname) {
       if (null==landname){
           landname="";
       }
        PageEntity pageEntity=new PageEntity(pageNum,pageSize);

        PageHelper.startPage(pageEntity.getPageNum(),pageEntity.getPageSize());
        List<House> houseLandName = houseDao.findHouseLandName(landname);
        PageInfo<House> pageInfo= new PageInfo<House>(houseLandName);
        System.out.println(pageInfo);
        return pageInfo;
    }

    /**
     *
     * @param hid 房屋id,查询房屋
     * @return
     */
    @Override
    public House QueryHouseHid(Integer hid) {
        House house = houseDao.findHouseHid(hid);
        return house;
    }
}
