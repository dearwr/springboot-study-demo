package com.example.demo.netty.handler;

import com.example.demo.netty.pack.HeaderPack;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

import java.nio.ByteOrder;

public class PackEncoder extends OneToOneEncoder {
    @Override
    protected Object encode(ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {
        if (!(msg instanceof HeaderPack)){
//            .d("PackEncoder", "msg is not packdata type: " + msg.getClass());
            return null;
        }
        HeaderPack resPack = (HeaderPack)msg;
//        Log.d("PackEncoder", "[SEND] msg: " + resPack.getMsg());
        byte[] msgData = resPack.getMsg().toString().getBytes();
        int totalLength = 16 + msgData.length;
        ChannelBuffer buffer = ChannelBuffers.buffer(ByteOrder.LITTLE_ENDIAN, totalLength);
        buffer.writeLong(totalLength);
        buffer.writeLong(resPack.getCmd());
        buffer.writeBytes(msgData);
        return buffer;
    }
}
