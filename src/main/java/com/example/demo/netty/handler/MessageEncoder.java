package com.example.demo.netty.handler;

import com.example.demo.netty.pack.MessageHeader;
import com.example.demo.utils.MessageUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Slf4j
public class MessageEncoder extends MessageToMessageEncoder<MessageHeader> {

    private static final Logger logger = LogManager.getLogger(MessageEncoder.class.getName());

    @Override
    protected void encode(ChannelHandlerContext ctx, MessageHeader messageHeader, List<Object> list) {
        ByteBuf buf = ctx.alloc().buffer();
        MessageUtils.encodeMsgHeader(messageHeader, buf);
        list.add(buf);
    }
}
