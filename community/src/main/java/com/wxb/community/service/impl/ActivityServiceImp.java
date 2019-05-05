package com.wxb.community.service.impl;

import com.wxb.community.domain.Activity;
import com.wxb.community.mapper.ActivityMapper;
import com.wxb.community.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "activityService")
public class ActivityServiceImp implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    public void setActivityMapper(ActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }

    @Override
    public boolean insertSelective(Activity record) {
        int i=activityMapper.insertSelective(record);
        if (i==1){
            return true;
        }
        return false;
    }

    @Override
    public List<Activity> selectByPrimaryKey(int startIndex, int endIndex) {
        return activityMapper.selectByPrimaryKey(startIndex,endIndex);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Activity record) {
        if(activityMapper.updateByPrimaryKeySelective(record)==1){
            return true;
        }
        return false;
    }
}
