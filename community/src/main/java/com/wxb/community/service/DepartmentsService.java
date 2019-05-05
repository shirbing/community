package com.wxb.community.service;

import com.wxb.community.domain.Departments;

import java.util.List;

public interface DepartmentsService {
    public List<Departments> getDepart();
    boolean deleteByPrimaryKey(Departments record);
    boolean updateByPrimaryKeySelective(Departments record);
    boolean insertSelective(Departments record);
    public List<Departments> selectByName(Departments departments);
}