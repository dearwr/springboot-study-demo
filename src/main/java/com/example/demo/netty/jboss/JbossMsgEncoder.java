package com.example.demo.netty.jboss;

import com.example.demo.pack.MessageHeader;
import lombok.extern.slf4j.Slf4j;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/**
 * Created by wangrong 2020/4/2
 */
@Slf4j
public class JbossMsgEncoder extends OneToOneEncoder {

    @Override
    protected Object encode(ChannelHandlerContext ctx, Channel channel, Object object) throws Exception {
        if (!(object instanceof MessageHeader)) {
            log.info("not messageHeader");
        }
        MessageHeader resPack = (MessageHeader) object;
        log.info("sendMsg: " + resPack);
        byte[] msgData = resPack.getMsg().getBytes(StandardCharsets.UTF_8);
        int totalLength = 16 + msgData.length;
        ChannelBuffer buffer = ChannelBuffers.buffer(ByteOrder.LITTLE_ENDIAN, totalLength);
        buffer.writeLong(totalLength);
        buffer.writeLong(resPack.getCmd());
        buffer.writeBytes(msgData);
        return buffer;
    }
}
