package com.example.demo.entity.dining.store.waimai;

/**
 * Created by liuchang on 2017/12/15.
 */
public enum ExpType {
    ACT(1,"活动"),
    PKG(2,"餐盒"),
    DEL(3,"配送"),
    HB(4,"红包"),
;
    private final int typeId;
    private final String remark;

    ExpType(int typeId, String remark) {
        this.typeId = typeId;
        this.remark = remark;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getRemark() {
        return remark;
    }
}
