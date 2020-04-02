package com.example.demo.netty.netty4;

import com.example.demo.pack.MessageBody;
import com.example.demo.pack.MessageHeader;
import com.example.demo.utils.JsonUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

import static com.example.demo.pack.CmdType.CREATE_CONNECT;

/**
 * Created by wangrong 2020/3/30
 */
@Slf4j
public class NettyClient {

    private String host = "localhost";
    private int port = 9999;
    private static Bootstrap bootstrap;
    private EventLoopGroup eventLoopGroup;
    private Channel channel;

    public NettyClient() throws InterruptedException {
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
        ChannelFuture future = bootstrap.connect().sync();
        if (future.isSuccess()) {
            log.info("client start");
            channel = future.channel();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Channel channel = new NettyClient().channel;
        while (true) {
            Thread.sleep(10000);
            MessageBody msgBody = new MessageBody("123", "hello");
            MessageHeader msgHeader = new MessageHeader(CREATE_CONNECT, JsonUtils.toJson(msgBody));
            channel.writeAndFlush(msgHeader);
        }
    }
}
