package com.aaa.springboothomestay.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@Table(name = "department")
public class Department {
    @Id
    private int did;//	int	主键id
    @Column
    private String dname;//	varchar	部门名称

    private List<Role> roles;
}
