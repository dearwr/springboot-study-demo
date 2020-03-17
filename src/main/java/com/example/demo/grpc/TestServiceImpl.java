package com.example.demo.grpc;

import com.example.demo.TestProto;
import com.example.demo.TestServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestServiceImpl extends TestServiceGrpc.TestServiceImplBase {

    @Override
    public StreamObserver<TestProto.Identify> getResult(StreamObserver<TestProto.Msg> responseObserver) {
        return new StreamObserver<TestProto.Identify>() {
            @Override
            public void onNext(TestProto.Identify identify) {
                String subKey = identify.getKey();
                StreamObserver<TestProto.Msg> oldObserver = ObserversUtil.observers.put(subKey, responseObserver);
                if (oldObserver == null) {
                    log.info("订阅者" + subKey + "第一个订阅");
                }
                if (oldObserver == responseObserver) {
                    log.info("订阅者" + subKey + "重复订阅");
                }
                log.info("订阅者" + subKey + "加入订阅");
            }

            @Override
            public void onError(Throwable throwable) {
                log.info("发生异常:" + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                log.info("订阅完成");
            }
        };
    }
}

