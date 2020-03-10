package com.example.demo.service;

import com.example.demo.dao.KdsOperationLogDao;
import com.example.demo.dao.OrderDao;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.entity.TKdsOperationLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
        for (int i = 1; i <= 1; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            String action = "ITEM_NOTICE";
            String action = "ORDER_CALL";
//                String action = "TAKE_COMPLETE";
            TKdsOperationLog operationLog = new TKdsOperationLog();
            String uuid = UUID.randomUUID().toString();
            String orderNo = uuid.substring(0, 10);
            operationLog.setId(uuid.substring(0, 20));
            operationLog.setBranchId(392);
            String grade = "" + i;
            operationLog.setGrade(grade);
            operationLog.setOrderNo(orderNo);
            operationLog.setAction(action);
            kdsOperationLogDao.save(operationLog);

            saveOrder(orderNo, grade);

            log.info("保存成功 branchId={}, grade={}, id={}, orderNo={}", 392, operationLog.getGrade(), operationLog.getId(), operationLog.getOrderNo());
        }
    }

    private void saveOrder(String orderNo, String grade) {
        Order order = new Order();
        order.setBill(orderNo);
        order.setBranchId(392);
        order.setWaitCallNo(grade);
        long orderId = orderDao.save(order);
        System.out.println("save orderId:" + orderId);
        saveOrderItems(orderId);
    }

    private void saveOrderItems(long orderId) {
        OrderItem item;
        long productId = 1000;
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                item = new OrderItem(orderId, productId++, 2, 1,
                        Arrays.asList(new OrderItem(orderId, productId++, 1, 1, null),
                                new OrderItem(orderId, productId++, 1, 1, null)
                        ));
            }else {
                item = new OrderItem(orderId, productId++, 1, 1, null);
            }
            orderDao.saveItem(item);
        }
    }


}
