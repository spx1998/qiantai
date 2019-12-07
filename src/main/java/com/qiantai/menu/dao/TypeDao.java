package com.qiantai.menu.dao;

import com.qiantai.menu.domain.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TypeDao {
    List<Type> getTypes();
}
