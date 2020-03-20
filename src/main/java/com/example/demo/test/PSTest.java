package com.example.demo.test;

import java.util.concurrent.ConcurrentLinkedQueue;

public class PSTest {

    public static void main(String[] args) {
        Son son = new Son();
        son.getMoney();
        System.out.println(son.money);
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add("hello");
        queue.add("hello");
        String string;
        while (queue.peek() != null) {
            string = queue.poll();
            System.out.println(string);
        }

    }
}
