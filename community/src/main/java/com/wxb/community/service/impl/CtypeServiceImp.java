package com.wxb.community.service.impl;

import com.wxb.community.domain.Ctype;
import com.wxb.community.mapper.CtypeMapper;
import com.wxb.community.service.CtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "ctypeService")
public class CtypeServiceImp implements CtypeService {
    @Autowired
    private CtypeMapper ctypeMapper;

    public void setCtypeMapper(CtypeMapper ctypeMapper) {
        this.ctypeMapper = ctypeMapper;
    }

    //获取社团类型
    @Override
    public List<Ctype> select() {
        return ctypeMapper.select();
    }

    @Override
    public List<Ctype> selectByName(Ctype ctype) {
        return ctypeMapper.selectByName(ctype);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Ctype record) {
        if (ctypeMapper.updateByPrimaryKeySelective(record)==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBytype(Ctype record) {
        if (ctypeMapper.deleteBytype(record)==1){
            return true;
        }
        return false;
    }
}
