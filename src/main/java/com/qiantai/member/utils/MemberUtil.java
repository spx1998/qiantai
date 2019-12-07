package com.qiantai.member.utils;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@EnableScheduling
//TODO： temp的储存形式， menuUtil也有这个问题
public class MemberUtil {
    private int temp=0;
    public String generateMemID() {
        String memID ;
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        temp++;
        memID = date.format(formatter)+  String.format("%04d",temp) ;
        return memID;
    }
    @Scheduled(cron = "0 0 5 * * ?")
    private void setTemp(){
        temp=0;
    }
}
