package com.example.demo.netty.netty4;

import com.example.demo.entity.dining.store.DiningStoreOrder;
import com.example.demo.pack.MessageBody;
import com.example.demo.pack.MessageHeader;
import com.example.demo.utils.JsonUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import static com.example.demo.pack.CmdType.CREATE_CONNECT;

/**
 * Created by wangrong 2020/3/31
 */
@Slf4j
public class MessageHandler extends SimpleChannelInboundHandler<MessageHeader> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageHeader messageHeader) throws Exception {
        int cmd = messageHeader.getCmd();
        MessageBody msgBody = JsonUtils.fromJson(messageHeader.getMsg(), MessageBody.class);
        handleMsg(cmd, ctx, msgBody);
    }

    private void handleMsg(int cmd, ChannelHandlerContext ctx, MessageBody msgBody) {
        switch (cmd) {
            case CREATE_CONNECT:
                log.info("receive msg: " + msgBody);
                break;
            default:
                return;
        }
        DiningStoreOrder order = new DiningStoreOrder();
        order.setHqId(199);
        order.setBranchId(392);
        MessageBody messageBody = new MessageBody("123", order.toString());
        MessageHeader respPack = new MessageHeader(330, JsonUtils.toJson(messageBody));
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
        log.info("channelActive");
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
        log.info("channelInactive");

    }

    /**
     * 异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("exceptionCaught");
        cause.printStackTrace();
        // todo
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        log.info("channelRegistered");
        super.channelRegistered(ctx);
    }


    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.info("channelUnregistered");
        super.channelUnregistered(ctx);
    }
}
