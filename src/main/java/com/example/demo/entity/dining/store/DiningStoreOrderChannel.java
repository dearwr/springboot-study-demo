package com.example.demo.entity.dining.store;

public class DiningStoreOrderChannel {
    private long id;
    private String orderNo;
    private String flow;
    private String payType;
    private double paidAmount;
    private String methond = "";
    private String channel;
    private String channelStatus;
    private String channelNo = "";
    private String channelData = "";
    private String scene = "";
    private String createTime;
    private String successTime;
    private String originalFlow="";
    private String closeFlow;
    private String closeTime;
    private String closeData = "";
    private double received;//现金支付，收取金
    private double change;//现金支付，找零金额
    private String cardNo;
    private Double settleAmount;
    private Double balance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getMethond() {
        return methond;
    }

    public void setMethond(String methond) {
        this.methond = methond;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(String channelStatus) {
        this.channelStatus = channelStatus;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getChannelData() {
        return channelData;
    }

    public void setChannelData(String channelData) {
        this.channelData = channelData;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    public String getCloseFlow() {
        return closeFlow;
    }

    public void setCloseFlow(String closeFlow) {
        this.closeFlow = closeFlow;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getCloseData() {
        return closeData;
    }

    public void setCloseData(String closeData) {
        this.closeData = closeData;
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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getOriginalFlow() {
        return originalFlow;
    }

    public void setOriginalFlow(String originalFlow) {
        this.originalFlow = originalFlow;
    }

    public Double getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(Double settleAmount) {
        this.settleAmount = settleAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
