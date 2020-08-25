package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.util.Authority;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限分配
 */
@Service
public interface AuthorityService {

    /**
     * 查询所有权限
     * @return
     */
    public List<Authority> QueryAuthority(Integer parentId);
}
