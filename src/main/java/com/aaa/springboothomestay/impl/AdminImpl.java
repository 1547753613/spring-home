package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.AdminDao;
import com.aaa.springboothomestay.entity.Admins;
import com.aaa.springboothomestay.entity.Menu;
import com.aaa.springboothomestay.entity.MenuRole;
import com.aaa.springboothomestay.impl.service.AdminService;
import com.aaa.springboothomestay.impl.service.MenuRoleService;
import com.aaa.springboothomestay.impl.service.MenuService;
import com.aaa.springboothomestay.impl.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class AdminImpl implements AdminService {

    @Resource
    AdminDao adminDao;
    @Autowired
    MenuRoleService menuRoleService;

    @Autowired
    MenuService menuService;

    @Autowired
    RoleService roleService;

    /**
     *
     * @param name 用户名
     * @param pwd   密码
     * @return
     */
    @Override
    public Admins Login(String name, String pwd) {
        return null;
    }

    /**
     *
     * @param name 根据name查询是否存在该员工
     * @return
     */
    @Override
    public Admins FindAdminName(String name) {
        Admins admins=new Admins();
        admins.setAname(name);
        List<Admins> list = adminDao.select(admins);
        if (list.size()==1){
            Admins admin = list.get(0);
            Set<MenuRole> menuRoles = menuRoleService.SelectMenuRid(admin.getRid());
            List<Integer> lists=menuRoles.stream().map(MenuRoles->MenuRoles.getMid()).collect(Collectors.toList());
            List<Menu> menus = menuService.SelectMenuId(lists);
            admin.setRole(roleService.SelectRoleId(admin.getRid()));
            admin.setMenus(menus);

            return admin;
        }
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Admins> SelectAdminAll() {
        List<Admins> admins = adminDao.selectAll();
        for (Admins admin:admins){
            admin.setRole(roleService.SelectRoleId(admin.getRid()));
        }
        return admins;
    }

    /**
     *
     * @param pageNum 第几页
     * @param pageSize  每页几多少条数据
     * @return
     */
    @Override
    public PageInfo<Admins> PageAdmin(Integer pageNum, Integer pageSize) {
        if (null==pageNum){
            pageNum=1;
        }
        if (null==pageSize){
            pageSize=3;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Admins> admins = this.SelectAdminAll();
        PageInfo<Admins> pageInfo= new PageInfo<Admins>(admins);

        return pageInfo;
    }

    /**
     *
     * @param id 锁定的员工id
     * @return
     */
    @Override
    public Integer LockAdmin(Integer id) {
        Admins admins=new Admins();
        admins.setIsenble(0);
        admins.setId(id);
        return adminDao.updateByPrimaryKeySelective(admins);
    }

    /**
     *
     * @param id 解封员工的id
     * @return
     */
    @Override
    public Integer EnLockAdmin(Integer id) {
        Admins admins=new Admins();
        admins.setIsenble(1);
        admins.setId(id);
        return adminDao.updateByPrimaryKeySelective(admins);
    }
}
