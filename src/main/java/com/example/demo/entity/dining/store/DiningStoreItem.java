package com.example.demo.entity.dining.store;

import com.example.demo.entity.dining.Hairdresser;

import java.util.List;

/**
 * 轻量和快速的支付场景下
 * 订单Item对象
 */
public class DiningStoreItem {
    private long categoryId;
    private DiningStoreProduct product;
    private List<DiningStoreItemOption> options;
    private String sku;
    private List<DiningStoreItemMaterial> materials;
    private double count;
    private double measure;
    private double productPrice;//单价
    private double totalOriginalPrice;//应收总价
    private double totalPrice;//实收总价
    private double totalCouponAmount;
    private double orderCouponAmount;
    private double orderSmallChangeAmount;
    private double itemCouponAmount;
    private String remark = "";//点单备注
    private String refundRemark = "";//退单备注
    private String location = "";//位置
    private List<DiningStoreCoupon> genCoupons;//普通优惠组合
    private List<DiningStoreCoupon> vipCoupons;//会员优惠组合
    private String giftCouponCode;
    private List<DiningStoreItem> items;//套餐内产品
    private List<Hairdresser> hairdresser;
    private long  setItemGroupsId;//套餐单品组ID
    @Deprecated
    private double originalPrice;//废弃的单价


    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public DiningStoreProduct getProduct() {
        return product;
    }

    public void setProduct(DiningStoreProduct product) {
        this.product = product;
    }

    public List<DiningStoreItemOption> getOptions() {
        return options;
    }

    public void setOptions(List<DiningStoreItemOption> options) {
        this.options = options;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public double getMeasure() {
        return measure;
    }

    public void setMeasure(double measure) {
        this.measure = measure;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getTotalOriginalPrice() {
        return totalOriginalPrice;
    }

    public void setTotalOriginalPrice(double totalOriginalPrice) {
        this.totalOriginalPrice = totalOriginalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalCouponAmount() {
        return totalCouponAmount;
    }

    public void setTotalCouponAmount(double totalCouponAmount) {
        this.totalCouponAmount = totalCouponAmount;
    }

    public double getOrderCouponAmount() {
        return orderCouponAmount;
    }

    public void setOrderCouponAmount(double orderCouponAmount) {
        this.orderCouponAmount = orderCouponAmount;
    }

    public double getOrderSmallChangeAmount() {
        return orderSmallChangeAmount;
    }

    public void setOrderSmallChangeAmount(double orderSmallChangeAmount) {
        this.orderSmallChangeAmount = orderSmallChangeAmount;
    }

    public double getItemCouponAmount() {
        return itemCouponAmount;
    }

    public void setItemCouponAmount(double itemCouponAmount) {
        this.itemCouponAmount = itemCouponAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRefundRemark() {
        return refundRemark;
    }

    public void setRefundRemark(String refundRemark) {
        this.refundRemark = refundRemark;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public List<DiningStoreItem> getItems() {
        return items;
    }

    public void setItems(List<DiningStoreItem> items) {
        this.items = items;
    }

    public long getSetItemGroupsId() {
        return setItemGroupsId;
    }

    public void setSetItemGroupsId(long setItemGroupsId) {
        this.setItemGroupsId = setItemGroupsId;
    }

    public String getGiftCouponCode() {
        return giftCouponCode;
    }

    public void setGiftCouponCode(String giftCouponCode) {
        this.giftCouponCode = giftCouponCode;
    }

    @Deprecated
    public double getOriginalPrice() {
        return originalPrice;
    }
    @Deprecated
    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public List<Hairdresser> getHairdresser() {
        return hairdresser;
    }

    public void setHairdresser(List<Hairdresser> hairdresser) {
        this.hairdresser = hairdresser;
    }
    public List<DiningStoreItemMaterial> getMaterials() {
        return materials;
    }
    public void setMaterials(List<DiningStoreItemMaterial> materials) {
        this.materials = materials;
    }
}
