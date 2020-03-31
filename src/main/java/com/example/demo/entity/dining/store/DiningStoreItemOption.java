package com.example.demo.entity.dining.store;

/**
 * 轻量和快速的支付场景下
 * 规格和口味对象
 */
public class DiningStoreItemOption {
    private long serverId;
    private String name = "";
    private int count;
    private double originalPrice;
    private double totalOriginalPrice;
    private long optionGroupsId;
    @Deprecated
    private double price;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getTotalOriginalPrice() {
        return totalOriginalPrice;
    }

    public void setTotalOriginalPrice(double totalOriginalPrice) {
        this.totalOriginalPrice = totalOriginalPrice;
    }

    public long getOptionGroupsId() {
        return optionGroupsId;
    }

    public void setOptionGroupsId(long optionGroupsId) {
        this.optionGroupsId = optionGroupsId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
