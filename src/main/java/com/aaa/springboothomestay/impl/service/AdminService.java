package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.code.Result;
import com.aaa.springboothomestay.entity.Admins;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    /**
     * 登录
     * @param name 用户名
     * @param pwd   密码
     * @return
     */
    public Admins Login(String name,String pwd);


    /**
     *
     * @param name 根据name查询是否存在该员工
     * @return
     */
    public Admins FindAdminName(String name);


    /**
     *
     * @return 查询所有员工
     */
    public List<Admins>SelectAdminAll();


    /**
     *
     * @param pageNum 第几页
     * @param pageSize  每页几多少条数据
     * @return 分页查询员工
     */
    public PageInfo<Admins> PageAdmin(Integer pageNum,Integer pageSize);


    /**
     *
     * @param id 锁定的员工id
     * @return
     */
    public Integer LockAdmin(Integer id);

    /**
     *
     * @param id 解封员工的id
     * @return
     */
    public Integer EnLockAdmin(Integer id);

    /**
     *
     * @param admins 修改员工
     * @return
     */
    public Integer UpdateAdmin(Admins admins);

    /**
     *
     * @param admins 添加员工
     * @return
     */
    public Result Adddmin(Admins admins);
}
