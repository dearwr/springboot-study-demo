package com.example.demo.test;

import com.example.demo.entity.Output;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wangrong 2019/12/15
 */
@Slf4j
public class DemoTest {

    private RestTemplate restTemplate;

    {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        restTemplate = builder.build();
    }

    public static void main(String[] args) {
        DemoTest demoTest = new DemoTest();
//        testCase1();
//        testCase2();
//        new Thread(() -> demoTest.testCase3()).start();
//        new Thread(() -> demoTest.testCase4()).start();
//        try {
//            Thread.sleep(10*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    private static void testCase1() {
        double price1 = 9.9;                        //  商品1金额
        double price2 = 9.9;                        //  商品2金额
        double price3 = 9.9;                        //  商品3金额
        double sum = price1 + price2 + price3;      //  商品总金额
        System.out.println("商品总价格=" + sum);     // 打印商品总金额  -》29.700000000000003

        double payPrice = 29.7;                     // 支付方式总金额

        boolean flag = (sum == payPrice);           // 判断商品总金额等于支付方式总金额标志

        System.out.println("商品总价格=支付方式金额吗? " + flag);   // 打印商品总金额是否等于支付方式总金额-》false
    }

    private static void testCase2() {
        double price1 = 36.37;                        //  商品1金额
        double price2 = 51.8;                        //  商品2金额
        double sum = price1 + price2;               //  商品总金额
        System.out.println("商品总价格=" + sum);      // 打印商品总金额  -》33.0

        double payPrice = 33.0;                     // 支付方式总金额

        boolean flag = (sum == payPrice);           // 判断商品总金额等于支付方式总金额标志

        System.out.println("商品总价格=支付方式金额吗? " + flag);   // 打印商品总金额是否等于支付方式总金额-》true
    }


    private void testCase3() {
        String url = "http://localhost:9000/callNumber/queryAllCallNumbers/392/16b4c588-330e-3c93-b4a4-45cac77487e8JIAO";
        while (true) {
            try {
                Output response = restTemplate.getForEntity(url, Output.class).getBody();
                System.out.println(new ObjectMapper().writeValueAsString(response));
                Thread.sleep(3 * 1000);
                log.info("睡3秒");
            } catch (InterruptedException | JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    private void testCase4() {
        String url = "http://localhost:9000/callNumber/addFetchNumber/392/";
        String jiao = "/16b4c588-330e-3c93-b4a4-45cac77487e8JIAO";
        String addUrl;
        int number = 1;
        while (true) {
            try {
                addUrl = url + number + jiao;
                Output response = restTemplate.getForEntity(addUrl, Output.class).getBody();
                number ++ ;
                System.out.println(new ObjectMapper().writeValueAsString(response));
                Thread.sleep(2 * 1000);
                log.info("睡5秒");
            } catch (InterruptedException | JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    private void testCase5() {
        String url = "http://localhost:9000/callNumber/cleanScreenNumbers/392/16b4c588-330e-3c93-b4a4-45cac77487e8JIAO";
        while (true) {
            try {
                Output response = restTemplate.getForEntity(url, Output.class).getBody();
                System.out.println(new ObjectMapper().writeValueAsString(response));
                Thread.sleep(3 * 1000);
                log.info("睡3秒");
            } catch (InterruptedException | JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

}
