package com.example.demo;

import com.example.demo.service.KdsLogService;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private KdsLogService kdsLogService;

    @Test
    void contextLoads() {
        kdsLogService.save();
    }

    @Test
    public void testCollection() {
        List<People> allKdsLog = Arrays.asList(
                new People("wr", 12),
                new People("wf", 19),
                new People("wc", 12),
                new People("wy", 19),
                new People("wa", 12),
                new People("ws", 11),
                new People(null, 11)
        );
//        Map<Integer, List<People>> statueLogMap = allKdsLog.stream().collect(Collectors.groupingBy(People::getAge));
//        List<People> completeList = statueLogMap.get(12);
//        completeList.addAll(statueLogMap.get(11));     // 加入订单完成的
        Map<String, List<People>> completeList = allKdsLog.stream().collect(Collectors.groupingBy(People::getName));
        for (int i = 0; i < completeList.size(); i++) {
            System.out.println(completeList.get(i));
        }
    }

    @Data
    class People {
        String name;
        int age;

        People(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    @Test
    public void testInteger() {
        int code = Integer.parseInt(null);
        System.out.println(code);
    }


}

