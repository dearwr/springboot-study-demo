package com.example.demo.entity.dining.store.waimai;

import java.util.List;

/**
 * 菜品
 * Created by liuchang on 2017/9/26.
 */
public class Dish {
    private String name  = "";//菜名

    private double price = 0;//价格

    private double count = 1;// 菜品数量

    private List<DishOption> options;

    private List<Dish> childDishes;

    public List<Dish> getChildDishes() {
        return childDishes;
    }

    public void setChildDishes(List<Dish> childDishes) {
        this.childDishes = childDishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public List<DishOption> getOptions() {
        return options;
    }

    public void setOptions(List<DishOption> options) {
        this.options = options;
    }
}
