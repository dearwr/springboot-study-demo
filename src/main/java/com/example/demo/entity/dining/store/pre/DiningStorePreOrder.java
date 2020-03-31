package com.example.demo.entity.dining.store.pre;

public class DiningStorePreOrder {
    private long id;
    private String no;
    private long hqId;
    private String vipNumber;
    private String data;
    private String createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public long getHqId() {
        return hqId;
    }

    public void setHqId(long hqId) {
        this.hqId = hqId;
    }

    public String getVipNumber() {
        return vipNumber;
    }

    public void setVipNumber(String vipNumber) {
        this.vipNumber = vipNumber;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
