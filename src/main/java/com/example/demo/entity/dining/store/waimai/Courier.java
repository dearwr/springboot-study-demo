package com.example.demo.entity.dining.store.waimai;

/**
 * 快递员信息
 * Created by liuchang on 2017/9/26.
 */
public class Courier {
    /**
     * 姓名
     */
    private String name;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 公司
     */
    private String company;
    /**
     * 电话
     */
    private String phone;
    /**
     * 快递单号
     */
    private String no;

    private String deliveryTime;

    private double distance;//距离
    private double actualPrice;//实价
    private double originalPrice;//原价
    private double coupon;//优惠
    private double tips;//消费

    @Override
    public String toString() {
        return "Courier{" +
                "name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", no='" + no + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getCoupon() {
        return coupon;
    }

    public void setCoupon(double coupon) {
        this.coupon = coupon;
    }

    public double getTips() {
        return tips;
    }

    public void setTips(double tips) {
        this.tips = tips;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
