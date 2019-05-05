package com.wxb.community.mapper;

import com.wxb.community.domain.AdminEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface AdminEntityMapper {
    public AdminEntity toLogin(AdminEntity admin);
    public AdminEntity nameIsExist(AdminEntity admin);
    public void rePwd(AdminEntity admin, String newPwd);
    public void saveAdmin(AdminEntity admin);
    public void updateAdPwd(AdminEntity adminEntity);
    public List<AdminEntity> listAdmin(@Param("startIndex")int startIndex, @Param("endIndex")int endIndex);
}