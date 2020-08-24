package com.aaa.springboothomestay.impl;

import com.aaa.springboothomestay.dao.DepartmentDao;
import com.aaa.springboothomestay.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentImpl implements DepartmentDao {
    @Autowired
    DepartmentDao departmentDao;
    @Override
    public List<Department> queryDepartment() {
        return departmentDao.queryDepartment();
    }

    @Override
    public int insertDepartment(Department department) {
        return departmentDao.insertDepartment(department);
    }

    @Override
    public int updateDepartment(Department department) {
        return departmentDao.updateDepartment(department);
    }

    @Override
    public int likequeryDepartment(String name) {
        return departmentDao.likequeryDepartment(name);
    }
}
