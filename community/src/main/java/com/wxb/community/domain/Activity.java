package com.wxb.community.domain;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable {
    private Integer aId;

    private String cName;

    private String aTitle;

    private String aText;

    private Date aStime;

    private Date aEtime;

    private String aAdd;

    private String aPerson;

    private String aPhone;

    private String aState;

    private String aTotal;

    private static final long serialVersionUID = 1L;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle == null ? null : aTitle.trim();
    }

    public String getaText() {
        return aText;
    }

    public void setaText(String aText) {
        this.aText = aText == null ? null : aText.trim();
    }

    public Date getaStime() {
        return aStime;
    }

    public void setaStime(Date aStime) {
        this.aStime = aStime;
    }

    public Date getaEtime() {
        return aEtime;
    }

    public void setaEtime(Date aEtime) {
        this.aEtime = aEtime;
    }

    public String getaAdd() {
        return aAdd;
    }

    public void setaAdd(String aAdd) {
        this.aAdd = aAdd == null ? null : aAdd.trim();
    }

    public String getaPerson() {
        return aPerson;
    }

    public void setaPerson(String aPerson) {
        this.aPerson = aPerson == null ? null : aPerson.trim();
    }

    public String getaPhone() {
        return aPhone;
    }

    public void setaPhone(String aPhone) {
        this.aPhone = aPhone == null ? null : aPhone.trim();
    }

    public String getaState() {
        return aState;
    }

    public void setaState(String aState) {
        this.aState = aState == null ? null : aState.trim();
    }

    public String getaTotal() {
        return aTotal;
    }

    public void setaTotal(String aTotal) {
        this.aTotal = aTotal == null ? null : aTotal.trim();
    }
}