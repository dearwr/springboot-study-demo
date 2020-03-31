package com.example.demo.entity.dining.store.waimai;

/**
 * 其他金额
 * Created by liuchang on 2017/9/26.
 */
public class Expenses {

    private String name;
    private double amount;
    private double platform;
    private double restaurant;
    private ExpType type;

    public Expenses() {
    }

    public Expenses(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPlatform() {
        return platform;
    }

    public void setPlatform(double platform) {
        this.platform = platform;
    }

    public double getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(double restaurant) {
        this.restaurant = restaurant;
    }

    public ExpType getType() {
        return type;
    }

    public void setType(ExpType type) {
        this.type = type;
    }
}
