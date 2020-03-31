package com.example.demo.entity.dining.store.waimai;

/**
 * 订单状态类型
 *
 * Created by liuchang on 2017/9/27.
 */
public enum StatusType {
    PENDING(1,"订单待处理"),
    PROCESSED(2,"已接单"),
    REFUNDING(3,"退单"),
    COMPLETE(4,"已完成"),
    INVALID(5,"无效订单"),
    REFUND(5,"无效订单"),

    COOKED_OR_WAIT_COURIER(6,"待配送和骑手待接单"),

    PREDELIVERY(10,"准备配送"),
    DISTRIBUTION_COURIER(11,"分配快递员"),
    DELIVERY(12,"开始配送"),
    DELIVERY_ERR(13,"配送异常"),
    DELIVERY_COMPLATE(14,"配送完成"),

    /*达达*/
    WAIT_COURIER(15,"骑手待接单"),
    TO_SHOP(16,"骑手到店"),
    RET_DELIVERYING(18,"妥投异常之物品返回中"),
    RET_DELIVERYED(18,"妥投异常之物品返回完成"),

    /*美团*/
    EXCEPTION(19,"配送异常"),

    REFUNDING_APPLY(20,"申请退单"),

    REFUNDING_AGREE(21,"同意退单"),
    REFUNDING_REJECT(22,"拒绝退单"),
    REFUNDING_ARBITRATE(23,"退单仲裁中"),
    REFUNDING_ARBITRATE_INVALID(24,"退单仲裁无效"),
    REFUNDING_ARBITRATE_VALID(25,"退单仲裁有效"),
    REFUNDING_CANCEL(26,"取消退单"),
    REFUNDING_CANCEL_COMPLAINT(27,"取消退款申诉"),
    REFUNDING_SUCCESS(28,"退单成功"),
    REFUNDING_FAIL(29,"退单失败"),

    COOKING(40,"制作中"),
    COOKED(41,"制作完成"),
    ;

    private final int code;
    private final String name;

    StatusType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
