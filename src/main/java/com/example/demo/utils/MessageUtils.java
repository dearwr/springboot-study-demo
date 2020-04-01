package com.example.demo.utils;

import com.example.demo.netty.pack.MessageBody;
import com.example.demo.netty.pack.MessageHeader;
import io.netty.buffer.ByteBuf;

import java.nio.charset.StandardCharsets;

public class MessageUtils {

    public static MessageHeader DecodeMsgHeader(ByteBuf bytebuf) {
        return new MessageHeader(bytebuf.readInt(), JsonUtils.fromJson(bytebuf.toString(StandardCharsets.UTF_8), MessageBody.class));
    }

    public static void encodeMsgHeader(MessageHeader messageHeader, ByteBuf byteBuf) {
        byteBuf.writeInt(messageHeader.getCmd());
        byteBuf.writeBytes(JsonUtils.toJson(messageHeader.getMsgBody()).getBytes(StandardCharsets.UTF_8));
    }
}
