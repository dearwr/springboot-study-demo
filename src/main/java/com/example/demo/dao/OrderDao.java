package com.example.demo.dao;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OrderDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    public long save(Order order) {
        String sql = "insert into t_order(hq_id, branch_id, created_at, bill, price, pay_type, platform, service_type, status, wait_call_no, delivery_fee)" +
                " values(?, ?, now(), ?, ?, ?, ?, ?, ?, ?, ?)";

        Object[] params = new Object[]{order.getHqId(), order.getBranchId(), order.getBill(),
                order.getPrice(), order.getPayType(), order.getPlatform(), order.getServiceType(),
                order.getStatus(), order.getWaitCallNo(), order.getDelivery_fee()
        };

        jdbcTemplate.update(sql, params);
        return (long) jdbcTemplate.queryForList("select id from t_order where bill = ?", order.getBill()).get(0).get("id");
    }


    public void saveItem(OrderItem item) {
        String sql = "insert into t_order_item(order_id, product_id, count, price) values(?,?,?,?)";
        jdbcTemplate.update(sql, item.getOrderId(), item.getProductId(), item.getCount(), item.getPrice());
        long itemId = (long) jdbcTemplate.queryForList("select  id from t_order_item where order_id = ? and product_id = ?", item.getOrderId(), item.getProductId())
                .get(0).get("id");
        System.out.println("save itemId:" + itemId);
        List<OrderItem> sonItems = item.getItems();
        if (sonItems != null && !sonItems.isEmpty()) {
            for (OrderItem i : sonItems) {
                sql = "insert into t_order_item(order_id, product_id, count, price, parent_item_id) values(?,?,?,?,?)";
                jdbcTemplate.update(sql, i.getOrderId(), i.getProductId(), i.getCount(), i.getPrice(), itemId);
            }
        }
    }
}
