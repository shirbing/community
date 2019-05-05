package com.wxb.community.domain;

import java.io.Serializable;

public class Ctype implements Serializable {
    private Integer ctId;

    private String ctType;

    private static final long serialVersionUID = 1L;

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public void setCtType(String ctType) {
        this.ctType = ctType;
    }

    public String getCtType() {
        return ctType;
    }

    }