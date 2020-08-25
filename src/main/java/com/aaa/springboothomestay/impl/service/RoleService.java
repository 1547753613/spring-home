package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    /**
     *
     * @param rid 角色id
     * @return  根据id查角色
     */
    public Role SelectRoleId(Integer rid);

    /**
     *
      * @return 根据部门查询所有职位
     */
    public List<Role> SelectRoleAll(Integer did);
}
