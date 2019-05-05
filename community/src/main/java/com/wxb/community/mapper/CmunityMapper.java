package com.wxb.community.mapper;

import com.wxb.community.domain.Cmunity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CmunityMapper {
    int deleteByPrimaryKey(Cmunity record);
    int deleteBydeName(Cmunity record);
    int insert(Cmunity record);

    int insertSelective(Cmunity record);
    List<Cmunity> list();

    List<Cmunity> selectByPrimaryKey(@Param("startIndex")int startIndex, @Param("endIndex")int endIndex);

    int updateByPrimaryKeySelective(Cmunity record);

    int updateByPrimaryKey(Cmunity record);
    public List<Cmunity> selectByName(Cmunity cmunity);
    public List<Cmunity> selectByType(Cmunity cmunity);
    List<Cmunity> seachCmunity(@Param("cmunity")Cmunity cmunity,@Param("startIndex")int startIndex, @Param("endIndex")int endIndex);
}