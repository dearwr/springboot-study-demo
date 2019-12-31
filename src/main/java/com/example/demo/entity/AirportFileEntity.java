package com.example.demo.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangrong 2019/12/31
 */
@Data
public class AirportFileEntity {

    /**
     * 商品编号
     */
    private String code;

    /**
     * 商品条码
     */
    private String sku;

    /**
     * 往来店铺编号
     */
    private String shopCode;

    /**
     * 合同号
     */
    private String licenseCode;

    /**
     * 商品名称
     */
    private String goodName;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 零售单价
     */
    private double goodPrice;

    /**
     * 需要解析excel的列名集合
     */
    public static Map<String, String> nameToParamMap;

    static {
        nameToParamMap = new HashMap<>();
        nameToParamMap.put("商品编号", "code");
        nameToParamMap.put("商品条码", "sku");
        nameToParamMap.put("往来店铺编号", "shopCode");
        nameToParamMap.put("合同号", "licenseCode");
        nameToParamMap.put("商品名称", "goodName");
        nameToParamMap.put("店铺名称", "shopName");
        nameToParamMap.put("零售单价", "goodPrice");
    }

}
