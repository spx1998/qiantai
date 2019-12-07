package com.qiantai.menu.Utils;

import com.qiantai.menu.domain.Dish;
import com.qiantai.menu.domain.DishForDetail;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@EnableScheduling
public class OrderUtils {
    private HashMap<Integer,Integer> dailyTableNumMap = new HashMap<>();

    public String generateOrderID(int tableID){
        String orderID ;
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        dailyTableNumMap.merge(tableID, 1, Integer::sum);
        orderID = date.format(formatter)+  String.format("%03d",tableID) + String.format("%02d",dailyTableNumMap.get(tableID));
        return orderID;
    }
    //TODO:设置更新时间
    @Scheduled(cron = "0 0 5 * * ?")
    private void clearMap(){
        this.dailyTableNumMap=new HashMap<>();
    }

    public int getTotalPrice(Dish[] dishes, String memberPhone){
        int price=0;
        if(memberPhone.equals("")){
            for(Dish d:dishes){
                price += d.getPrice()*d.getNum();
            }
        }else {
            for (Dish d:dishes){
                price += d.getvPrice()*d.getNum();
            }
        }
        return price;
    }

    public List<DishForDetail> getDishesFromOrderInfo(String orderID, Dish[] dishes, String memberPhone) {
        List<DishForDetail> dishForDetails = new ArrayList<>();
        if(memberPhone.equals("")){
            for(Dish dish:dishes){
                for(int i=0;i<dish.getNum();i++){
                    dishForDetails.add(new DishForDetail(orderID,dish.getDishID(),dish.getPrice()));
                }
            }
        }else {
            for(Dish dish:dishes){
                for(int i=0;i<dish.getNum();i++){
                    dishForDetails.add(new DishForDetail(orderID,dish.getDishID(),dish.getvPrice()));
                }
            }
        }
        return dishForDetails;
    }
}
