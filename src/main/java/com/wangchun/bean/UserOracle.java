package com.wangchun.bean;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/8/27.
 */
@Component
public class UserOracle {
    private String ID;
    private String NAME;
    private String ACCOUNT;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getACCOUNT() {
        return ACCOUNT;
    }

    public void setACCOUNT(String ACCOUNT) {
        this.ACCOUNT = ACCOUNT;
    }

    @Override
    public String toString() {
        return "UserOracle{" +
                "ID='" + ID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", ACCOUNT='" + ACCOUNT + '\'' +
                '}';
    }
}
