package com.wxb.community.mapper;

import com.wxb.community.domain.Ctype;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CtypeMapper {
    int deleteByPrimaryKey(Integer ctId);

    int insert(Ctype record);

    int insertSelective(Ctype record);

    Ctype selectByPrimaryKey(Integer ctId);

    int updateByPrimaryKeySelective(Ctype record);

    int updateByPrimaryKey(Ctype record);
    public List<Ctype> select();
    public List<Ctype> selectByName(Ctype ctype);
    int deleteBytype(Ctype record);
}