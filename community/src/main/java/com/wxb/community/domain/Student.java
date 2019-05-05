package com.wxb.community.domain;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer sId;

    private String sPwd;

    private String sNickname;

    private String sIcon;

    private String sName;

    private String sStuid;

    private String sAge;

    private String sSex;

    private String sGrade;

    private String sPhone;

    private String sState;

    private String sQuest1;

    private String sQuest2;

    private String sQuest3;

    private static final long serialVersionUID = 1L;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsPwd() {
        return sPwd;
    }

    public void setsPwd(String sPwd) {
        this.sPwd = sPwd == null ? null : sPwd.trim();
    }

    public String getsNickname() {
        return sNickname;
    }

    public void setsNickname(String sNickname) {
        this.sNickname = sNickname == null ? null : sNickname.trim();
    }

    public String getsIcon() {
        return sIcon;
    }

    public void setsIcon(String sIcon) {
        this.sIcon = sIcon == null ? null : sIcon.trim();
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getsStuid() {
        return sStuid;
    }

    public void setsStuid(String sStuid) {
        this.sStuid = sStuid == null ? null : sStuid.trim();
    }

    public String getsAge() {
        return sAge;
    }

    public void setsAge(String sAge) {
        this.sAge = sAge == null ? null : sAge.trim();
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex == null ? null : sSex.trim();
    }

    public String getsGrade() {
        return sGrade;
    }

    public void setsGrade(String sGrade) {
        this.sGrade = sGrade == null ? null : sGrade.trim();
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone == null ? null : sPhone.trim();
    }

    public String getsState() {
        return sState;
    }

    public void setsState(String sState) {
        this.sState = sState == null ? null : sState.trim();
    }

    public String getsQuest1() {
        return sQuest1;
    }

    public void setsQuest1(String sQuest1) {
        this.sQuest1 = sQuest1 == null ? null : sQuest1.trim();
    }

    public String getsQuest2() {
        return sQuest2;
    }

    public void setsQuest2(String sQuest2) {
        this.sQuest2 = sQuest2 == null ? null : sQuest2.trim();
    }

    public String getsQuest3() {
        return sQuest3;
    }

    public void setsQuest3(String sQuest3) {
        this.sQuest3 = sQuest3 == null ? null : sQuest3.trim();
    }
}