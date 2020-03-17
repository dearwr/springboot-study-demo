package com.example.demo.grpc;

import com.example.demo.TestProto;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ObserversUtil {

    public static Map<String, StreamObserver<TestProto.Msg>> observers = new HashMap<>();

    synchronized public static void removeObserver(String key) {
        log.info("删除订阅者" + key);
        observers.remove(key);
    }
}
