package com.wxb.community.mapper;

import com.wxb.community.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Student record);
    int updateinfo(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectByName(Student student);
    List<Student> tologin(Student student);
}