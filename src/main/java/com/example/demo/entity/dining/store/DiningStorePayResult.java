package com.example.demo.entity.dining.store;

import java.util.List;

/**
 * 轻量和快速的支付场景下
 * 支付结果对象
 */
public class DiningStorePayResult {
    private String no;
    private String payType;
    private String payStatus;
    private String waitCallNo;
    private List<DiningStorePaymentResult> paymentResults;
    private DiningStoreVipCard vipCard;
    private DiningStoreCoupon vipPointCoupon;//会员积分优惠, 会员使用积分抵现优惠时不为空
    private String successTime;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getWaitCallNo() {
        return waitCallNo;
    }

    public void setWaitCallNo(String waitCallNo) {
        this.waitCallNo = waitCallNo;
    }

    public List<DiningStorePaymentResult> getPaymentResults() {
        return paymentResults;
    }

    public void setPaymentResults(List<DiningStorePaymentResult> paymentResults) {
        this.paymentResults = paymentResults;
    }

    public DiningStoreVipCard getVipCard() {
        return vipCard;
    }

    public void setVipCard(DiningStoreVipCard vipCard) {
        this.vipCard = vipCard;
    }

    public DiningStoreCoupon getVipPointCoupon() {
        return vipPointCoupon;
    }

    public void setVipPointCoupon(DiningStoreCoupon vipPointCoupon) {
        this.vipPointCoupon = vipPointCoupon;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }
}
