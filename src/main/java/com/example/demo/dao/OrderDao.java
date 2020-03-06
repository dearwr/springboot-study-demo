package com.example.demo.dao;

import com.example.demo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrderDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    public boolean save(Order order) {
        String sql = "insert into t_order(hq_id, branch_id, created_at, bill, price, pay_type, platform, service_type, status, wait_call_no, delivery_fee)" +
                " values(?, ?, now(), ?, ?, ?, ?, ?, ?, ?, ?)";

        Object[] params = new Object[]{order.getHqId(), order.getBranchId(), order.getBill(),
                order.getPrice(), order.getPayType(), order.getPlatform(), order.getServiceType(),
                order.getStatus(), order.getWaitCallNo(), order.getDelivery_fee()
        };

        jdbcTemplate.update(sql, params);
        return true;
    }
}
