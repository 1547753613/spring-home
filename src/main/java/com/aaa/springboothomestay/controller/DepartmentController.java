package com.aaa.springboothomestay.controller;

import com.aaa.springboothomestay.entity.Department;
import com.aaa.springboothomestay.impl.DepartmentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("Department")
public class DepartmentController {
    @Autowired
    DepartmentImpl departmentService;
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
    @RequestMapping("likequery")
    @ResponseBody
    public int likequery(String name)
    {
//        name = "财务";
        return departmentService.likequeryDepartment(name);
    }
}
