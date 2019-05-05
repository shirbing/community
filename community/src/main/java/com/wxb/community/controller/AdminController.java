package com.wxb.community.controller;

import com.alibaba.fastjson.JSON;
import com.wxb.community.domain.AdminEntity;
import com.wxb.community.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
    //管理员登录
    @RequestMapping("/adminLogin")
    @ResponseBody
    public String adminLogin(HttpServletRequest request, AdminEntity admin, String code){
        int i=1;
        if(code.equalsIgnoreCase((String)request.getSession().getAttribute("CODE_SESSION_KEY"))){
            if(adminService.nameIsExist(admin)){
                AdminEntity adminEntity=adminService.toLogin(admin);
                if(adminEntity!=null){
                    if (adminEntity.getState().equals("是")){
                        i=0; //登录成功
                        request.getSession().setAttribute("ADMIN_SESSION_KEY",adminEntity);
                        return JSON.toJSONString(i);
                    }
                    i=4;//账户被禁用
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
    //获取管理员名
    @RequestMapping("/getAdmin")
    @ResponseBody
    public String getAdmin(HttpServletRequest request){
        AdminEntity adminEntity=(AdminEntity) request.getSession().getAttribute("ADMIN_SESSION_KEY");
        return JSON.toJSONString(adminEntity);
    }
    //修改管理员密码
    @RequestMapping("/updateAdPwd")
    @ResponseBody
    public String updateAdmin(String pwd,String newPwd, HttpServletRequest request){
        AdminEntity adminEntity=(AdminEntity) request.getSession().getAttribute("ADMIN_SESSION_KEY");
        int i=0;
        if (adminEntity.getPwd().equals(pwd)){
            adminEntity.setPwd(newPwd);
            adminService.updateAdPwd(adminEntity);
            AdminEntity adminEntity1=adminService.toLogin(adminEntity);
            if(adminEntity1!=null){
                i=1;
                return JSON.toJSONString(i);  //修改成功
            }
            i=2;
            return JSON.toJSONString(i);  //修改失败
        }
        return JSON.toJSONString(i); //原密码输入错误
    }
    //修改管理员信息
    @RequestMapping("/updateAdinfo")
    @ResponseBody
    public String updateAdminfo(AdminEntity adminEntity, HttpServletRequest request){
        AdminEntity adminEntity1=(AdminEntity) request.getSession().getAttribute("ADMIN_SESSION_KEY");
        adminEntity1.setGrade(adminEntity.getGrade());
        adminEntity1.setPosition(adminEntity.getPosition());
        adminEntity1.setIntroduction(adminEntity.getIntroduction());
        adminService.updateAdPwd(adminEntity1);
        int i=0;
        AdminEntity adminEntity2=adminService.toLogin(adminEntity1);
        if(adminEntity2.getPosition().equals(adminEntity.getPosition())&&adminEntity2.getGrade().equals(adminEntity.getGrade())){
            i=1;
            return JSON.toJSONString(i);  //修改成功
        }
        return JSON.toJSONString(i);  //修改失败
    }
    //添加管理员
    @RequestMapping("/addAdmin")
    @ResponseBody
    public String addAdmin(AdminEntity adminEntity, HttpServletRequest request) {
        int i=0;
        if(adminService.nameIsExist(adminEntity)){
            i=1;//学号已存在
            return JSON.toJSONString(i);
        }
        adminEntity.setPwd(adminEntity.getStuId().toString().substring(3));
        adminService.saveAdmin(adminEntity);
        if(adminService.toLogin(adminEntity).getStuId().equals(adminEntity.getStuId())){
            i=2;//注册成功
            return JSON.toJSONString(i);
        }
        return JSON.toJSONString(i);
    }
    //获取管理员列表
    @RequestMapping("/listAdmin")
    @ResponseBody
    public String listAdmin(int currentpage) {
        List<AdminEntity> adminEntityList=adminService.listAdmin((currentpage-1)*3,3);
        return JSON.toJSONString(adminEntityList);
    }
    //禁用管理员
    @RequestMapping("/deleteAdmin")
    @ResponseBody
    public String deleteAdmin(AdminEntity adminEntity) {
        System.out.println("===============");
        adminEntity.setState("否");
        adminService.updateAdPwd(adminEntity);
        return JSON.toJSONString("t");
    }
    //启用管理员
    @RequestMapping("/upAdmin")
    @ResponseBody
    public String upAdmin(AdminEntity adminEntity) {
        System.out.println("-----");
        adminEntity.setState("是");
        adminService.updateAdPwd(adminEntity);
        return JSON.toJSONString("t");
    }
    //重置密码
    @RequestMapping("/repwd")
    @ResponseBody
    public String repwd(AdminEntity adminEntity) {
        adminEntity.setPwd(adminEntity.getStuId().toString().substring(3));
        adminService.updateAdPwd(adminEntity);
        return JSON.toJSONString("t");
    }

}
