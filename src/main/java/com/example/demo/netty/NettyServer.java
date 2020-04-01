package com.example.demo.netty;

import com.example.demo.netty.handler.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
/**
 * Created by wangrong 2020/3/30
 */
public class NettyServer {

    private int port;
    private ServerBootstrap serverBootstrap;
    public static final Map<Long, Channel> clientMap = new ConcurrentHashMap<>();

    public NettyServer(int port) {
        this.port = port;
        log.info("----netty port : {} ----", port);
        // 服务类,用于启动netty
        serverBootstrap = new ServerBootstrap();
        // 新建两个线程池  boss线程监听端口，worker线程负责数据读写
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new MsgFrameDecoder());
                        pipeline.addLast(new MsgFrameEncoder());

                        pipeline.addLast(new MessageEncoder());
                        pipeline.addLast(new MessageDecoder());
                        pipeline.addLast(new MessageHandler());
                    }
                });
    }


    private void run() throws InterruptedException {
        ChannelFuture future = serverBootstrap.bind(port).sync();
        if (future.isSuccess()) {
            log.info("server start");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyServer(9999).run();
    }

}

