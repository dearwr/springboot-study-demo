package com.example.demo.netty;

import com.example.demo.netty.handler.*;
import com.example.demo.netty.pack.MessageBody;
import com.example.demo.netty.pack.MessageHeader;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

import static com.example.demo.netty.pack.CmdType.CREATE_CONNECT;

/**
 * Created by wangrong 2020/3/30
 */
@Slf4j
public class NettyClient {

    private static volatile NettyClient instance;
    private String host = "localhost";
    private int port = 9999;
    private Bootstrap bootstrap;
    private EventLoopGroup eventLoopGroup;
    public static Channel channel;

    private static NettyClient getInstance() throws InterruptedException {
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

    private NettyClient() {
        bootstrap = new Bootstrap();
        eventLoopGroup = new NioEventLoopGroup();
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .remoteAddress(host, port)
                .handler(new ChannelInitializer<io.netty.channel.socket.SocketChannel>() {
                    @Override
                    protected void initChannel(io.netty.channel.socket.SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new MsgFrameDecoder());
                        pipeline.addLast(new MsgFrameEncoder());
                        pipeline.addLast(new MessageEncoder());
                        pipeline.addLast(new MessageDecoder());
                        pipeline.addLast(new MessageHandler());
                    }
                });
    }

    public static Channel getConnect() throws InterruptedException {
        log.info("try connect to server");
        ChannelFuture future = getInstance().bootstrap.connect().sync();
        if (future.isSuccess()) {
            channel = future.channel();
            log.info("connect to server success");
        }
        return channel;
    }


    public static void main(String[] args) throws InterruptedException {
        Channel channel = NettyClient.getConnect();
        if (channel != null) {
            while (true) {
                Thread.sleep(10000);
                MessageBody msgBody = new MessageBody("123", new Object());
                MessageHeader msgHeader = new MessageHeader(CREATE_CONNECT, msgBody);
                channel.writeAndFlush(msgHeader);
            }
        }
    }
}
