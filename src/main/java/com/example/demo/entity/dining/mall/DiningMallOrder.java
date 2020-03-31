package com.example.demo.entity.dining.mall;


import com.example.demo.entity.dining.store.DiningStoreOrder;
import com.example.demo.entity.dining.store.delivery.DeliveryOrder;

public class DiningMallOrder extends DiningStoreOrder {
    private double deliveryFee;
    private long addressId;
    private String deliveryFlow = "";
    private String deliveryStatus = "DEFAULT";
    private String deliveryTime = "";
    private String pickType = "DELIVERY";
    private String lockCode = "";
    private String lockStatus = "UNLOCK";
    //memory data
    private DeliveryOrder deliveryOrder;

    private String drawlotsToken;

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getDeliveryFlow() {
        return deliveryFlow;
    }

    public void setDeliveryFlow(String deliveryFlow) {
        this.deliveryFlow = deliveryFlow;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
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

    public String getPickType() {
        return pickType;
    }

    public void setPickType(String pickType) {
        this.pickType = pickType;
    }

    public String getLockCode() {
        return lockCode;
    }

    public void setLockCode(String lockCode) {
        this.lockCode = lockCode;
    }

    public String getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(String lockStatus) {
        this.lockStatus = lockStatus;
    }

    public String getDrawlotsToken() {
        return drawlotsToken;
    }

    public void setDrawlotsToken(String drawlotsToken) {
        this.drawlotsToken = drawlotsToken;
    }
}
