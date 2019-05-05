package com.wxb.community.domain;

import java.io.Serializable;

public class Departments implements Serializable {
    private Integer deId;

    private String deName;

    private static final long serialVersionUID = 1L;

    public Integer getDeId() {
        return deId;
    }

    public void setDeId(Integer deId) {
        this.deId = deId;
    }

    public String getDeName() {
        return deName;
    }

    public void setDeName(String deName) {
        this.deName = deName == null ? null : deName.trim();
    }
}