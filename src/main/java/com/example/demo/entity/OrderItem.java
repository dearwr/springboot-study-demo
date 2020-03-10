package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by wangrong 2020/3/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

        private long orderId;//Item
        private long productId;//商品ID
        private double count;//总数, 支持例半
        private double price;//商品实际单价价格, 含优惠
        private List<OrderItem> items;
}
