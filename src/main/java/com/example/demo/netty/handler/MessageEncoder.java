package com.example.demo.netty.handler;

import com.example.demo.netty.pack.HeaderPack;
import com.example.demo.utils.JsonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

import java.nio.charset.StandardCharsets;

public class MessageEncoder extends OneToOneEncoder {

    private static final Logger logger = LogManager.getLogger(MessageEncoder.class.getName());

    @Override
    protected Object encode(ChannelHandlerContext ctx, Channel channel, Object o) throws Exception {
        HeaderPack headerPack = (HeaderPack) o;
        byte[] msgData = JsonUtils.toJson(headerPack.getMsg()).getBytes(StandardCharsets.UTF_8);
        ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
        buffer.writeInt(headerPack.getCmd());
        buffer.writeBytes(msgData);
        return buffer;
    }
}
