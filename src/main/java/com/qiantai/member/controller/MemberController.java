package com.qiantai.member.controller;

import com.google.gson.Gson;
import com.qiantai.common.domain.Msg;
import com.qiantai.member.dao.MemberDao;
import com.qiantai.member.utils.MemberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MemberController {
    private Gson g = new Gson();
    @Autowired
    MemberDao memberDao;
    @Autowired
    MemberUtil memberUtil;
    /**
     * 会员注册
     */
    @PostMapping("/member/signup")
    public String signUp(@RequestParam("phoneNumber")String phoneNumber,@RequestParam("name")String name,@RequestParam("sex")int sex){
        Msg m= new Msg();
        try {
            String memID = memberUtil.generateMemID();
            memberDao.signUp(memID,phoneNumber,name,sex);
            m.setStatus("ok");
            m.setContent(phoneNumber);
        }catch (DuplicateKeyException d){
            d.printStackTrace();
            m.setStatus("wrong");
            m.setContent("该手机号已注册");
        } catch (Exception e){
            e.printStackTrace();
            m.setStatus("error");
        }
        return g.toJson(m);
    }

    /**
     * 会员登录
     *
     */
    @PostMapping("/member/login")
    public String login(@RequestParam("phoneNumber")String  phoneNumber){
        Msg m =new Msg();
        try {
            String memID;
            if((memID=memberDao.login(phoneNumber))==null|| memID.equals("")){
                m.setStatus("wrong");
                m.setContent("无该会员信息");
            }else {
                m.setStatus("ok");
                m.setContent(memID);
            }
        }catch (Exception e){
            e.printStackTrace();
            m.setStatus("error");
        }
        return  g.toJson(m);
    }

}
