package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.code.Result;
import com.aaa.springboothomestay.code.ResultCode;
import com.aaa.springboothomestay.code.ResultUtil;
import com.aaa.springboothomestay.dao.LandlordDao;
import com.aaa.springboothomestay.entity.Admins;
import com.aaa.springboothomestay.entity.House;
import com.aaa.springboothomestay.entity.Landlord;
import com.aaa.springboothomestay.impl.service.HouseService;
import com.aaa.springboothomestay.impl.service.LandlordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LandlordImpl implements LandlordService {

    @Autowired
    HouseService houseService;

    @Resource
    LandlordDao landlordDao;
    @Override
    public int add(Landlord landlord) {
        return landlordDao.insert(landlord);
    }

    @Override
    public int update(Landlord landlord) {
        return landlordDao.updateByPrimaryKeySelective(landlord);
    }

    @Override
    public List<Landlord> query() {
        return landlordDao.selectAll();
    }

    @Override
    public Landlord querybyid(int id) {
        return landlordDao.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Landlord> PageLandlord(Integer pageNum, Integer pageSize, String realname) {
        List<Landlord> landlords;
        if (null==pageNum){
            pageNum=1;
        }
        if (null==pageSize){
            pageSize=5;
        }
        PageHelper.startPage(pageNum,pageSize);

        if (null!=realname){
            realname="%"+realname+"%";
            Example example=new Example(Landlord.class);
            Example.Criteria criteria=example.createCriteria();
            criteria.andLike("realname",realname);
            landlords = landlordDao.selectByExample(example);

           /* Landlord landlord=new Landlord();
            landlord.setRealname(realname);
            landlords = landlordDao.select(landlord);*/
        }else {
            landlords  = this.query();

        }

        for (Landlord landlord:landlords){
            Integer lid = landlord.getLid();
            List<House> houses = houseService.QueryHouseLid(lid);
            landlord.setHouses(houses);
        }

        PageInfo<Landlord> pageInfo= new PageInfo<Landlord>(landlords);
        return pageInfo;
    }

    /**
     *
     * @param锁定房东
     * @return
     */
    @Override
    public Result LockLandlord(Integer id) {

        Landlord landlord=new Landlord();
        landlord.setLid(id);
        landlord.setState(0);
        Integer i = landlordDao.updateByPrimaryKeySelective(landlord);
        if (i==1){
            return ResultUtil.success(ResultCode.SUCCESS,"禁用房东成功");
        }

        return ResultUtil.error(ResultCode.ERROR,"禁用房东失败");
    }

    /**
     *
     * @param id 解锁房东
     * @return
     */
    @Override
    public Result EnLockandlord(Integer id) {

        Landlord landlord=new Landlord();
        landlord.setLid(id);
        landlord.setState(1);
        Integer i = landlordDao.updateByPrimaryKeySelective(landlord);
        if (i==1){
            return ResultUtil.success(ResultCode.SUCCESS,"解封房东成功");
        }

        return ResultUtil.error(ResultCode.ERROR,"解封房东失败");
    }

    public Landlord byidquery(int id) {
        return  landlordDao.selectByPrimaryKey(id);
    }
}
