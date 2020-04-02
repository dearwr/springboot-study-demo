package com.example.demo.netty.jboss;

import com.example.demo.pack.CmdType;
import com.example.demo.pack.MessageHeader;
import com.example.demo.utils.JbossMsgHelper;
import lombok.extern.slf4j.Slf4j;
import org.jboss.netty.channel.*;

/**
 * Created by wangrong 2020/4/2
 */
@Slf4j
public class JbossMsgHandler extends SimpleChannelUpstreamHandler {

    /**
     * 处理消息
     * @param ctx
     * @param e
     */
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
        MessageHeader messageHeader = (MessageHeader) e.getMessage();
        log.info("received messageHeader :" + e.getMessage());
        int cmd = messageHeader.getCmd();

        if (cmd == CmdType.CREATE_CONNECT) {
            JbossMsgHelper.createConnect(messageHeader, ctx);
        } else if (cmd == CmdType.DISPATCHER_NEW_ORDER) {
            JbossMsgHelper.dispNewOrder(messageHeader, ctx);
        } else if (cmd == CmdType.DISPATCHER_REF_ORDER) {
            JbossMsgHelper.dispRefundOrder(messageHeader, ctx);
        } else if (cmd == CmdType.DISPATCHER_ORDER_STATE) {
            JbossMsgHelper.dispOrderState(messageHeader, ctx);
        } else if (cmd == CmdType.SYNC_ORDER_ACK) {
            JbossMsgHelper.syncOrderAck(messageHeader);
        } else if (cmd == CmdType.REF_CONNECT) {
            JbossMsgHelper.refConnect(messageHeader, ctx);
        } else {
            log.info("received cmd is valid: " + e.getMessage());
        JbossMsgHelper.syncNewOrder(messageHeader, ctx);
        }
    }


    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        log.info("channelConnected");
        super.channelConnected(ctx, e);
    }

    @Override
    public void channelBound(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        log.info("channelBound");
        super.channelBound(ctx, e);
    }

    @Override
    public void channelUnbound(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        log.info("channelUnbound");
        super.channelUnbound(ctx, e);
    }

    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        log.info("channelDisconnected");
        super.channelDisconnected(ctx, e);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        log.info("exceptionCaught");
        super.exceptionCaught(ctx, e);
    }
}
