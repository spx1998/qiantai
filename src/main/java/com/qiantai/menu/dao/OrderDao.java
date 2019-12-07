package com.qiantai.menu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderDao {
    void addOrder(String orderID, int tableID, String memID, int price);
}
