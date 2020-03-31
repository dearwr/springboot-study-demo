package com.example.demo.entity.dining.store.online;


import com.example.demo.entity.dining.store.DiningStoreOrder;
import com.example.demo.entity.dining.store.delivery.DeliveryOrder;

//线上机制的订单
public class DiningStoreOnlineOrder extends DiningStoreOrder {
    private String receiveStatus = "DEFAULT";
    private String cookStatus = "";
    private String receiveTime = "";
    private String cookTime = "";
    //memory data
    private DeliveryOrder deliveryOrder;

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

    public DeliveryOrder getDeliveryOrder() {
        return deliveryOrder;
    }

    public void setDeliveryOrder(DeliveryOrder deliveryOrder) {
        this.deliveryOrder = deliveryOrder;
    }
}
