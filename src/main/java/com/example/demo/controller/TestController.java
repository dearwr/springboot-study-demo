package com.example.demo.controller;

import com.example.demo.entity.MallResponse;
import com.example.demo.entity.PushOrder;
import com.example.demo.service.AirportFileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by wangrong 2019/12/18
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private AirportFileService airportFileService;

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
        return "suc";
    }

    @PostMapping("/fileUpload")
    public MallResponse testFileUpload(MultipartFile sourceFile) {
        if (sourceFile.isEmpty()) {
            log.info("上传文件为空");
            return MallResponse.fail("请选择一个上传的文件");
        }
        String fileName = sourceFile.getOriginalFilename();
        if (fileName != null) {
            log.info("上传文件名为：" + fileName);
            switch (fileName) {
                case "airport.xlsx":
                case "airport.xls":
                    return airportFileService.parseFile(sourceFile);
                default:
                    return MallResponse.fail("不支持解析该文件，请检查文件名");
            }
        }
        return MallResponse.fail("文件名为空");
    }
}
