package com.qiantai.menu.domain;

import java.io.Serializable;

public class OrderInfo implements Serializable {
    private static final long serialVersionUID = -4287310473356939286L;
    private int tableID;
    private String memberPhone;
    private Dish[] dishes;

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public Dish[] getDishes() {
        return dishes;
    }

    public void setDishes(Dish[] dishes) {
        this.dishes = dishes;
    }
}
