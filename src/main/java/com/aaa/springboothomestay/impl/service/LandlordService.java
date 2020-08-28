package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.code.Result;
import com.aaa.springboothomestay.entity.Landlord;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface LandlordService {
    public int add(Landlord landlord);
    public int update(Landlord landlord);
    public List<Landlord> query();
    public Landlord querybyid(int id);

    public PageInfo<Landlord> PageLandlord(Integer pageNum,Integer pageSize,String realname);

    /**
     *
     * @param landlord 锁定房东
     * @return
     */
    public Result LockLandlord(Integer id);

    /**
     *
     * @param id 解锁房东
     * @return
     */
    public Result EnLockandlord(Integer id);
}
