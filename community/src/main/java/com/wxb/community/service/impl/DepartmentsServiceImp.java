package com.wxb.community.service.impl;

import com.wxb.community.domain.Departments;
import com.wxb.community.mapper.DepartmentsMapper;
import com.wxb.community.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "departmentsService")
public class DepartmentsServiceImp implements DepartmentsService {
    @Autowired
    private DepartmentsMapper departmentsMapper;

    public void setDepartmentsMapper(DepartmentsMapper departmentsMapper) {
        this.departmentsMapper = departmentsMapper;
    }
    //获取院系单位
    @Override
    public List<Departments> getDepart() {
        return departmentsMapper.getDepart();
    }

    @Override
    public boolean deleteByPrimaryKey(Departments record) {
        if(departmentsMapper.deleteByPrimaryKey(record)==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(Departments record) {
        if (departmentsMapper.updateByPrimaryKeySelective(record)==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertSelective(Departments record) {
        if (departmentsMapper.insertSelective(record)==1){
            return true;
        }
        return false;
    }

    @Override
    public List<Departments> selectByName(Departments departments) {
        List<Departments> list=departmentsMapper.selectByName(departments);
        return list;
    }
}
