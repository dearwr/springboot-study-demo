package com.example.demo.netty.handler;

import com.example.demo.entity.ConnectMsg;
import com.example.demo.netty.pack.HeaderPack;
import com.example.demo.utils.JsonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

import java.nio.charset.StandardCharsets;

public class MessageDecoder extends FrameDecoder {

    private static final Logger logger = LogManager.getLogger(MessageDecoder.class.getName());

    @Override
    protected Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer) throws Exception {
        logger.info(channelBuffer.toString());
        logger.info("收到一条信息");
        int cmd = channelBuffer.readInt();
        logger.info(cmd);
        ConnectMsg msg = JsonUtils.fromJson(channelBuffer.toString(StandardCharsets.UTF_8), ConnectMsg.class);
        logger.info(msg);
        channelBuffer.readBytes(new byte[channelBuffer.readableBytes()]);
        return new HeaderPack(cmd, msg);
    }
}
