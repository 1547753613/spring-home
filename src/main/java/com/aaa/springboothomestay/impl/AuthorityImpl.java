package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.entity.Menu;
import com.aaa.springboothomestay.impl.service.AuthorityService;
import com.aaa.springboothomestay.impl.service.MenuService;
import com.aaa.springboothomestay.util.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorityImpl implements AuthorityService {

    @Autowired
    MenuService menuService;

    @Override
    public List<Authority> QueryAuthority(Integer parentId) {
        List<Menu> menus = menuService.SelectMenuParentId(parentId);
        List<Authority> authorities=new ArrayList<>();
        for (Menu menu:menus){
            Authority authority=new Authority();
            authority.setId(menu.getMid());
            authority.setLabel(menu.getName());
            authority.setChildren(this.QueryAuthority(menu.getMid()));
            authorities.add(authority);
        }
        return authorities;
    }
}
