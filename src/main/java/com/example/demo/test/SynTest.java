package com.example.demo.test;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wangrong 2020/1/15
 */
public class SynTest {

    private static final Map<Integer, List<String>> NUMBER_MAP = new ConcurrentHashMap<>();

    static {
        List list = new Vector();
        list.add("jiao");
        NUMBER_MAP.put(1, list);
    }

    public static void main(String[] args) {
        final CountDownLatch cdl = new CountDownLatch(5);

        for (Integer key : NUMBER_MAP.keySet()) {
            List list = NUMBER_MAP.get(key);
            System.out.println("key=" + key + ",values=" + list);
        }

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                    NUMBER_MAP.get(1).remove("jiao");
                    NUMBER_MAP.get(1).add("jiao");
            }
            cdl.countDown();

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                    NUMBER_MAP.get(1).remove("jiao");
                    NUMBER_MAP.get(1).add("jiao");
            }
            cdl.countDown();

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                    NUMBER_MAP.get(1).remove("jiao");
                    NUMBER_MAP.get(1).add("jiao");
            }
            cdl.countDown();

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                    NUMBER_MAP.get(1).remove("jiao");
                    NUMBER_MAP.get(1).add("jiao");
            }
            cdl.countDown();

        }).start();

        for (int i = 0; i < 10000; i++) {
                NUMBER_MAP.get(1).remove("jiao");
                NUMBER_MAP.get(1).add("jiao");
            cdl.countDown();

        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Integer key : NUMBER_MAP.keySet()) {
            List list = NUMBER_MAP.get(key);
            System.out.println("key=" + key + ",values=" + list);
        }
    }
}
