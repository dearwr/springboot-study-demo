package com.example.demo.entity.dining.store;

/**
 * 轻量和快速的支付场景下
 * 普通优惠和会员优惠对象
 */
public class DiningStoreCoupon {
    private long serverId;
    private String name = "";
    private String category = "";
    private String type;
    private String code;
    private double val;
    private double couponAmount;
    private int useVipPoints;//使用积分数
    private boolean isRepeated;
    private boolean isGiftCardCoupon;
    private double cost;
    private String remark = "";

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public double getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(double couponAmount) {
        this.couponAmount = couponAmount;
    }

    public int getUseVipPoints() {
        return useVipPoints;
    }

    public void setUseVipPoints(int useVipPoints) {
        this.useVipPoints = useVipPoints;
    }

    public boolean isRepeated() {
        return isRepeated;
    }

    public void setRepeated(boolean repeated) {
        isRepeated = repeated;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isGiftCardCoupon() {
        return isGiftCardCoupon;
    }

    public void setGiftCardCoupon(boolean giftCardCoupon) {
        isGiftCardCoupon = giftCardCoupon;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
