package com.example.demo.netty.netty4;

import com.example.demo.pack.MessageHeader;
import com.example.demo.utils.MessageHelper;
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
        MessageHelper.encodeMsgHeader(messageHeader, ctx, list);
    }
}
