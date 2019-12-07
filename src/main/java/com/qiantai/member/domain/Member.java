package com.qiantai.member.domain;

import java.io.Serializable;

public class Member implements Serializable {
    private static final long serialVersionUID = 6291890357315299839L;
    private String memID;
    private String name;
    private String phoneNumber;
    private int sex;

    public String getMemID() {
        return memID;
    }

    public void setMemID(String memID) {
        this.memID = memID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
