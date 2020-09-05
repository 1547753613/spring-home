package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.Land_LandIordDao;
import com.aaa.springboothomestay.entity.Landlord;
import com.aaa.springboothomestay.impl.service.Land_LandIordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LandIordImpl implements Land_LandIordService {

    @Resource
    private Land_LandIordDao land_landIordDao;

    @Override
    public Landlord findLandIord(String nickname, String pass) {
        return land_landIordDao.findLandIord(nickname,pass);
    }
}
