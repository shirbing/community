package com.wxb.community.service;

import com.wxb.community.domain.Cmunity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmunityService {
    boolean updateByPrimaryKeySelective(Cmunity record);
    public List<Cmunity> selectByName(Cmunity cmunity);
    boolean insertSelective(Cmunity record);
    List<Cmunity> selectByPrimaryKey(@Param("startIndex")int startIndex, @Param("endIndex")int endIndex);
    boolean deleteByPrimaryKey(Cmunity record);
    List<Cmunity> list();
    List<Cmunity> seachCmunity(@Param("cmunity")Cmunity cmunity,@Param("startIndex")int startIndex, @Param("endIndex")int endIndex);
    boolean  deleteBydeName(Cmunity record);
    public List<Cmunity> selectByType(Cmunity cmunity);
}
