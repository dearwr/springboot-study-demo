package com.example.demo.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by wangrong 2019/12/31
 */
@Slf4j
public class ObjectUtils {

    public static <T> T getInstanceFromMap(Map<String, String> paramMap, Class<T> clz) {
        if (paramMap == null) {
            log.info("传入的paramMap为空");
            return null;
        }
        if (clz == null) {
            log.info("传入的对象为空");
            return null;
        }
        T instance;
        try {
            instance = clz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.info("反射创建对象失败：" + e.getMessage());
            return null;
        }
        for (String fieldName : paramMap.keySet()) {
            try {
                Field field = clz.getDeclaredField(fieldName);
                if (field != null) {
                    field.setAccessible(true);
                    if ("double".equals(field.getType().getName())) {
                        field.set(instance, Double.valueOf(paramMap.get(fieldName)));
                    }else {
                        field.set(instance, paramMap.get(fieldName));
                    }
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                log.info("未找到属性：{}", fieldName);
            }
        }
        return instance;
    }
}
