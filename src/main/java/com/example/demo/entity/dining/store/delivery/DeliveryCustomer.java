package com.example.demo.entity.dining.store.delivery;

/**
 * 顾客配送信息
 */
public class DeliveryCustomer {
    private String name;
    private int sexy;
    private String phone;
    private String address;
    private boolean collected;
    private double lat;
    private double lng;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSexy() {
        return sexy;
    }

    public void setSexy(int sexy) {
        this.sexy = sexy;
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

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
