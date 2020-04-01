package com.example.demo.utils;

import com.google.gson.Gson;

/**
 * Created by wangrong 2020/4/1
 */
public class JsonUtils {

    private static final Gson GSON = new Gson();

    private JsonUtils() {
        //no instance
    }

    public static <T> T fromJson(String jsonStr, Class<T> clazz){
        return GSON.fromJson(jsonStr, clazz);
    }

    public static String toJson(Object object){
        return GSON.toJson(object);
    }

}
