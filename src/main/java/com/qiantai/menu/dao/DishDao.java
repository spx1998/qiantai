package com.qiantai.menu.dao;


import com.qiantai.menu.domain.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DishDao {
    List<Dish> getMenu();

    Dish getDishByID(int dishID);

    void setQuantity(List<Dish> menu);

    void clearQuantity();
}
