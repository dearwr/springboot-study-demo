package com.example.demo.entity.dining.store;

/**
 * 轻量和快速的支付场景下
 * 支付方式结果对象
 */
public class DiningStorePaymentResult {
    private double amount;
    private String payType;
    private String cardNo;
    private double afterBalance;
    private double afterPoint;
    private double vipPointCouponAmount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public double getAfterBalance() {
        return afterBalance;
    }

    public void setAfterBalance(double afterBalance) {
        this.afterBalance = afterBalance;
    }

    public double getAfterPoint() {
        return afterPoint;
    }

    public void setAfterPoint(double afterPoint) {
        this.afterPoint = afterPoint;
    }

    public double getVipPointCouponAmount() {
        return vipPointCouponAmount;
    }

    public void setVipPointCouponAmount(double vipPointCouponAmount) {
        this.vipPointCouponAmount = vipPointCouponAmount;
    }
}
