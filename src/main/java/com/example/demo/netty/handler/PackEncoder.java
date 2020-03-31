package com.example.demo.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PackEncoder extends MessageToByteEncoder {

    private static final Logger logger = LogManager.getLogger(PackEncoder.class.getName());

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {

    }
}
