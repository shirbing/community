package com.wxb.community.service.impl;

import com.wxb.community.domain.Cmunity;
import com.wxb.community.mapper.CmunityMapper;
import com.wxb.community.service.CmunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "cmunityService")
public class CmunityServiceImp implements CmunityService {
    @Autowired
    private CmunityMapper cmunityMapper;

    public void setCmunityMapper(CmunityMapper cmunityMapper) {
        this.cmunityMapper = cmunityMapper;
    }

    @Override
    public boolean updateByPrimaryKeySelective(Cmunity record) {
        if(cmunityMapper.updateByPrimaryKeySelective(record)==1){
            return true;
        }
        return false;
    }

    @Override
    public List<Cmunity> selectByName(Cmunity cmunity) {
        List<Cmunity> list=cmunityMapper.selectByName(cmunity);

        return list;
    }

    @Override
    public boolean insertSelective(Cmunity record) {
        int i=cmunityMapper.insertSelective(record);
        if (i==1){
            return true;
        }
        return false;
    }

    @Override
    public List<Cmunity> selectByPrimaryKey(int startIndex, int endIndex) {
        return cmunityMapper.selectByPrimaryKey(startIndex,endIndex);
    }

    @Override
    public boolean deleteByPrimaryKey(Cmunity record) {
        int i=cmunityMapper.deleteByPrimaryKey(record);
        if (i==1){
            return true;
        }
        return false;
    }

    @Override
    public List<Cmunity> list() {
        return cmunityMapper.list();
    }

    @Override
    public List<Cmunity> seachCmunity(Cmunity cmunity, int startIndex, int endIndex) {
        return cmunityMapper.seachCmunity(cmunity,startIndex,endIndex);
    }

    @Override
    public boolean deleteBydeName(Cmunity record) {
        if (cmunityMapper.deleteBydeName(record)==1){
            return true;
        }
        return false;
    }

    @Override
    public List<Cmunity> selectByType(Cmunity cmunity) {
        return cmunityMapper.selectByType(cmunity);
    }


}
