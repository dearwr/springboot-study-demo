package com.example.demo.netty.handler;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

public class PackDecoder extends FrameDecoder {
    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {
        if (buffer.capacity() < 16){
//            Log.d("PackDecoder", "receive buffer capacity less than 8");
            return null;
        }
        int length = readInt(buffer);
        if (buffer.capacity() < length){
//            Log.d("PackDecoder", "receive buffer capacity " + buffer.capacity() + " less than length " + length);
            buffer.resetReaderIndex();
            return null;
        }
//        int cmd = readInt(buffer);
//        byte[] data = new byte[length-16];
//        buffer.readBytes(data);
//        String msg = new String(data, "utf8");
//        Log.d("PackDecoder", "[RECV] msg: " + msg);
//        PackData packData = new PackData();
//        packData.setCmd(cmd);
//        packData.setMsg(msg);
//        return packData;
        return null;
    }

    private int readInt(ChannelBuffer buffer){
        byte b1 = buffer.readByte();
        byte b2 = buffer.readByte();
        byte b3 = buffer.readByte();
        byte b4 = buffer.readByte();
        byte b5 = buffer.readByte();
        byte b6 = buffer.readByte();
        byte b7 = buffer.readByte();
        byte b8 = buffer.readByte();
        return (b1&0xff) | ((b2&0xff)<<8) | ((b3&0xff)<< 16) | ((b4&0xff) << 24)
        | ((b1&0xff)<<32) | ((b2&0xff)<<40) | ((b3&0xff)<< 48) | ((b4&0xff) << 56);
    }
}
