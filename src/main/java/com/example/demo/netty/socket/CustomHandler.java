package com.example.demo.netty.socket;

import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;

/**
 * Created by wangrong 2020/3/30
 */
public class CustomHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        NettyServer.socketChannel = (SocketChannel) channelHandlerContext.channel();
        System.out.println(s);
    }
}
