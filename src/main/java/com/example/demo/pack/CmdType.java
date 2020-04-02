package com.example.demo.pack;

public class CmdType {

    public static final int CREATE_CONNECT = 102;           // 创建新连接
    public static final int CONNECT_ACK = 109;              // 创建连接确认

    public static final int REF_CONNECT = 152;              // 重新连接
    public static final int REF_CONNECT_AKC = 159;          // 重接确认

    public static final int DISPATCHER_NEW_ORDER = 300;     // 转发新订单
    public static final int DISPATCHER_REF_ORDER = 310;     // 转发退单
    public static final int DISPATCHER_ORDER_STATE = 340;   // 转发订单状态
    public static final int DISPATCHER_ORDER_ACK = 331;     // 转发确认

    public static final int SYNC_NEW_ORDER = 601;           // 同步新订单
    public static final int SYNC_REFUND_ORDER = 602;        // 同步退单
    public static final int SYNC_ORDER_STATE = 603;         // 同步订单状态
    public static final int SYNC_ORDER_ACK = 604;           // 同步确认

}
