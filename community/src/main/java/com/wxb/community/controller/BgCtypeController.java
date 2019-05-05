package com.wxb.community.controller;

import com.alibaba.fastjson.JSON;
import com.wxb.community.domain.Cmunity;
import com.wxb.community.domain.Ctype;
import com.wxb.community.service.CmunityService;
import com.wxb.community.service.CtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bgCtype")
public class BgCtypeController {
    @Autowired
    private CtypeService ctypeService;
    @Autowired
    private CmunityService cmunityService;
    public void setCmunityService(CmunityService cmunityService) {
        this.cmunityService = cmunityService;
    }

    public void setCtypeService(CtypeService ctypeService) {
        this.ctypeService = ctypeService;
    }
    //获取社团类型
    @RequestMapping("/getCtype")
    @ResponseBody
    public String getType(){
       List<Ctype> list=ctypeService.select();
        return JSON.toJSONString(list);
    }
    //修改社团类型
    @RequestMapping("/reCtype")
    @ResponseBody
    public String reType(Ctype ctype){
        if(ctypeService.selectByName(ctype).size()==0){
            if (ctypeService.updateByPrimaryKeySelective(ctype)){
                return JSON.toJSONString("t");
            }
            return JSON.toJSONString("f");
        }
        return JSON.toJSONString("q");
    }
    //删除类型
    @RequestMapping("/deCtype")
    @ResponseBody
    public String deType(Ctype ctype){
        Cmunity cmunity=new Cmunity();
        cmunity.setcType(ctype.getCtType());
        if(cmunityService.selectByType(cmunity).size()==0){
            if (ctypeService.deleteBytype(ctype)){
                return JSON.toJSONString("t");
            }
            return JSON.toJSONString("f");
        }
        return JSON.toJSONString("q");
    }
}
