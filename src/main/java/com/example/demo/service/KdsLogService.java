package com.example.demo.service;

import com.example.demo.dao.KdsOperationLogDao;
import com.example.demo.entity.TKdsOperationLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.logging.Logger;

/**
 * Created by wangrong 2020/1/9
 */
@Service
@Slf4j
public class KdsLogService {

    @Autowired
    private KdsOperationLogDao kdsOperationLogDao;

    public void save() {
        ExecutorService service = new ScheduledThreadPoolExecutor(10);
        CountDownLatch cdl = new CountDownLatch(6);
        service.submit(() -> {
            for (int i = 1; i <= 100; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String action = "ITEM_NOTICE";
//                String action = "ORDER_CALL";
//                String action = "TAKE_COMPLETE";
                TKdsOperationLog operationLog = new TKdsOperationLog();
                operationLog.setId(UUID.randomUUID().toString().substring(0, 20));
                operationLog.setBranchId(392);
                String grade = "" + i;
                operationLog.setGrade(grade);
                operationLog.setOrderNo("" + i);
                operationLog.setAction(action);
                kdsOperationLogDao.save(operationLog);
                log.info("保存成功 branchId={}, grade={}, id={}, orderNo={}", 392, operationLog.getGrade(), operationLog.getId(), operationLog.getOrderNo());
            }
            cdl.countDown();
        });

        service.submit(() -> {
            for (int i = 101; i <= 200; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String action = "ITEM_NOTICE";
//                String action = "ORDER_CALL";
//                String action = "TAKE_COMPLETE";
                TKdsOperationLog operationLog = new TKdsOperationLog();
                operationLog.setId(UUID.randomUUID().toString().substring(0, 20));
                operationLog.setBranchId(4046);
                String grade = "" + i;
                operationLog.setGrade(grade);
                operationLog.setOrderNo("" + i);
                operationLog.setAction(action);
                kdsOperationLogDao.save(operationLog);
                log.info("保存成功 branchId={}, grade={}, id={}, orderNo={}", 392, operationLog.getGrade(), operationLog.getId(), operationLog.getOrderNo());
            }
            cdl.countDown();
        });


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.submit(()->{
            for (int i = 1; i <= 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                String action = "ITEM_NOTICE";
                String action = "ORDER_CALL";
//                String action = "TAKE_COMPLETE";
                TKdsOperationLog operationLog = new TKdsOperationLog();
                operationLog.setId(UUID.randomUUID().toString().substring(0, 20));
                operationLog.setBranchId(392);
                String grade = "" + i;
                operationLog.setGrade(grade);
                operationLog.setOrderNo("" + i);
                operationLog.setAction(action);
                kdsOperationLogDao.save(operationLog);
                log.info("保存成功 branchId={}, grade={}, id={}, orderNo={}", 392, operationLog.getGrade(), operationLog.getId(), operationLog.getOrderNo());
            }
            cdl.countDown();
        });

        service.submit(()->{
            for (int i = 101; i <= 200; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                String action = "ITEM_NOTICE";
                String action = "ORDER_CALL";
//                String action = "TAKE_COMPLETE";
                TKdsOperationLog operationLog = new TKdsOperationLog();
                operationLog.setId(UUID.randomUUID().toString().substring(0, 20));
                operationLog.setBranchId(4046);
                String grade = "" + i;
                operationLog.setGrade(grade);
                operationLog.setOrderNo("" + i);
                operationLog.setAction(action);
                kdsOperationLogDao.save(operationLog);
                log.info("保存成功 branchId={}, grade={}, id={}, orderNo={}", 392, operationLog.getGrade(), operationLog.getId(), operationLog.getOrderNo());
            }
            cdl.countDown();
        });

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.submit(()->{
            for (int i = 1; i <= 100; i++) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                String action = "ITEM_NOTICE";
//                String action = "ORDER_CALL";
                String action = "TAKE_COMPLETE";
                TKdsOperationLog operationLog = new TKdsOperationLog();
                operationLog.setId(UUID.randomUUID().toString().substring(0, 20));
                operationLog.setBranchId(392);
                String grade = "" + i;
                operationLog.setGrade(grade);
                operationLog.setOrderNo("" + i);
                operationLog.setAction(action);
                kdsOperationLogDao.save(operationLog);
                log.info("保存成功 branchId={}, grade={}, id={}, orderNo={}", 392, operationLog.getGrade(), operationLog.getId(), operationLog.getOrderNo());
            }
            cdl.countDown();
        });

        service.submit(()->{
            for (int i = 101; i <= 200; i++) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                String action = "ITEM_NOTICE";
//                String action = "ORDER_CALL";
                String action = "TAKE_COMPLETE";
                TKdsOperationLog operationLog = new TKdsOperationLog();
                operationLog.setId(UUID.randomUUID().toString().substring(0, 20));
                operationLog.setBranchId(4046);
                String grade = "" + i;
                operationLog.setGrade(grade);
                operationLog.setOrderNo("" + i);
                operationLog.setAction(action);
                kdsOperationLogDao.save(operationLog);
                log.info("保存成功 branchId={}, grade={}, id={}, orderNo={}", 392, operationLog.getGrade(), operationLog.getId(), operationLog.getOrderNo());
            }
            cdl.countDown();
        });

        try {
            cdl.await();
            log.info("全部完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
