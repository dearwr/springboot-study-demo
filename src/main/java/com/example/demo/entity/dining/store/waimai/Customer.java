package com.example.demo.entity.dining.store.waimai;

/**
 * Created by liuchang on 2017/9/26.
 */
public class Customer {
    /**
     * 名称
     */
    private String name;
    /**
     * 电话
     */
    private String phone;
    /**
     * 地址
     */
    private String address;
    /**
     * 人数
     */
    private int count;

    private Boolean collected;

    private double lng;
    private double lat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Boolean getCollected() {
        return collected;
    }

    public void setCollected(Boolean collected) {
        this.collected = collected;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
