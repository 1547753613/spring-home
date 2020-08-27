package com.aaa.springboothomestay.impl.service;

import com.aaa.springboothomestay.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    public List<Department> SelectDepartmentAll();
}
