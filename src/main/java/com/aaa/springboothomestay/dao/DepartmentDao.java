package com.aaa.springboothomestay.dao;

import com.aaa.springboothomestay.entity.Department;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@Component
public interface DepartmentDao {
    //部门列表：查询所有部门
    public List<Department> queryDepartment();
    //添加部门：添加一个新的部门，部门名称不能重复(非空校验、存在性校验)
    public int insertDepartment(Department department);
    //修改部门：修改已存在的部门名称，并且不能有已存在的名称（非空校验、格式校验）
    public int updateDepartment(Department department);
    //部门名称模糊查询
    public int likequeryDepartment(String name);
}
