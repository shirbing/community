package com.wxb.community.controller;

import com.alibaba.fastjson.JSON;
import com.wxb.community.domain.Activity;
import com.wxb.community.domain.Cmunity;
import com.wxb.community.service.ActivityService;
import com.wxb.community.service.CmunityService;
import com.wxb.community.service.impl.CmunityServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/bgActivity")
public class BgActivityController {
    @Autowired
    private ActivityService activityService;

    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }
    /*添加社团活动*/
    @RequestMapping("/saveActivity")
    @ResponseBody
    public String saveActivity(Activity activity)  {
        int i=0;
        if(activityService.insertSelective(activity)){
            i=1;
            return JSON.toJSONString(i);//添加成功
        }
        return JSON.toJSONString(i);//添加失败

    }
    /*列取社团活动*/
    @RequestMapping("/getActivity")
    @ResponseBody
    public String getActivity(int currentpage)  {
        List<Activity> list=activityService.selectByPrimaryKey((currentpage-1)*5,5);
        return JSON.toJSONString(list);

    }
    /*截止社团活动*/
    @RequestMapping("/stopAct")
    @ResponseBody
    public String stopActivity(Activity activity){
        activity.setaState("停止报名");

        if(activityService.updateByPrimaryKeySelective(activity)){

            return JSON.toJSONString("t");//修改成功
        }
        return JSON.toJSONString("f");//修改失败

    }
    /*修改社团活动*/
    @RequestMapping("/reAct")
    @ResponseBody
    public String reActivity(Activity activity){
        if(activityService.updateByPrimaryKeySelective(activity)){
            return JSON.toJSONString("t");//添加成功
        }
        return JSON.toJSONString("f");//添加失败

    }


}
