package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class TKdsOperationLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private int hqId = 199;

    private int branchId;

    private String device = "测试设备";

    private String grade;

    private String mac = "testMac";

    private String action = "ITEM_NOTICE";

    private String orderNo;

    private int productId = 1;

    private int count = 1;

    private String productName = "ceshi";

    private String productOptions;

    private int timeConsuming = 1;

    private String location = "RESTAURANT";

    private Timestamp optionTime;

    private Date uploadTime;

}
