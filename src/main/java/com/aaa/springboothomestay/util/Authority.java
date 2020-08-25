package com.aaa.springboothomestay.util;

import lombok.Data;

import java.util.List;

@Data
public class Authority {
    private Integer id;
    private String label;
    private List<Authority> children;
}
