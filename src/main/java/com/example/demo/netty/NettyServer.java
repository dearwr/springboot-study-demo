package com.example.demo.netty;

import com.example.demo.netty.handler.NormalHandler;
import com.example.demo.netty.handler.PackDecoder;
import com.example.demo.netty.handler.PackEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by wangrong 2020/3/30
 */
public class NettyServer {

    private static final Logger logger = LogManager.getLogger(NettyServer.class.getName());

    private int port;
    public static final Map<Long, ConcurrentSkipListSet<SocketChannel>> clientMap = new ConcurrentHashMap<>();

    public NettyServer(int port) {
        this.port = port;
        logger.info("----netty port : {} ----", port);
    }

    private void run() throws InterruptedException {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, worker);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.option(ChannelOption.SO_BACKLOG, 128);
        bootstrap.option(ChannelOption.TCP_NODELAY, true);
        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline p = socketChannel.pipeline();
//                p.addLast(new IdleStateHandler(120, 120, 120));
                p.addLast(new PackDecoder());
                p.addLast(new PackEncoder());
                p.addLast(new NormalHandler());
            }
        });
        ChannelFuture f = bootstrap.bind(port).sync();
        if (f.isSuccess()) {
            System.out.println("-----netty server start-----");
            logger.info("----netty server start----");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyServer(9999).run();
    }
}

