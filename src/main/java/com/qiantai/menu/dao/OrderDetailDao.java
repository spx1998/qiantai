package com.qiantai.menu.dao;

import com.qiantai.menu.domain.DishForDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderDetailDao {
    public void addDetails(List<DishForDetail> dishForDetails) ;
}
