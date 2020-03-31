package com.example.demo.entity.dining.store;

/**
 * 轻量和快速的支付场景下
 * 单品对象
 */
public class DiningStoreProduct {
    private long serverId;
    private String name;
    private double price;
    private long parentServerId;//父套餐单品Id
    private long displayGroupId;//单品显示组ID
    private boolean wDiscountable;//是否参与整单折扣

    public long getServerId() {
        return serverId;
    }

    public void setServerId(long serverId) {
        this.serverId = serverId;
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

    public long getParentServerId() {
        return parentServerId;
    }

    public void setParentServerId(long parentServerId) {
        this.parentServerId = parentServerId;
    }

    public long getDisplayGroupId() {
        return displayGroupId;
    }

    public void setDisplayGroupId(long displayGroupId) {
        this.displayGroupId = displayGroupId;
    }

    public boolean iswDiscountable() {
        return wDiscountable;
    }

    public void setwDiscountable(boolean wDiscountable) {
        this.wDiscountable = wDiscountable;
    }
}
