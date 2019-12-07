package com.qiantai.menu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MenuMemberDao {
    String getMemIDByPhone(String memberPhone);
}
