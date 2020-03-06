package com.example.demo.service;

import com.example.demo.dao.KdsOperationLogDao;
import com.example.demo.dao.OrderDao;
import com.example.demo.entity.TKdsOperationLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by wangrong 2020/1/9
 */
@Service
@Slf4j
public class KdsLogService {

    @Autowired
    private KdsOperationLogDao kdsOperationLogDao;

    @Autowired
    private OrderDao orderDao;

    public void save() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            String action = "ITEM_NOTICE";
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
//            Order order = new Order();
//            order.setBill("" + i);
//            order.setBranchId(392);
//            order.setWaitCallNo(grade);
//            orderDao.save(order);
            log.info("保存成功 branchId={}, grade={}, id={}, orderNo={}", 392, operationLog.getGrade(), operationLog.getId(), operationLog.getOrderNo());
        }
    }
}
