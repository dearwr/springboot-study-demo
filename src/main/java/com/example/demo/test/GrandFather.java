package com.example.demo.test;

public abstract class GrandFather {

    public double queryMoney() {
        System.out.println("queryMoney:" + this.getClass().getSimpleName());
        return 100;
    }
}
