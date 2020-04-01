package com.example.demo.netty.handler;

import com.example.demo.entity.dining.store.DiningStoreOrder;
import com.example.demo.netty.NettyServer;
import com.example.demo.netty.pack.HeaderPack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import static com.example.demo.netty.pack.CmdType.CREATE_CONNECT;
import static com.example.demo.netty.pack.CmdType.SYNC_NEW_ORDER;

/**
 * Created by wangrong 2020/3/31
 */
public class MessageHandler extends SimpleChannelHandler{

    private static final Logger logger = LogManager.getLogger(MessageHandler.class.getName());

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        logger.info("客户端接入");
        // todo
        NettyServer.clientMap.put(199L, ctx.getChannel());
        super.channelConnected(ctx, e);
    }

    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        logger.info("客户端断开");
        super.channelClosed(ctx, e);
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        if (e instanceof HeaderPack) {
            HeaderPack headerPack = (HeaderPack) e;
            int cmd = headerPack.getCmd();
            handleMsg(cmd, ctx, headerPack);
        }
        System.out.println("msg:" + e);
    }

    private void handleMsg(int cmd, ChannelHandlerContext ctx, HeaderPack headerPack) {
        switch (cmd) {
            case CREATE_CONNECT:
                logger.info("receive msg: " + headerPack.getMsg());
                break;
            default:
                return;
        }
        DiningStoreOrder order = new DiningStoreOrder();
        order.setHqId(199);
        order.setBranchId(392);
        HeaderPack respPack = new HeaderPack(SYNC_NEW_ORDER, order);
        ctx.getChannel().write(respPack);
//        ctx.(respPack);
    }

//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, HeaderPack headerPack) throws Exception {
//        int cmd = headerPack.getCmd();
//        handleMsg(cmd, ctx, headerPack);
//    }
//
//    /**
//     * 客户端接入
//     *
//     * @param ctx
//     * @throws Exception
//     */
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        logger.info("客户端接入");
//        // todo
//        NettyServer.clientMap.put(199L, ctx.channel());
//
//    }
//
//    /**
//     * 客户端断开
//     *
//     * @param ctx
//     * @throws Exception
//     */
//    @Override
//    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        logger.info("客户端断开");
//        // todo
//    }
//
//    /**
//     * 异常
//     */
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        // todo
//    }
}
