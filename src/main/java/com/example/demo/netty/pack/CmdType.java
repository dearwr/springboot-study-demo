package com.example.demo.netty.pack;

public class CmdType {

    public static final int CREATE_CONNECT = 102;   // 创建连接
    public static final int SYNC_NEW_ORDER = 320;   // 同步新订单
    public static final int SYNC_ORDER_STATE = 332; // 同步订单状态
    public static final int CONFIRM_ORDER = 331;    // 收到订单,订单确认

}
