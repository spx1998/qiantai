package com.qiantai.menu.service;


import com.qiantai.menu.Utils.OrderUtils;
import com.qiantai.menu.dao.DishDao;
import com.qiantai.menu.dao.MenuMemberDao;
import com.qiantai.menu.dao.OrderDao;
import com.qiantai.menu.dao.OrderDetailDao;
import com.qiantai.menu.domain.Dish;
import com.qiantai.menu.domain.DishForDetail;
import com.qiantai.menu.domain.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@EnableScheduling
public class MenuService {
    @Autowired
    OrderUtils orderUtils;
    @Autowired
    MenuMemberDao menuMemberDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderDetailDao orderDetailDao;
    @Autowired
    DishDao dishDao;
    @Transactional
    public void generateOrder(OrderInfo orderInfo){
        int price;
        String memID;

        price = orderUtils.getTotalPrice(orderInfo.getDishes(),orderInfo.getMemberPhone());
        String orderID =  orderUtils.generateOrderID(orderInfo.getTableID());
        List<DishForDetail> dishForDetails = orderUtils.getDishesFromOrderInfo(orderID,orderInfo.getDishes(),orderInfo.getMemberPhone());
        if(orderInfo.getMemberPhone().equals("")){
            memID=null;
        }else {
            memID = menuMemberDao.getMemIDByPhone(orderInfo.getMemberPhone());
        }
        orderDetailDao.addDetails(dishForDetails);
        orderDao.addOrder(orderID,orderInfo.getTableID(),memID,price);
    }

    @Transactional
    public List<Integer> checkQuantity(OrderInfo orderInfo) {
        List<Integer> list = new ArrayList<>();
        Dish[] dishes = orderInfo.getDishes();
        List<Dish> menu = dishDao.getMenu();
        for(Dish dish:menu){
            for(Dish d:dishes){
                if(dish.getDishID()==d.getDishID()&&dish.getStatus()==2) {
                    if (dish.getQuantity() + d.getNum() <= dish.getMaxQuantity()) {
                        dish.setQuantity(dish.getQuantity() + d.getNum());
                    }else {
                        list.add(dish.getDishID());
                    }
                }
            }
        }
        dishDao.setQuantity(menu);
        return list;
    }

    @Scheduled(cron = "0 0 5 * * ?")
    public void clearQuantity(){
        dishDao.clearQuantity();
    }
}
