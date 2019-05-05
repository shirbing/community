package com.wxb.community.controller;

import com.alibaba.fastjson.JSON;
import com.wxb.community.domain.Cmunity;
import com.wxb.community.domain.Ctype;
import com.wxb.community.domain.Departments;
import com.wxb.community.service.CmunityService;
import com.wxb.community.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bgDepart")
public class BgDepartmentsController {
    @Autowired
    private DepartmentsService departmentsService;
    @Autowired
    private CmunityService cmunityService;

    public void setCmunityService(CmunityService cmunityService) {
        this.cmunityService = cmunityService;
    }


    public void setDepartmentsService(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }
    //获取院系
    @RequestMapping("/getDepart")
    @ResponseBody
    public String getDep(){
        List<Departments> list=departmentsService.getDepart();
        return JSON.toJSONString(list);
    }
    //删除院系
    @RequestMapping("/deleteDep")
    @ResponseBody
    public String deleteDep(Departments record){
        Cmunity cmunity=new Cmunity();
        cmunity.setcDepartment(record.getDeName());
        if (departmentsService.deleteByPrimaryKey(record)){
            cmunityService.deleteBydeName(cmunity);
            return JSON.toJSONString("t");
        }
        return JSON.toJSONString("f");
    }
    //修改院系
    @RequestMapping("/reDep")
    @ResponseBody
    public String reDep(Departments record){
        if (departmentsService.selectByName(record).size()==0) {
            if (departmentsService.updateByPrimaryKeySelective(record)) {
                return JSON.toJSONString("t");
            }
            return JSON.toJSONString("f");
        }
        return JSON.toJSONString("q");
    }
    //添加院系
    @RequestMapping("/addDep")
    @ResponseBody
    public String addDep(Departments record){
        Departments departments=new Departments();
        departments.setDeName(record.getDeName());
        if (departmentsService.selectByName(departments).size()==0){
            if (departmentsService.insertSelective(departments)){
                return JSON.toJSONString("t");
            }
        }else{
            return JSON.toJSONString("q");
        }

        return JSON.toJSONString("f");
    }

}
