package com.example.demo.utils;

import com.example.demo.pack.MessageHeader;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class MessageHelper {

    public static MessageHeader DecodeMsgHeader(ByteBuf bytebuf) {
        return new MessageHeader(bytebuf.readInt(), bytebuf.toString(StandardCharsets.UTF_8));
    }

    public static void encodeMsgHeader(MessageHeader messageHeader, ChannelHandlerContext cxt, List<Object> list) {
        ByteBuf byteBuf = cxt.alloc().buffer();
        byteBuf.writeLong(messageHeader.getCmd());
        byteBuf.writeBytes(messageHeader.getMsg().getBytes(StandardCharsets.UTF_8));
        list.add(byteBuf);
    }

}
