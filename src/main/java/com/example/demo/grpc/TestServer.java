package com.example.demo.grpc;

import com.example.demo.TestProto;
import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class TestServer {

    private static final int DEFAULT_PORT = 8088;

    private Server server;

    public TestServer(int port) throws Exception {
        //构造服务器，添加我们实际的服务
        this.server = NettyServerBuilder.forPort(port).addService(new TestServiceImpl()).build();
    }

    private void start() throws Exception {
        server.start();
        System.out.println("TestServer start " + server.getPort());
        schedulePub();
        server.awaitTermination();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (server != null) {
                server.shutdown();
            }
        }));

    }

    private void schedulePub() throws InterruptedException {
        while (true) {
            Thread.sleep(5000);
            log.info("等待屏幕输入发送的消息");
            String msg = new Scanner(System.in).nextLine();
            log.info("屏幕收到消息" + msg);
            System.out.println("observers size" + ObserversUtil.observers.size());
            for (String key : ObserversUtil.observers.keySet()) {
                StreamObserver<TestProto.Msg> observer = ObserversUtil.observers.get(key);
                if (observer == null) {
                    log.info("订阅者" + key + "断连了");
                    ObserversUtil.removeObserver(key);
                } else {
                    TestProto.Msg response = TestProto.Msg.newBuilder().setMsg(msg).build();
                    try {
                        log.info("给订阅者" + key + "发布消息");
                        observer.onNext(response);
                    } catch (Exception e) {
                        log.info("发布消息给" + key + "发生异常" + e.getMessage());
                        observer.onError(e);
                        observer.onCompleted();
                        log.info("结束保存的连接");
                        ObserversUtil.removeObserver(key);
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {

        new TestServer(DEFAULT_PORT).start();

    }
}

