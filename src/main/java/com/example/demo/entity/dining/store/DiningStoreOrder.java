package com.example.demo.entity.dining.store;

import com.example.demo.entity.dining.Constants;
import com.example.demo.entity.dining.WXFormId;
import com.example.demo.entity.dining.WXTemplateMsg;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * 轻量和快速的支付场景下
 * 订单对象
 */
public class DiningStoreOrder {
    private long id = -1;//主键ID
    private long hqId;//品牌ID
    private long branchId;//门店ID
    private String vipNumber = "";//会员号
    private String no;//流单号
    private String parentNo = "";//父订单号
    private double originalPrice;//应收价格金额, 应收金额=实收金额+优惠金额+服务费金额+抹零金额
    private double price;//实收价格金额
    private double totalCouponAmount;//优惠金额(包含赠送金额)
    private double giftAmount;//赠送金额
    private double smallChangeAmount;//抹零金额
    private double additionalFee;//附加服务费金额
    private String expectDeliveryTime = "";//顾客指定的配送时间，预订单必选，顾客指定的送餐时间/自取时间
    private List<DiningStoreCoupon> genCoupons;//普通优惠组合
    private List<DiningStoreCoupon> vipCoupons;//会员优惠组合
    private String payType;//支付方式
    private List<DiningStorePayment> payments;//支付方式明细
    private String payStatus;//支付状态
    private String refundStatus;//退款状态
    private List<DiningStoreItem> items;//商品明细
    private int itemsCount;//商品总份数(含重量)
    private String location = "";//位置
    private String grade = "";//号牌
    private int numberOfPeople;//订单人数
    private String remark = "";//订单备注
    private String platform = "";//订单来源,IPad收银 IPAD_POS IPad自助 IPAD 微信小程序扫码 WXA_SCAN 微信小程序外送 WXA_DELIVERY
    private String scene = "";//支付场景, 先付费 PREPAY 后付费 POSTPAY
    private String createTime;//订单创建时间
    private String paySuccessTime = "";//订单成功时间
    private String refundTime = "";//订单退款时间
    private long cashierId;//收银员ID
    private long deviceId;//设备ID
    /*Impose Coupons*/
    private List<DiningStoreCoupon> imposeCoupons = new ArrayList<>();
    /*Pay Channel Info*/
    private String channelFlow = "";
    private double channelAmount;
    @Deprecated
    private DiningStoreOrderChannel channel;
    private List<DiningStoreOrderChannel> channels;
    /*Version Info*/
    private String version = "";//app order version
    private String appVersion = "";
    private String cloudVersion = "1.0.0";//cloud order version
    private String wxFormId = "";//表单提交场景下，为 submit 事件带上的 formId
    private String wxPrepayid = "";//支付场景下，为本次支付的 prepay_id
    private List<WXFormId> wxFormIdList;//wxFormId列表，存放多个wxFormId；表单提交场景下，为 submit 事件带上的 formId
    private String openId;
    /*JSON Data*/
    private String data;//订单JSON

    private String mrphone = "";

    private long onCreditId;
    private String payVipNumber;
    private String checkStatus = Constants.CheckStatus.NORMAL.name();

    private List<WXTemplateMsg> wxTemplateMsgs;

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

    public String getVipNumber() {
        return vipNumber;
    }

    public void setVipNumber(String vipNumber) {
        this.vipNumber = vipNumber;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getParentNo() {
        return parentNo;
    }

    public void setParentNo(String parentNo) {
        this.parentNo = parentNo;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalCouponAmount() {
        return totalCouponAmount;
    }

    public void setTotalCouponAmount(double totalCouponAmount) {
        this.totalCouponAmount = totalCouponAmount;
    }

    public double getGiftAmount() {
        return giftAmount;
    }

    public void setGiftAmount(double giftAmount) {
        this.giftAmount = giftAmount;
    }

    public double getSmallChangeAmount() {
        return smallChangeAmount;
    }

    public void setSmallChangeAmount(double smallChangeAmount) {
        this.smallChangeAmount = smallChangeAmount;
    }

    public double getAdditionalFee() {
        return additionalFee;
    }

    public void setAdditionalFee(double additionalFee) {
        this.additionalFee = additionalFee;
    }

    public String getExpectDeliveryTime() {
        return expectDeliveryTime;
    }

    public void setExpectDeliveryTime(String expectDeliveryTime) {
        this.expectDeliveryTime = expectDeliveryTime;
    }

    public List<DiningStoreCoupon> getGenCoupons() {
        return genCoupons;
    }

    public void setGenCoupons(List<DiningStoreCoupon> genCoupons) {
        this.genCoupons = genCoupons;
    }

    public List<DiningStoreCoupon> getVipCoupons() {
        return vipCoupons;
    }

    public void setVipCoupons(List<DiningStoreCoupon> vipCoupons) {
        this.vipCoupons = vipCoupons;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public List<DiningStorePayment> getPayments() {
        return payments;
    }

    public void setPayments(List<DiningStorePayment> payments) {
        this.payments = payments;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public List<DiningStoreItem> getItems() {
        return items;
    }

    public void setItems(List<DiningStoreItem> items) {
        this.items = items;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPaySuccessTime() {
        return paySuccessTime;
    }

    public void setPaySuccessTime(String paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    public String getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(String refundTime) {
        this.refundTime = refundTime;
    }

    public long getCashierId() {
        return cashierId;
    }

    public void setCashierId(long cashierId) {
        this.cashierId = cashierId;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public List<DiningStoreCoupon> getImposeCoupons() {
        return imposeCoupons;
    }

    public void setImposeCoupons(List<DiningStoreCoupon> imposeCoupons) {
        this.imposeCoupons = imposeCoupons;
    }

    public String getChannelFlow() {
        return channelFlow;
    }

    public void setChannelFlow(String channelFlow) {
        this.channelFlow = channelFlow;
    }

    public double getChannelAmount() {
        return channelAmount;
    }

    public void setChannelAmount(double channelAmount) {
        this.channelAmount = channelAmount;
    }

    public DiningStoreOrderChannel getChannel() {
        return channel;
    }

    public void setChannel(DiningStoreOrderChannel channel) {
        this.channel = channel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getCloudVersion() {
        return cloudVersion;
    }

    public void setCloudVersion(String cloudVersion) {
        this.cloudVersion = cloudVersion;
    }

    public String getWxFormId() {
        return wxFormId;
    }

    public void setWxFormId(String wxFormId) {
        this.wxFormId = wxFormId;
    }

    public String getWxPrepayid() {
        return wxPrepayid;
    }

    public void setWxPrepayid(String wxPrepayid) {
        this.wxPrepayid = wxPrepayid;
    }

    public List<WXFormId> getWxFormIdList() {
        return wxFormIdList;
    }

    public void setWxFormIdList(List<WXFormId> wxFormIdList) {
        this.wxFormIdList = wxFormIdList;
    }

    @JsonIgnore
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getOnCreditId() {
        return onCreditId;
    }

    public void setOnCreditId(long onCreditId) {
        this.onCreditId = onCreditId;
    }

    public String getMrphone() {
        return mrphone;
    }

    public void setMrphone(String mrphone) {
        this.mrphone = mrphone;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPayVipNumber() {
        return payVipNumber;
    }

    public void setPayVipNumber(String payVipNumber) {
        this.payVipNumber = payVipNumber;
    }

    @JsonIgnore
    public List<DiningStoreOrderChannel> getChannels() {
        return channels;
    }

    public void setChannels(List<DiningStoreOrderChannel> channels) {
        this.channels = channels;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public List<WXTemplateMsg> getWxTemplateMsgs() {
        return wxTemplateMsgs;
    }

    public void setWxTemplateMsgs(List<WXTemplateMsg> wxTemplateMsgs) {
        this.wxTemplateMsgs = wxTemplateMsgs;
    }

}
