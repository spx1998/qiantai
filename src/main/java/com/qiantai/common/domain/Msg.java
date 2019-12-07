package com.qiantai.common.domain;

import java.io.Serializable;

public class Msg implements Serializable {

    private static final long serialVersionUID = -1881736907951297984L;

    private String status;
    private String content;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
