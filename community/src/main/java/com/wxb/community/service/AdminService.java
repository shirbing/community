package com.wxb.community.service;

import com.wxb.community.domain.AdminEntity;

import java.util.List;

public interface AdminService {
    public AdminEntity toLogin(AdminEntity admin);
    public boolean nameIsExist(AdminEntity admin);
    public void rePwd(AdminEntity admin, String newPwd);
    public void saveAdmin(AdminEntity admin);
    public void updateAdPwd(AdminEntity adminEntity);
    public List<AdminEntity> listAdmin(int startIndex, int endIndex);
}
