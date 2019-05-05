package com.wxb.community.mapper;

import com.wxb.community.domain.Departments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DepartmentsMapper {
    int insert(Departments record);
    int insertSelective(Departments record);
    public List<Departments> getDepart();
    int deleteByPrimaryKey(Departments record);
    int updateByPrimaryKeySelective(Departments record);
    public List<Departments> selectByName(Departments departments);
}