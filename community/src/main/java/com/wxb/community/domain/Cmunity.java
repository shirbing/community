package com.wxb.community.domain;

import java.io.Serializable;
import java.util.Date;

public class Cmunity implements Serializable {
    private Integer cId;

    private String cIcon;

    private String cName;

    private String cPrincipal;

    private String cType;

    private Date cTime;

    private String cDepartment;

    private String cIntroduction;

    private String cTotal;

    private String cPhone;

    private static final long serialVersionUID = 1L;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcIcon() {
        return cIcon;
    }

    public void setcIcon(String cIcon) {
        this.cIcon = cIcon == null ? null : cIcon.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcPrincipal() {
        return cPrincipal;
    }

    public void setcPrincipal(String cPrincipal) {
        this.cPrincipal = cPrincipal == null ? null : cPrincipal.trim();
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType == null ? null : cType.trim();
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public String getcDepartment() {
        return cDepartment;
    }

    public void setcDepartment(String cDepartment) {
        this.cDepartment = cDepartment == null ? null : cDepartment.trim();
    }

    public String getcIntroduction() {
        return cIntroduction;
    }

    public void setcIntroduction(String cIntroduction) {
        this.cIntroduction = cIntroduction == null ? null : cIntroduction.trim();
    }

    public String getcTotal() {
        return cTotal;
    }

    public void setcTotal(String cTotal) {
        this.cTotal = cTotal == null ? null : cTotal.trim();
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone == null ? null : cPhone.trim();
    }
}