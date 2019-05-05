package com.wxb.community.mapper;

import com.wxb.community.domain.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ActivityMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Activity record);

    int insertSelective(Activity record);

    List<Activity> selectByPrimaryKey(@Param("startIndex")int startIndex, @Param("endIndex")int endIndex);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
}