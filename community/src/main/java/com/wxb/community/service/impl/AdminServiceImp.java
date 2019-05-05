package com.wxb.community.service.impl;


import com.wxb.community.domain.AdminEntity;
import com.wxb.community.mapper.AdminEntityMapper;
import com.wxb.community.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "adminService")
public class AdminServiceImp implements AdminService {
    @Autowired
    private AdminEntityMapper adminEntityMapper;

    public void setAdminDao(AdminEntityMapper adminDao) {
        this.adminEntityMapper = adminEntityMapper ;
    }
//验证登录
    @Override
    public AdminEntity toLogin(AdminEntity admin) {
        AdminEntity adminEntity=adminEntityMapper.toLogin(admin);
        return adminEntity;
    }
    //验证用户名是否存在
    @Override
    public boolean nameIsExist(AdminEntity admin) {
        if(adminEntityMapper.nameIsExist(admin)!=null){
            return true;
        }
        return false;
    }
//修改密码
    @Override
    public void rePwd(AdminEntity admin, String newPwd) {
        adminEntityMapper.rePwd(admin,newPwd);
    }
//新增管理员
    @Override
    public void saveAdmin(AdminEntity admin) {
        adminEntityMapper.saveAdmin(admin);
    }
/*更新管理员密码*/
    @Override
    public void updateAdPwd(AdminEntity adminEntity) {
        adminEntityMapper.updateAdPwd(adminEntity);
    }
/*获取管理员列表*/
    @Override
    public List<AdminEntity> listAdmin(int startIndex, int endIndex) {
        return adminEntityMapper.listAdmin(startIndex,endIndex);
    }
}
