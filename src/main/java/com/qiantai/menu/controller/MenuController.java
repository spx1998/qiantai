package com.qiantai.menu.controller;

import com.google.gson.Gson;
import com.qiantai.common.domain.Msg;
import com.qiantai.menu.Utils.OrderUtils;
import com.qiantai.menu.dao.*;
import com.qiantai.menu.domain.Dish;
import com.qiantai.menu.domain.OrderInfo;
import com.qiantai.menu.domain.Type;
import com.qiantai.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    TypeDao typeDao;
    @Autowired
    DishDao dishDao;
    @Autowired
    OrderUtils orderUtils;
    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderDetailDao orderDetailDao;
    @Autowired
    MenuMemberDao menuMemberDao;
    @Autowired
    MenuService menuService;
    private Gson g = new Gson();

    /**
     * 获取菜单
     */
    @GetMapping("/menu/list")
    public String getMenu() {
        Msg m = new Msg();
        try {
            List<Dish> dishes = dishDao.getMenu();
            m.setStatus("ok");
            m.setContent(g.toJson(dishes));

        } catch (Exception e) {
            e.printStackTrace();
            m.setStatus("error");
        }
        return g.toJson(m);
    }

    /**
     * 生成订单
     */
    @PostMapping("/menu/order")
    public String generateOrder(@RequestBody OrderInfo orderInfo) {
        Msg m = new Msg();
        List<Integer> sellOut;
        try {
            sellOut = menuService.checkQuantity(orderInfo);
            if (sellOut.size()>0) {
                m.setStatus("wrong");
                m.setContent(g.toJson(sellOut));
                return g.toJson(m);
            }
            menuService.generateOrder(orderInfo);
            m.setStatus("ok");
        } catch (Exception e) {
            e.printStackTrace();
            m.setStatus("error");
        }
        return g.toJson(m);
    }

    /**
     * 获取菜品分类
     */
    @GetMapping("/menu/type")
    public String getDishType() {
        Msg m = new Msg();
        try {
            List<Type> types = typeDao.getTypes();
            m.setStatus("ok");
            m.setContent(g.toJson(types));
        } catch (Exception e) {
            m.setStatus("error");
        }
        return g.toJson(m);
    }

    /**
     * 获取菜品详情
     */
    @GetMapping("/menu/{id}")
    public String getDetail(@PathVariable("id") int dishID) {
        Msg m = new Msg();
        try {
            m.setStatus("ok");
            Dish dish = dishDao.getDishByID(dishID);
            m.setContent(g.toJson(dish));
        } catch (Exception e) {
            e.printStackTrace();
            m.setStatus("error");
        }
        return g.toJson(m);
    }
}
