package com.example.demo.entity.dining.store;

/**
 * 轻量和快速的支付场景下
 * 订单关联的会员卡对象
 */
public class DiningStoreVipCard {
    private String number;//会员号
    private String nickName;//会员昵称

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
