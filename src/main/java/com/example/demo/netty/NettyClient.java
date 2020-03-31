package com.example.demo.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by wangrong 2020/3/30
 */
public class NettyClient {
    private int port;
    private String host;
    public static SocketChannel socketChannel;

    public NettyClient(int port, String host) {
        this.port = port;
        this.host = host;
    }

    private void run() throws InterruptedException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.group(eventLoopGroup);
        bootstrap.remoteAddress(host, port);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new IdleStateHandler(20, 10, 0));
                socketChannel.pipeline().addLast(new ObjectEncoder());
                socketChannel.pipeline().addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
                socketChannel.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
                        System.out.println("服务端返回消息");
                        System.out.println(s);
                    }
                });
            }
        });
        ChannelFuture future = bootstrap.connect(host, port).sync();
        if (future.isSuccess()) {
            socketChannel = (SocketChannel) future.channel();
            System.out.println("-----client connect server success-----");
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        new NettyClient(9999, "localhost").run();

        while (true) {
            String msg = "helloworld";
            byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
            socketChannel.writeAndFlush(bytes);
            Thread.sleep(10000);
        }
    }
}
