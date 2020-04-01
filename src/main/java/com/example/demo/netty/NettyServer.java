package com.example.demo.netty;

import com.example.demo.netty.handler.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangrong 2020/3/30
 */
public class NettyServer {

    private static final Logger logger = LogManager.getLogger(NettyServer.class.getName());

    private int port;
    public static final Map<Long, Channel> clientMap = new ConcurrentHashMap<Long, org.jboss.netty.channel.Channel>();

    public NettyServer(int port) {
        this.port = port;
        logger.info("----netty port : {} ----", port);
    }



    private void run() throws InterruptedException {
        // 服务类,用于启动netty 在netty5中同样使用这个类来启动
        ServerBootstrap bootstrap = new ServerBootstrap();
        // 新建两个线程池  boss线程监听端口，worker线程负责数据读写
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();
        // 设置niosocket工厂  类似NIO程序新建ServerSocketChannel和SocketChannel
        bootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));

        // 设置管道的工厂
        bootstrap.setPipelineFactory(() -> {
            ChannelPipeline pipeline = Channels.pipeline();
            pipeline.addLast("msgFrame1",new MsgFrameDecoder());
            pipeline.addLast("msgFrame0",new MsgFrameEncoder());

            pipeline.addLast("msgFrame2",new MessageEncoder());
            pipeline.addLast("msgFrame3",new MessageDecoder());
            pipeline.addLast("msgFrame4",new MessageHandler());
            return pipeline;
        });
        Channel channel = bootstrap.bind(new InetSocketAddress(port));
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyServer(9999).run();

    }
}

