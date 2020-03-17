package com.example.demo.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtils {

    public static final ExecutorService executor = Executors.newFixedThreadPool(10);

}
