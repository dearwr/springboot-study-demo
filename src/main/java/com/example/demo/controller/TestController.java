package com.example.demo.controller;

import com.example.demo.entity.PushOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangrong 2019/12/18
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @PostMapping("/testJson")
    public String test(@RequestBody String jsonData) {
        System.out.println(jsonData);
        PushOrder pushOrder = null;
        try {
            pushOrder = new ObjectMapper().readValue(jsonData, PushOrder.class);
        } catch (JsonProcessingException e) {
            log.info("解析json err：" + e.getMessage());
        }
        System.out.println(pushOrder.getBranchId());
        for (String orderNo : pushOrder.getOrderList()) {
            System.out.println(orderNo);
        }
        return "success";
    }
}
