package com.wxb.community.service;

import com.wxb.community.domain.Ctype;

import java.util.List;

public interface CtypeService {
    public List<Ctype> select();
    public List<Ctype> selectByName(Ctype ctype);
    boolean updateByPrimaryKeySelective(Ctype record);
    boolean deleteBytype(Ctype record);

}