package com.example.demo.grpc;

import com.example.demo.TestProto;
import com.example.demo.TestServiceGrpc;
import com.example.demo.utils.ThreadUtils;
import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestClient {

    private static final String DEFAULT_HOST = "localhost";

    private static final int DEFAULT_PORT = 8088;

    private static final Logger log = LoggerFactory.getLogger(TestClient.class);

    private ManagedChannel channel;

    private volatile TestServiceGrpc.TestServiceStub serviceStub;

    private StreamObserver<TestProto.Identify> identifyStreamObserver;

    public TestClient(String host, int port) {
        this.channel = NettyChannelBuilder.forAddress(host, port).usePlaintext(true).build();
        System.out.println("连接服务器成功");
        this.serviceStub = TestServiceGrpc.newStub(channel);
    }

    private void subscribe(String key) {
        StreamObserver<TestProto.Msg> response = new StreamObserver<TestProto.Msg>() {
            @Override
            public void onNext(TestProto.Msg msg) {
                log.info(key + "收到订阅消息：" + msg.getMsg());
                if (msg.getMsg().equals("hello")) {
                    log.info(key + "收到回应服务端");
                    identifyStreamObserver.onNext(TestProto.Identify.newBuilder().setKey("how are you").build());
                }
            }

            @SneakyThrows
            @Override
            public void onError(Throwable throwable) {
                log.info(key + "发生异常：" + throwable.getMessage());
                log.info(key + "睡眠1秒重新发起订阅");
                Thread.sleep(1000);
                subscribe(key);
            }

            @Override
            public void onCompleted() {
                log.info(key + "一次订阅结束");
            }
        };
        TestProto.Identify identify = TestProto.Identify.newBuilder().setKey(key).build();
        identifyStreamObserver = serviceStub.getResult(response);
        try {
            log.info(key + "发起订阅");
            identifyStreamObserver.onNext(identify);
        } catch (Exception e) {
            log.info(key + "订阅失败:" + e.getMessage());
            identifyStreamObserver.onError(e);
        }
        log.info(key + "订阅成功");
    }

    public static void main(String[] args) {
        TestClient client = new TestClient(DEFAULT_HOST, DEFAULT_PORT);

        ThreadUtils.executor.submit(() -> {
            client.subscribe("c1");
        });
        ThreadUtils.executor.submit(() -> {
            client.subscribe("c2");
        });
        ThreadUtils.executor.submit(() -> {
            client.subscribe("c3");
        });
    }

}

