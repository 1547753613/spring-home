package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.HouseAddressDao;
import com.aaa.springboothomestay.entity.HouseAddress;
import com.aaa.springboothomestay.impl.service.HouseAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HouseAddressImpl implements HouseAddressService {
    @Resource
    HouseAddressDao houseAddressDao;
    @Override
    public int insert(HouseAddress houseAddress) {
        return houseAddressDao.insert(houseAddress);
    }

    @Override
    public int udpate(HouseAddress houseAddress) {
        return houseAddressDao.updateByPrimaryKeySelective(houseAddress);
    }

    @Override
    public int delete(HouseAddress houseAddress) {
        return houseAddressDao.delete(houseAddress);
    }

    @Override
    public List<HouseAddress> query() {
        return houseAddressDao.selectAll();
    }
}
