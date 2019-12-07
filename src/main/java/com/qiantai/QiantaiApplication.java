package com.qiantai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO: 售罄商品的问题 数据库修改 定时清空 前端反馈
//TODO： 图片url问题
//TODO： 餐桌使用中状态的处理 统计管理
@SpringBootApplication
public class QiantaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(QiantaiApplication.class, args);
    }

}
