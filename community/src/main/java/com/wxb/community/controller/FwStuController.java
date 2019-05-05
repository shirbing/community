package com.wxb.community.controller;

import com.alibaba.fastjson.JSON;
import com.wxb.community.domain.Student;
import com.wxb.community.service.StuService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@Controller
@RequestMapping("/fwStu")
public class FwStuController {
    @Autowired
    private StuService stuService;

    public void setStuService(StuService stuService) {
        this.stuService = stuService;
    }
    //注册学生
    @RequestMapping("/addStu")
    @ResponseBody
    public String addStu(Student student, @RequestParam("sIcon1") MultipartFile myfile, HttpServletRequest request) throws FileNotFoundException {
        String filename=myfile.getOriginalFilename();
        student.setsIcon("images/upload/"+filename);
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        File upload = new File(path.getAbsolutePath(),"static/forworad/images/upload/");
        File destFile=new File(upload+""+File.separatorChar+filename);
        try {
            InputStream in =myfile.getInputStream();
            FileUtils.copyInputStreamToFile(in,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        student.setsPwd(student.getsStuid().toString().substring(3));
        if (stuService.selectByName(student)==null){
            if (stuService.insertSelective(student)){
                return JSON.toJSONString("t");//注册成功
            }
            return JSON.toJSONString("f");//注册失败
        }
        return JSON.toJSONString("ff");//学号已经存在
    }
    //学生登录
    @RequestMapping("/stuLogin")
    @ResponseBody
    public String adminLogin(HttpServletRequest request, Student stu, String code){
        int i=1;
        if(code.equalsIgnoreCase((String)request.getSession().getAttribute("CODE_SESSION_KEY"))){
            if(stuService.selectByName(stu)!=null){
                Student student=stuService.tologin(stu).get(0);
                if(student!=null){
                        i=0; //登录成功
                        request.getSession().setAttribute("STU_SESSION_KEY",student);
                        return JSON.toJSONString(i);
                }
                i= 3;//密码错误
                return JSON.toJSONString(i);
            }
            i= 2;//用户名不存在
            return JSON.toJSONString(i);
        }
        return JSON.toJSONString(i);
    }
    //获取用户名
    @RequestMapping("/getStu")
    @ResponseBody
    public String getStu(HttpServletRequest request){
        Student adminEntity=(Student) request.getSession().getAttribute("STU_SESSION_KEY");
        return JSON.toJSONString(adminEntity);
    }
    //修改user密码
    @RequestMapping("/updateStuPwd")
    @ResponseBody
    public String updateAdmin(String sPwd,String newPwd, HttpServletRequest request){
        Student adminEntity=(Student) request.getSession().getAttribute("STU_SESSION_KEY");
        int i=0;
        if (adminEntity.getsPwd().equals(sPwd)){
            adminEntity.setsPwd(newPwd);
            if(stuService.updateByPrimaryKeySelective(adminEntity)){
                i=1;
                return JSON.toJSONString(i);  //修改成功
            }
            i=2;
            return JSON.toJSONString(i);  //修改失败
        }
        return JSON.toJSONString(i); //原密码输入错误
    }
    //update学生
    @RequestMapping("/updateStu")
    @ResponseBody
    public String updateStu(Student student, @RequestParam("sIcon1") MultipartFile myfile, HttpServletRequest request) throws FileNotFoundException {
        String filename=myfile.getOriginalFilename();
        student.setsIcon("images/upload/"+filename);
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        File upload = new File(path.getAbsolutePath(),"static/forworad/images/upload/");
        File destFile=new File(upload+""+File.separatorChar+filename);
        try {
            InputStream in =myfile.getInputStream();
            FileUtils.copyInputStreamToFile(in,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(stuService.updateinfo(student)){
            return JSON.toJSONString("t");  //修改成功
        }
        return JSON.toJSONString("f");  //修改失败
    }



}
