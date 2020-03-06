package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private long id;//主键ID
    private long hqId = 199;//品牌ID
    private long branchId;//门店ID
    private String bill;//流水号
    private double price = 1;//价格
    private String payType = "CASH";//支付方式
    private String platform = "IPAD_POS";//订单来源平台
    private String serviceType = "RESTAURANT";//服务类型, 堂食、等叫、外卖
    private String status = "complete";//订单状态
    private String waitCallNo;
    private Date createdAt;//创建时间
    private double delivery_fee = 0;

}
