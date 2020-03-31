package com.example.demo.entity.dining.store.waimai;

import java.util.List;

/**
 * 口袋
 * Created by liuchang on 2017/9/26.
 */
public class DishGroup {

    private String name;
    private List<Dish> dishes;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
