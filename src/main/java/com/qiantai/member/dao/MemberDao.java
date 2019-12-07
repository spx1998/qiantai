package com.qiantai.member.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberDao {

    void signUp(String memID, String phoneNumber, String name, int sex);

    String login(String phoneNumber);
}
