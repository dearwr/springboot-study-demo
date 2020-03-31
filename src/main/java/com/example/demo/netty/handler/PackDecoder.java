package com.example.demo.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PackDecoder extends ByteToMessageDecoder {

    private static final Logger logger = LogManager.getLogger(PackDecoder.class.getName());

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List out) throws Exception {

    }


}
