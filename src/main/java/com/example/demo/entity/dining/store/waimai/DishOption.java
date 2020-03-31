package com.example.demo.entity.dining.store.waimai;

/**
 * 菜品规格
 * Created by liuchang on 2017/9/26.
 */
public class DishOption {

    private String name = "";
    private double price = 0;
    private boolean spec = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSpec() {
        return spec;
    }

    public void setSpec(boolean spec) {
        this.spec = spec;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
