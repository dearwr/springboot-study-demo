package com.example.demo.entity.dining.store;

public class DiningStoreorderSubscribeMessage {
    private long id;
    private long hqId;
    private long branchId;
    private String no;
    private String type;
    private String wxTemplateId;
    private boolean valid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHqId() {
        return hqId;
    }

    public void setHqId(long hqId) {
        this.hqId = hqId;
    }

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWxTemplateId() {
        return wxTemplateId;
    }

    public void setWxTemplateId(String wxTemplateId) {
        this.wxTemplateId = wxTemplateId;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
