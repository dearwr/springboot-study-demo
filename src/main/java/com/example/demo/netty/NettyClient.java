package com.example.demo.netty;

import com.example.demo.entity.ConnectMsg;
import com.example.demo.netty.handler.*;
import com.example.demo.netty.pack.HeaderPack;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.bootstrap.ConnectionlessBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.channel.socket.nio.NioDatagramChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangrong 2020/3/30
 */
public class NettyClient {

    private static volatile NettyClient instance;
    private String host = "192.168.31.253";
    private int port = 9002;
    private ClientBootstrap bootstrap;
    private ExecutorService boss;
    private ExecutorService worker;
    private ChannelFuture channelFuture;
    public Channel channel;

    private static void launchNerwork() {
        ChannelFactory factory = new NioDatagramChannelFactory(Executors.newCachedThreadPool());
        ConnectionlessBootstrap bootstrap = new ConnectionlessBootstrap(factory);
        bootstrap.setPipelineFactory(() -> {
            ChannelPipeline pipeline = Channels.pipeline();
            pipeline.addLast("decoder", new PackDecoder());
            pipeline.addLast("encoder", new PackEncoder());
            pipeline.addLast("busi", new MessageHandler());
            return pipeline;
        });
        InetSocketAddress socketAddress = new InetSocketAddress("192.168.174.1", 9999);
//        logger.info("UdpServerHandler", "udp launchNerwork run on ");
        ChannelFuture channelFuture = bootstrap.connect(socketAddress);
        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if (future.isSuccess()){
//                    logger.info("link success");
                    Thread.sleep(10000);
                    ConnectMsg messageData = new ConnectMsg();
                    messageData.setIp("666");
                    messageData.setDeviceUuid("123654");
                    HeaderPack headerPack = new HeaderPack(330, messageData);
                    future.getChannel().write(headerPack);
//                    NettyUtils.sendDeviceData(channelFuture.getChannel(), socketAddress, PackCmd.SEARCCH_PASSDISH);
                }else{
                    // 如果发生错误，则访问描述原因的Throwable
                    Throwable cause = future.getCause();
                    cause.printStackTrace();
                }
            }
        });
    }

    public static NettyClient getInstance() throws InterruptedException {
        if (instance == null) {
            synchronized (NettyClient.class) {
                if (instance == null) {
                    return new NettyClient();
                }
                return instance;
            }
        }
        return instance;
    }

    private NettyClient() throws InterruptedException {
        // 客户端的启动类
        bootstrap = new ClientBootstrap();
        //线程池
        boss = Executors.newCachedThreadPool();
        worker = Executors.newCachedThreadPool();
        //socket工厂
        bootstrap.setFactory(new NioClientSocketChannelFactory(boss, worker));
        //管道工厂
        bootstrap.setPipelineFactory(() -> {
            ChannelPipeline pipeline = Channels.pipeline();
            pipeline.addLast("msgFrame", new MsgFrameDecoder());
            pipeline.addLast("msgFrame1", new MsgFrameEncoder());

            pipeline.addLast("msgFrame2", new MessageEncoder());
            pipeline.addLast("msgFrame3", new MessageDecoder());
            pipeline.addLast("msgFrame4", new MessageHandler());
            return pipeline;
        });
        //连接服务端
        channelFuture = bootstrap.bind(new InetSocketAddress(host, port)).sync();
        if (channelFuture.isSuccess()) {
            channel = channelFuture.getChannel();
            System.out.println("client link server success");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        NettyClient.launchNerwork();
//        NettyClient client = NettyClient.getInstance();
//        while (true) {
//            Thread.sleep(10000);
//            ConnectMsg messageData = new ConnectMsg();
//            messageData.setIp("666");
//            messageData.setDeviceUuid("123654");
//            HeaderPack headerPack = new HeaderPack(CREATE_CONNECT, messageData);
//            client.channel.write(headerPack);
//        }
    }
}
