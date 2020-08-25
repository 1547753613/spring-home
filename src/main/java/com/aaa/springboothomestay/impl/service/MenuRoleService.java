package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.MenuRole;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MenuRoleService {

    /**
     *
     * @param rid 角色id
     * @return 根据角色id查询权限
     */
    public Set<MenuRole> SelectMenuRid(int rid);

    /**
     * 删除角色下的权限
     * @param rid 角色id
     * @return
     */
    public Integer DeleteMenuRole(int rid);


    /**
     *
     * @param menuRoles 权限
     * @return  添加权限
     */
    public Integer AddMenuRole(int[]ints,Integer rid);
}
