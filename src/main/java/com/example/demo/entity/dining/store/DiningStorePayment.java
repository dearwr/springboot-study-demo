package com.example.demo.entity.dining.store;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * 轻量和快速的支付场景下
 * 订单支付方式对象
 */
public class DiningStorePayment {
    private String flow;
    private double amount;
    private String payType;
    private String authCode = "";//授权码，刷卡支付条形码或会员发起支付授权Key
    private String cardNo = "";//卡号，储值卡号、会员卡号
    private double received;//现金支付，收取金
    private double change;//现金支付，找零金额
    private double onCreditAmount;//挂帐金额
    private Double settleAmount;
    private JsonNode data;
    private String status;
    private Double balance;

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

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public double getReceived() {
        return received;
    }

    public void setReceived(double received) {
        this.received = received;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getOnCreditAmount() {
        return onCreditAmount;
    }

    public void setOnCreditAmount(double onCreditAmount) {
        this.onCreditAmount = onCreditAmount;
    }

    public Double getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(Double settleAmount) {
        this.settleAmount = settleAmount;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JsonNode getData() {
        return data;
    }

    public void setData(JsonNode data) {
        this.data = data;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
