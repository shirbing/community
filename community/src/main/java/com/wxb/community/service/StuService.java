package com.wxb.community.service;

import com.wxb.community.domain.Student;

import java.util.List;

public interface StuService {
    boolean insertSelective(Student record);
    List<Student> selectByName(Student student);
    List<Student> tologin(Student student);
    boolean updateByPrimaryKeySelective(Student record);
    boolean updateinfo(Student record);
}
