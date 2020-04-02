package com.example.demo.netty.jboss;

import com.example.demo.pack.CmdType;
import com.example.demo.pack.MessageBody;
import com.example.demo.pack.MessageHeader;
import com.example.demo.utils.JsonUtils;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JbossClient {

    public static Channel launch() {
        // 服务类
        ClientBootstrap bootstrap = new ClientBootstrap();
        // 线程池
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();
        // socket工厂
        bootstrap.setFactory(new NioClientSocketChannelFactory(boss, worker));
        // 管道工厂
        bootstrap.setPipelineFactory(() -> {
            ChannelPipeline pipeline = Channels.pipeline();
            pipeline.addLast("mEncoder", new JbossMsgEncoder());
            pipeline.addLast("mDecoder", new JbossMsgDecoder());
            pipeline.addLast("hiHandler", new JbossMsgHandler());
            return pipeline;
        });
        ChannelFuture connect = null;
        try {
            connect = bootstrap.connect(new InetSocketAddress("localhost", 9999)).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Channel channel = null;
        if (connect.isSuccess()) {
             channel = connect.getChannel();
            System.out.println(" jboss client start");
        }
        return channel;
    }

    public static void main(String[] args) {
        Channel channel = JbossClient.launch();

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MessageBody messageBody = new MessageBody("123654", JsonUtils.toJson("create connect"));
            channel.write(new MessageHeader(CmdType.CREATE_CONNECT, JsonUtils.toJson(messageBody)));
        }
    }
}
