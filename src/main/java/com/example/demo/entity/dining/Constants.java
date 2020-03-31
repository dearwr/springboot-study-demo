package com.example.demo.entity.dining;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by jwing on 27/03/2017.
 */
public class Constants {

    public static final long CHAYAN_HQ = 2439L;
    public static final long CHAYAN_DEMO_HQ = 2107L;

    public enum ConfigType{
        cmbcgz, mp, pearl, alipay
    }
    //商场数据类型
    public enum MallDataType{
        daily, immediate
    }
    //品牌功能
    public enum HQFeature{
        RECHARGE, VIP_POINT
    }

    public enum Scene {
        PAY,PAY_STEP, PAY_REFUND, RECHARGE, BUY_COUPON, BUY_TICKET, BUY_PERIOD_CARD, BUY_GIFT_PACK, MIXED_RECHARGE
    }
    public enum PayMode {
        MICRO_PAY, NATIVE_PAY, WXA_PAY, JS_API_PAY, H5_PAY, APP_PAY, REFUND, NEW_REFUND,GENERAL_PAY,CLOSE
    }
    public enum TradeStatus {
        DEFAULT, SUCCESS, FAILURE, CLOSING, CANCELED,CLOSED,PAYING
    }
    //会员标签
    public enum MemberTag{
        @Deprecated
        REG,//注册
        BIRTHDAY, //生日劵
        MEMBER_BENEFIT, //权益卡
    }
    public enum OrderStatus {
        UNPAID, PENDING, PAYING, DELIVERED, COMPLETE, RATED, CANCELED, SKIPPAID, CLOSED, UNREFUNDED, REFUNDING, REFUNDED, REVERSE
    }

    public enum CheckStatus {
        NORMAL, ABNORMAL
    }

    public static Set<String> SUC_STATUS = Sets.newHashSet(OrderStatus.COMPLETE.name(), OrderStatus.SKIPPAID.name());
    public enum VipStatus{
        ACTIVE, FROZEN, DISABLED
    }
    public enum OrderServiceType {
        //堂食 打包 外带 自取 外卖 等叫
        RESTAURANT("堂食"),
        PACKAGE("打包"),
        TAKE_AWAY("外带"),
        SELF_SERVICE("自取"),
        DELIVERY("外卖"),
        WAITING("等叫"),
        WAITSEAT("预点"),
        MALL("商城");
        private String name;

        public String getName() {
            return name;
        }

        OrderServiceType(String name) {
            this.name = name;
        }

        public static OrderServiceType valOf(String name){
            for (OrderServiceType orderServiceType : values()) {
                if(orderServiceType.toString().equals(name)){
                    return orderServiceType;
                }
            }
            return RESTAURANT;
        }

    }
    public enum PayType {
        //现金支付 支付宝支付 微信支付 微信小程序支付 刷卡支付 混合支付 会员卡支付 储值卡支付
        CASH, ALIPAY, WECHAT, NICE_MP, UNI_PAY, COMBINED, VIPCARD, DEBITCARD
        //虚拟支付方式，用于特殊场景 未定义的支付方式 未知的支付方式
        , UNDEFINED, OTHER
        //用于会员卡流水，非订单业务，积分抵现支付
        , VIPPOINT
        //收起吧礼品卡支付
        , SHOUQIANBA
        //遗留支付方式，可废弃
        , BDPAY, COUPON, SIGNED, ONCREDIT
        //礼金卡支付
        , GIFTCARD,AMOUNT_COUPON,CONVERSION_COUPON
        //茶颜悦色会员卡
        , CYCARD
        //索迪斯
        , SODEXO
    }
    public enum TransactionType{
        //充值 充值退款
        RECHARGE, REFUND
        //消费余额 发票 转账
        , CONSUME, INVOICE, TRANSFER, TRANSFER_IN, TRANSFER_OUT
        // 买卡，退卡
        ,BUY_CARD ,REFUND_CARD
        // 增加余额 余额提现
        , TOPUP, WITHDRAW
        //迁移 赠送
        , MIGRATE, GIFT
        //兑换积分 使用积分 退还积分 增加积分 减少积分
        , CONVERT_POINT, POINT_USED, POINT_REFUND, UP_POINT, DOWN_POINT
        //兑换金额(赠额) 兑换金额(赠额)退还
        , CONVERT_AMOUNT, CONVERT_AMOUNT_REUFND
        //兑换成长值 退还成长值
        , CONVERT_GROWVAL, GROWVAL_REFUND
        //Virtual Mix Transaction
        , MIX, UNDEFINED
    }

    public enum GiftCardTransactionType {
        REFUND,CONSUME,CREATE,CANCEL
    }
    //通用结果
    public enum  GeneralResult{
        SUCCESS,FAIL
    }
    //通用状态
    public enum GeneralStatus{
        DEFAULT, VALID, INVALID
    }
    //门店状态
    public enum BranchStatus{
        //接单中、接单暂停、下单超限、未营业、未开启
        OPEN, BUSY, BUSY_PRODUCTIVITY, REST, CLOSE
    }
    public enum ProductStatus {
        ONSALE, SOLDOUT, DISABLED
    }
    public enum TemplateStatus{
        DEFAULT, NORMAL, DISABLE
    }
    //升级模式
    public enum UpgradeMode{
        MANUAL, AUTO
    }
    //升级类型
    public enum UpgradeType{
        CONSUME_AMOUNT, RECHARGE_AMOUNT,RECHARGE_ONCE_AMOUNT
    }
    //商城商品类型
    public enum MallProductType{
        //普通优惠劵  预订优惠劵  活动优惠劵(场次)  快速通道劵
        COUPON, RESERVATION_COUPON, ACTIVITY_COUPON, FASTPASS_COUPON
    }
    //商城商品购买类型
    public enum MallProductPurchaseType{
        //积分购买 金钱购买
        POINT, MONEY
    }
    //商城商品交易类型
    public enum MallProductTransType{
        //购买
        CONVERT, BUY
    }
    //商场会员交易类型
    public enum MallVipTransType{
        //积分兑换
        POINTS_CONVERT, MONEY_PURCHASE
    }
    //会员状态
    public enum MemberStatus{
        DEFAULT, NORMAL, FREEZE
    }
    //会员优惠劵类型
    public enum MemberCouponType{
        //百分比 金额 兑换 集点卡
        PERCENT, AMOUNT, CONVERSION, CONSUME_POINT
    }

    public enum CouponTransType {
        OWNED, OWNED_REVERSE, USED, USED_REVERSE, INVALID
    }
    public enum ConsumePointTransType{
        TRADE, CONVERT, TRADE_REVERSE, CONVERT_REVERSE
    }
    public enum GiftCouponType{
        AMOUNT,CONVERSION
    }
    public enum CouponType {
        PERCENT, AMOUNT, CONVERSION, VIPPOINT
    }
    public enum CouponCategory{
        NORMAL, VIP, VIP_DISCOUNT ,PERIOD_CARD,GIFT
    }
    public enum FormIdType{
        FORM_ID, PREPAY_ID
    }
    public enum WXTemplateNotifyType{
        //公众号模版消息、微信小程序模版消息
        MP_TEMPLATE, WEAPP_TEMPLATE
    }
    @Deprecated
    public enum MemberCouponCategory{
        //优惠劵分类 集点卡分类
        DISCOUNT, CONVERSION
    }
    //会员优惠劵状态
    public enum MemberCouponStatus {
        //默认 有效 已使用 过期 无效 转赠中, 已转赠
        DEFAULT, VALID, USED, EXPIRED, INVALID, GIVING, GIVED
    }
    public enum CouponUseRuleType{
        //无规则 订单金额满减
        NONE, ORDER_AMOUNT_OFF,CONVERSION
    }
    public static class CouponUseScene{
        // 1 堂食 2 手机点单 4 手机外送 8 商城 16 礼劵商城 32 活动预约 全部场景 63
        public static final int DINNING = 1;
        public static final int WXA_SCAN = 2;
        public static final int WXA_DELIVERY = 4;
        public static final int WXA_MALL = 8;
        public static final int WXA_COUPON = 16;
        public static final int WXA_ACTIVITY = 32;
        public static final int ALL = 63;
    }
    public  enum CouponChannel{
        //开卡 升级
        VIP_OPEN, VIP_LEVEL_GROW,
        //充值 集点兑换
        VIP_RECHARGE, VIP_CONSUMEPOINTS,
        //生日劵 礼品卡
        VIP_BIRTHDAY,  GIFT_CARD,
        //迁移会员数据
        MIGRATE_VIP,
        //商场兑换 商场购买 预订购买
        MALL_CONVERT, MALL_BUY, RESERVATION_BUY
        //活动购买 活动兑换
        , ACTIVITY_BUY, ACTIVITY_CONVERT,
        //手工派劵
        HAND_DISPATCH,
        //第三方场馆会员优惠
        PARNTER_MEMBER,
        //平级充值送券
        SAME_LEVEL
    }
    public enum WXTemplateNoticeScene{
        //手动发劵  优惠劵到期提醒
        SENDCOUPON, REMINDEXPIRES,ORDERCOMPLETE
    }
    public enum Platform {
        POS, IPAD_POS, IPAD, PC, APP, WECHAT, WXA_SCAN, WXA_DELIVERY, WXA_MALL, WXA_COUPON, WXA_ACTIVITY
    }

    public static class PayProviderName {
        public static final String CMBC_GZ = "CMBC-GZ";//民生
        @Deprecated
        public static final String PEARL = "PEARL";//派洛贝
        public static final String MP = "MP";//微信普通商户
        public static final String WX_MCH = "WX_MCH";//微信服务商
        public static final String ALIPAY_MCH = "ALIPAY_MCH";//支付宝系统商
        public static final String FUBEI = "FUBEI";//付呗普通商户
        public static final String SHOUQIANBA = "SHOUQIANBA";//收钱吧商户
        public static final String QWX_ALIPAY = "QWX_ALIPAY";//多多喵服务商
        public static final String QWX_WX = "QWX_WX";//多多喵服务商
    }
    public enum PayProviderScene{
        //线下订单 线上订单 外送 商城 充值
        OFFLINE, ONLINE, DELIVERY, MALL, RECHARGE
    }
    public enum SmsTemplet{
        TOKEN(1,"发送验证码"),
        VIP_RECHARGE(2,"会员充值提醒"),
        VIP_BALANCE(3,"会员余额消费"),
        ;
        private final int id;
        private final String desc;

        SmsTemplet(int id, String desc) {
            this.id = id;
            this.desc = desc;
        }

        public int getId() {
            return id;
        }

        public String getDesc() {
            return desc;
        }
    }
    public enum PartnerMemberStatus{
        VALID , INVALID , EXPIRED
    }

    public enum SubscribeMessageTemplateType {
        //下单成功通知,取餐提醒
        XDCG, QCTX
    }
}
