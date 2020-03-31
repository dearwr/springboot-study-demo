package com.example.demo.netty.pack;

public class PackCmd {

    public static final int SEARCCH_PASSDISH = 102;  // 寻找后厨屏
    public static final int SYNC_KITCHENORDER = 320; // 接收新订单
    public static final int TESTKITCHENORDER = 330; //后厨屏测试连接

    public static final int ADDKITCHENORDER = 321;//后厨屏订单增加菜
    public static final int REFUNDKITCHENORDER = 322;//后厨屏订单增加菜
    public static final int CHANGEKITCHENORDERITEM = 323;//后厨屏改变点单状态
    public static final int BATCHCHANGEKITCHENORDERITEM = 324;//后厨屏
    public static final int TURNTABLE = 325;//转台
    public static final int QUERY_ADD_DISH_UUID = 326;//查询加菜UUID是否存在
    public static final int QUERY_REFUND_DISH_UUID = 327;//查询退菜UUID是否存在
    public static final int QUERY_EXPORT_DISH = 328;//后厨屏菜品划单状态通知
    public static final int QUERY_EXPORT_ORDER = 329;//后厨屏订单划单状态通知
    public static final int ORDER_COMPLETE_NOTICE = 331;//完成订单通知叫号屏
    public static final int CMD_SYNCKITCHENONLINEORDERSTATUS = 332;//同步手机点单订单状态 COOKED/COMPLETE

}
