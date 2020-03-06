package com.example.demo.test;

public abstract class Parent extends GrandFather{

    protected double money;

    Parent() {
        System.out.println("parent 构造方法");
    }

    protected void getMoney() {
        this.money = queryMoney();
    }

}
