package com.wxb.community.service.impl;

import com.wxb.community.domain.Student;
import com.wxb.community.mapper.StudentMapper;
import com.wxb.community.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "stuService")
public class StuServiceImp implements StuService {
    @Autowired
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }
    //新增学生
    @Override
    public boolean insertSelective(Student record) {
        if(studentMapper.insertSelective(record)==1){
            return true;
        }
        return false;
    }

    @Override
    public List<Student> selectByName(Student student) {
        List<Student> list=studentMapper.selectByName(student);
        if(list.size()>0){
           return list;
        }
        return null;
    }

    @Override
    public List<Student> tologin(Student student) {
        List<Student> list=studentMapper.tologin(student);
        if(list.size()>0){
            return list;
        }
        return null;
    }

    @Override
    public boolean updateByPrimaryKeySelective(Student record) {
        if(studentMapper.updateByPrimaryKeySelective(record)==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateinfo(Student record) {
        if(studentMapper.updateinfo(record)==1){
            return true;
        }
        return false;
    }
}
