package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by wangrong 2019/12/31
 */
@Data
public class MallProductCode {

    private int id;
    private int hqId;
    private int branchId;
    private String mall;
    private String sku;     // 关联我们系统的商品sku
    private String code;    // 第三方系统商品编码code
    private String mallId;
    private Date createTime;

}
