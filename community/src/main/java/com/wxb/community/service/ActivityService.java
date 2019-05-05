package com.wxb.community.service;

import com.wxb.community.domain.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityService {
    boolean insertSelective(Activity record);
    List<Activity> selectByPrimaryKey(@Param("startIndex")int startIndex, @Param("endIndex")int endIndex);
    boolean updateByPrimaryKeySelective(Activity record);
}
