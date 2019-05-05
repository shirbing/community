package com.wxb.community.controller;

import com.alibaba.fastjson.JSON;
import com.wxb.community.domain.Cmunity;
import com.wxb.community.service.CmunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/bgCmunity")
public class BgCmunityController {
    @Autowired
    private CmunityService cmunityService;

    public void setCmunityService(CmunityService cmunityService) {
        this.cmunityService = cmunityService;
    }
    /*添加社团*/
    @RequestMapping("/saveCmunity")
    @ResponseBody
    public String saveCmunity(Cmunity cmunity, @RequestParam("cIcon1") MultipartFile myfile,  HttpServletRequest request) throws FileNotFoundException {
        String filename=myfile.getOriginalFilename();
        cmunity.setcIcon("images/upload/"+filename);
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        File upload = new File(path.getAbsolutePath(),"static/background/images/upload/");
        File destFile=new File(upload+""+File.separatorChar+filename);
        try {
            InputStream in =myfile.getInputStream();
            FileUtils.copyInputStreamToFile(in,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=0;
        List<Cmunity> list=cmunityService.selectByName(cmunity);
        if (list.size()==0){
            if(cmunityService.insertSelective(cmunity)){
                i=1;
                return JSON.toJSONString(i);//添加成功
            }
            i=2;
            return JSON.toJSONString(i);//添加失败
        }
        return JSON.toJSONString(i);//社团名已存在
    }
    //获取社团列表
    @RequestMapping("/getCmunity")
    @ResponseBody
    public String getCmunity(int currentpage){
        List<Cmunity> list=cmunityService.selectByPrimaryKey((currentpage-1)*5,5);
        return JSON.toJSONString(list);
    }
    //删除社团
    @RequestMapping("/deleteCmunity")
    @ResponseBody
    public String deleteCmunity(Cmunity cmunity){
        if(cmunityService.deleteByPrimaryKey(cmunity)){
            return JSON.toJSONString("t");
        }
        return JSON.toJSONString("f");
    }
    /*修改社团*/
    @RequestMapping("/updateCmunity")
    @ResponseBody
    public String updateCmunity(Cmunity cmunity, @RequestParam("cIcon1") MultipartFile myfile,  HttpServletRequest request) throws FileNotFoundException {
        String filename=myfile.getOriginalFilename();
        cmunity.setcIcon("images/upload/"+filename);
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        File upload = new File(path.getAbsolutePath(),"static/background/images/upload/");
        File destFile=new File(upload+""+File.separatorChar+filename);
        try {
            InputStream in =myfile.getInputStream();
            FileUtils.copyInputStreamToFile(in,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=0;
        List<Cmunity> list=cmunityService.selectByName(cmunity);
        if (list.size()==0||(list.size()==1&&(list.get(0).getcId()==cmunity.getcId()))){
            if(cmunityService.updateByPrimaryKeySelective(cmunity)){
                i=1;
                return JSON.toJSONString(i);//修改成功
            }
            i=2;
            return JSON.toJSONString(i);//修改失败
        }
        return JSON.toJSONString(i);//社团名已存在
    }
    //条件查询
    @RequestMapping("/searchCmunity")
    @ResponseBody
    public String searchCmunity(int currentpage,Cmunity cmunity){
        Cmunity cmunity1=new Cmunity();
        if(cmunity.getcDepartment()!=""){
            cmunity1.setcDepartment(cmunity.getcDepartment());
        }if (cmunity.getcType()!=""){
            cmunity1.setcType(cmunity.getcType());
        }
        List<Cmunity> list=cmunityService.seachCmunity(cmunity1,(currentpage-1)*5,5);
        return JSON.toJSONString(list);
    }
    //列取不分页
    @RequestMapping("/listCmunity")
    @ResponseBody
    public String listCmunity(){
        List<Cmunity> list=cmunityService.list();
        return JSON.toJSONString(list);
    }


}
