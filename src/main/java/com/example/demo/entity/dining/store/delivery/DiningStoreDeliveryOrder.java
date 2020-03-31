package com.example.demo.entity.dining.store.delivery;


import com.example.demo.entity.dining.store.DiningStoreOrder;

/**
 * 外送订单
 */
public class DiningStoreDeliveryOrder extends DiningStoreOrder {
    private double deliveryFee;
    private long addressId;
    private String deliveryFlow = "";
    private String receiveStatus = "DEFAULT";
    private String cookStatus = "";
    private String deliveryStatus = "";
    private String receiveTime = "";
    private String cookTime = "";
    private String deliveryTime = "";
    //memory data
    private DeliveryOrder deliveryOrder;

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getDeliveryFlow() {
        return deliveryFlow;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public void setDeliveryFlow(String deliveryFlow) {
        this.deliveryFlow = deliveryFlow;
    }

    public String getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(String receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public String getCookStatus() {
        return cookStatus;
    }

    public void setCookStatus(String cookStatus) {
        this.cookStatus = cookStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public DeliveryOrder getDeliveryOrder() {
        return deliveryOrder;
    }

    public void setDeliveryOrder(DeliveryOrder deliveryOrder) {
        this.deliveryOrder = deliveryOrder;
    }
}
