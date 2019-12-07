package com.qiantai.menu.domain;

import java.io.Serializable;

public class DishForDetail implements Serializable {
    private static final long serialVersionUID = 2761282342837602450L;
    private String orderID;
    private int dishID;
    private int price;

    public DishForDetail(String orderID, int dishID, int price) {
        this.orderID=orderID;
        this.dishID=dishID;
        this.price =price;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getDishID() {
        return dishID;
    }

    public void setDishID(int dishID) {
        this.dishID = dishID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
