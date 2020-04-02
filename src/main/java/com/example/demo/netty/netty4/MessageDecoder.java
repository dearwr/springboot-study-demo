package com.example.demo.netty.netty4;

import com.example.demo.pack.MessageHeader;
import com.example.demo.utils.MessageHelper;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.MessageToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MessageDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(io.netty.channel.ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        MessageHeader msgHeader = MessageHelper.DecodeMsgHeader(byteBuf);
        list.add(msgHeader);
    }

}
