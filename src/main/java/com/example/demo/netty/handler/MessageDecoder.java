package com.example.demo.netty.handler;

import com.example.demo.netty.pack.MessageHeader;
import com.example.demo.utils.MessageUtils;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.MessageToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MessageDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(io.netty.channel.ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        log.info("收到一条信息" + byteBuf.toString());
        MessageHeader msgHeader = MessageUtils.DecodeMsgHeader(byteBuf);
        list.add(msgHeader);
    }

}
