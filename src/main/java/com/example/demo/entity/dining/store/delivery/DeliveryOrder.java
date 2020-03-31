package com.example.demo.entity.dining.store.delivery;

/**
 * 配送订单
 */
public class DeliveryOrder {
    private long id;
    private String flow;
    private String orderNo;
    //customer json data
    private String customerName = "";
    private String customerPhone = "";
    private int customerSex;
    private String customerAddress = "";
    private boolean customerCollected;
    private double lat;
    private double lng;
    //
    private String expressNumber = "";
    private String customerData;
    private String courierData;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public int getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(int customerSex) {
        this.customerSex = customerSex;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public boolean isCustomerCollected() {
        return customerCollected;
    }

    public void setCustomerCollected(boolean customerCollected) {
        this.customerCollected = customerCollected;
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

    public String getExpressNumber() {
        return expressNumber;
    }

    public void setExpressNumber(String expressNumber) {
        this.expressNumber = expressNumber;
    }

    public String getCustomerData() {
        return customerData;
    }

    public void setCustomerData(String customerData) {
        this.customerData = customerData;
    }

    public String getCourierData() {
        return courierData;
    }

    public void setCourierData(String courierData) {
        this.courierData = courierData;
    }
}
