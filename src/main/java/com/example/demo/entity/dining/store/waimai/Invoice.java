package com.example.demo.entity.dining.store.waimai;

/**
 *发票信息
 *
 * Created by liuchang on 2017/9/26.
 */
public class Invoice {

    private String title;
    private String type;
    private String taxpayerId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(String taxpayerId) {
        this.taxpayerId = taxpayerId;
    }
}
