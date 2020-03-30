package com.example.demo.netty.socket;

import com.example.demo.entity.ConnectData;
import io.netty.channel.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangrong 2020/3/30
 */
public class CustomHandler extends SimpleChannelInboundHandler<ConnectData> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ConnectData connectData) throws Exception {
        System.out.println(connectData);
        List socketQueue;
        if (NettyServer.clients.containsKey(connectData)) {
            synchronized (NettyServer.clients.get(connectData)) {

            }
            socketQueue = NettyServer.clients.get(connectData);
            socketQueue.add(channelHandlerContext.channel());
            NettyServer.clients.put(connectData.getBranchId(), socketQueue);
        } else {
            socketQueue = new ArrayList();
            socketQueue.add(channelHandlerContext.channel());
            NettyServer.clients.put(connectData.getBranchId(), socketQueue);
        }
    }
}
