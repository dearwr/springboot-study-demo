package com.example.demo.entity.dining.store.waimai;

import java.util.List;

/**
 * Created by liuchang on 2017/11/27.
 */
public class Refund {
    private String reason;
    private double totalPrice;
    private List<Dish> dishes;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
