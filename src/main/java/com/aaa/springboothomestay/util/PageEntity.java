package com.aaa.springboothomestay.util;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;


public class PageEntity {
    private Integer pageSize;
    private Integer pageNum;

    public PageEntity(){

    }

    public PageEntity(Integer pageNum,Integer pageSize){
            this.setPageNum(pageNum);
            this.setPageSize(pageSize);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (null==pageSize){
            pageSize=5;
        }
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (null==pageNum){
            pageNum=1;
        }
        this.pageNum = pageNum;
    }



}
