package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.MenuRoleDao;
import com.aaa.springboothomestay.entity.MenuRole;
import com.aaa.springboothomestay.impl.service.MenuRoleService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Repository
public class MenuRoleImpl implements MenuRoleService {

    @Resource
    MenuRoleDao menuRoleDao;

    /**
     *
     * @param rid 角色id
     * @return
     */
    @Override
    public Set<MenuRole> SelectMenuRid(int rid)
    {
        MenuRole menuRole=new MenuRole();
        menuRole.setRid(rid);
        List<MenuRole> list = menuRoleDao.select(menuRole);
        Set<MenuRole> sets=new HashSet<>();
        sets.addAll(list);

        return sets;
    }

    /**
     * 删除角色下的权限
     * @param rid 角色id
     * @return
     */
    @Override
    public Integer DeleteMenuRole(int rid) {
        MenuRole menuRole=new MenuRole();
        menuRole.setRid(rid);

        return menuRoleDao.delete(menuRole);
    }

    @Override
    public Integer AddMenuRole(int[]ints,Integer rid) {
        List<MenuRole>menuRoles=new ArrayList<>();
        for(int i=0;i<ints.length;i++){
            MenuRole menuRole=new MenuRole();
            menuRole.setRid(rid);
            menuRole.setMid(ints[i]);
            menuRoles.add(menuRole);
        }
        return         menuRoleDao.insertList(menuRoles);
    }
}
