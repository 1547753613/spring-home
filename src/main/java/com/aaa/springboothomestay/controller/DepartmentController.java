package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.Department;
import com.aaa.springboothomestay.entity.Role;
import com.aaa.springboothomestay.impl.DepartmentImpl;
import com.aaa.springboothomestay.impl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("Department")
public class DepartmentController {
    @Autowired
    DepartmentImpl departmentService;

    @Autowired
    RoleService roleService;

    @GetMapping("/queryrole")
    @ResponseBody
    public List<Role> selectRole(Integer did){
        return roleService.SelectRoleAll(did);
    }

    @RequestMapping("insert")
    @ResponseBody
    public int insert(Department department)
    {
        return departmentService.insertDepartment(department);
    }
    @RequestMapping("update")
    @ResponseBody
    public int update(Department department)
    {
        //System.out.println(department);
        return departmentService.updateDepartment(department);
    }
    @RequestMapping("query")
    @ResponseBody
    public List<Department> query()
    {
        return departmentService.queryDepartment();
    }
    @PostMapping("query")
    @ResponseBody
    public List<Department>querynotnull(){
        List<Department> departments = departmentService.queryDepartment();
        for (Department department:departments){
            List<Role> roles = roleService.SelectRoleAll(department.getDid());
            System.out.println(roles);
            if (roles.size()==0){
                departments.remove(department);
            }
        }
        return departments;
    }
    @RequestMapping("likequery")
    @ResponseBody
    public int likequery(String name)
    {
//        name = "财务";
        return departmentService.likequeryDepartment(name);
    }
}
