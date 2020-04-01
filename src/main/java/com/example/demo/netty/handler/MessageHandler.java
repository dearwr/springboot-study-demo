package com.example.demo.netty.handler;

import com.example.demo.entity.dining.store.DiningStoreOrder;
import com.example.demo.netty.NettyClient;
import com.example.demo.netty.NettyServer;
import com.example.demo.netty.pack.MessageBody;
import com.example.demo.netty.pack.MessageHeader;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import static com.example.demo.netty.pack.CmdType.CREATE_CONNECT;
import static com.example.demo.netty.pack.CmdType.SYNC_NEW_ORDER;

/**
 * Created by wangrong 2020/3/31
 */
@Slf4j
public class MessageHandler extends SimpleChannelInboundHandler<MessageHeader> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageHeader messageHeader) throws Exception {
        int cmd = messageHeader.getCmd();
        handleMsg(cmd, ctx, messageHeader);
    }

    private void handleMsg(int cmd, ChannelHandlerContext ctx, MessageHeader messageHeader) {
        switch (cmd) {
            case CREATE_CONNECT:
                log.info("receive msg: " + messageHeader);
                break;
            default:
                return;
        }
        DiningStoreOrder order = new DiningStoreOrder();
        order.setHqId(199);
        order.setBranchId(392);
        MessageBody messageBody = new MessageBody("123", order);
        messageHeader.setMsgBody(messageBody);
        MessageHeader respPack = new MessageHeader(SYNC_NEW_ORDER, messageBody);
        ctx.writeAndFlush(respPack);
    }

    /**
     * 客户端接入
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端接入");
        // todo
        NettyServer.clientMap.put(199L, ctx.channel());

    }

    /**
     * 客户端断开
     *
     * @param ctx
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.info("对方断开");
        new Thread(() -> {
            boolean lossConn = true;
            while (lossConn) {
                try {
                    lossConn = NettyClient.getConnect() == null;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    /**
     * 异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        // todo
    }

}
