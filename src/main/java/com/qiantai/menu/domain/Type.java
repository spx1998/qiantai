package com.qiantai.menu.domain;

import java.io.Serializable;

public class Type implements Serializable {
    private static final long serialVersionUID = 5431926198211862595L;

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
