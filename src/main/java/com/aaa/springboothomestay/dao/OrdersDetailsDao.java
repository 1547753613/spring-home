package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.OrdersDetails;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public interface OrdersDetailsDao {
    List<OrdersDetails> findAllOrdersDetails();
    Integer updatebyoid(@Param("oid") Integer oid, @Param("money") Double money, @Param("dat") Date dat, @Param("check")String check);

}
