package com.example.demo.netty.jboss;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangrong 2020/4/2
 */
public class JbossServer {

    public static void main(String[] args) {
        // 服务类
        ServerBootstrap bootstrap = new ServerBootstrap();
        // boss线程监听端口，worker线程负责数据读写
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();
        // 设置niosocket工厂
        bootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));
        // 设置管道的工厂
        bootstrap.setPipelineFactory(() -> {
            ChannelPipeline pipeline = Channels.pipeline();
            pipeline.addLast("mEncoder", new JbossMsgEncoder());
            pipeline.addLast("mDecoder", new JbossMsgDecoder());
            pipeline.addLast("hiHandler", new JbossMsgHandler());
            return pipeline;
        });
        bootstrap.bind(new InetSocketAddress(9999));
        System.out.println(" jboss server start ");
    }

}
