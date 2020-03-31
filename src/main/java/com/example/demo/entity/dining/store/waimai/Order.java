package com.example.demo.entity.dining.store.waimai;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liuchang on 2017/9/26.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    private long id;
    /**
     * 每日流水号
     */
    private String sn;

    /**
     * 客户
     */
    private Customer customer;
    /**
     * 外卖小哥
     */
    private Courier courier;
    /**
     * 菜
     */
    private List<DishGroup> dishGroup;

    /**
     * 发票信息
     */
    private Invoice invoice;
    /**
     * 其他金额
     */
    private List<Expenses> other;

    private List<Status> status = new ArrayList<>();
    /**
     * 小计
     * 美团 total 用户实际支付的钱
     * 饿了么：totalPrice 订单总价，用户实际支付的金额，
     */
    private double subtotal;
    /**
     * 订单原价 商品 + 配送 + 餐盒费
     * 美团：订单原价
     * 饿了么：订单优惠前的价格，即商品总价加上配送费和餐盒费，
     */
    private double totalPrice;
    /**
     * 平台服务费
     */
    private double serviceCharge;
    /**
     * 店铺实收
     */
    private double income;

    /**
     * 活动优惠，平台承担部分
     */
    private double actPlatformPath;

    /**
     * 活动优惠，商户承担部分
     */
    private double actShopPath;
    /**
     * 订单创建时间
     */
    private Date createTime;

    /**
     * 支付方式，0.在线支付,1.货到付款
     */
    private int payType;

    /**
     * 配送方式
     */
    private String deliverType;

    /**
     * 退货说明
     */
    private Refund refund;

    /**
     * 催单次数
     */
    public Reminders reminders;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 系统订单号
     */
    private String sysOrderNo;
    /**
     * 备注
     */
    private String remark;
    /**
     * 数据来源，美团还是饿了么
     */
    private WaimaiType type;

    /**
     * 版本号
     */
    private int wmversion;

    /**
     * 下单会员号
     */
    private String memberNo="";

    private String payment = "";

    private String paymentName = "";

    /**
     * 未处理消息
     */
    private String unHandleMsg;

    /**
     * 预定时间
     */
    private String expectDeliveryTime;

    public String getExpectDeliveryTime() {
        return expectDeliveryTime;
    }

    public void setExpectDeliveryTime(String expectDeliveryTime) {
        this.expectDeliveryTime = expectDeliveryTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public List<DishGroup> getDishGroup() {
        return dishGroup;
    }

    public void setDishGroup(List<DishGroup> dishGroup) {
        this.dishGroup = dishGroup;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public List<Expenses> getOther() {
        return other;
    }

    public void setOther(List<Expenses> other) {
        this.other = other;
    }

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getSysOrderNo() {
        return sysOrderNo;
    }

    public void setSysOrderNo(String sysOrderNo) {
        this.sysOrderNo = sysOrderNo;
    }

    public WaimaiType getType() {
        return type;
    }

    public void setType(WaimaiType type) {
        this.type = type;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public int getWmversion() {
        return wmversion;
    }

    public void setWmversion(int wmversion) {
        this.wmversion = wmversion;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public String getPayment(){
        if(type==WaimaiType.ELEME||type==WaimaiType.MEITUAN){
            return type.toString();
        }
        return payment;
    }


    public Refund getRefund() {
        return refund;
    }

    public void setRefund(Refund refund) {
        this.refund = refund;
    }

    public Reminders getReminders() {
        return reminders;
    }

    public void setReminders(Reminders reminders) {
        this.reminders = reminders;
    }

    public double getActPlatformPath() {
        return actPlatformPath;
    }

    public void setActPlatformPath(double actPlatformPath) {
        this.actPlatformPath = actPlatformPath;
    }

    public double getActShopPath() {
        return actShopPath;
    }

    public void setActShopPath(double actShopPath) {
        this.actShopPath = actShopPath;
    }

    public String getDeliverType() {
        return deliverType;
    }

    public Order setDeliverType(String deliverType) {
        this.deliverType = deliverType;
        return this;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public List<PayInfo> getPayInfo(){
        PayInfo info = new PayInfo();
        info.setPayAmount(income);
        info.setPayment(type.toString());
        ArrayList infos =  new ArrayList<>();
        infos.add(info);
        return infos;
    }
    public String getUnHandleMsg() {
        return unHandleMsg;
    }

    public void setUnHandleMsg(String unHandleMsg) {
        this.unHandleMsg = unHandleMsg;
    }

    @JsonIgnore
    public boolean isProcessed(){
        return getLastStatus().getType() != StatusType.PENDING;
    }

    @JsonIgnore
    public Date getUpdate(){
        return getLastStatus().getDate();
    }

    public Status getLastStatus(){
        if(status == null || status.isEmpty()){
            return null;
        }
        return status.get(0);
    }


}
