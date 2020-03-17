package com.example.demo.dao;

import com.example.demo.entity.TKdsOperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by wangrong 2020/1/9
 */
@Repository
public class KdsOperationLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    public boolean save(TKdsOperationLog log) {
        String sql = "insert into t_kds_operation_log(f_time_consuming, f_product_id, f_location, f_order_no, f_id, f_hqid, f_branchid, " +
                "f_grade, f_device, f_action, f_count,f_order_mode, f_option_time, f_upload_time)" +
                " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), now())";

        Object[] params = new Object[]{log.getTimeConsuming(), log.getProductId(), log.getLocation(), log.getOrderNo(),
                log.getId(), log.getHqId(), log.getBranchId(), log.getGrade(),
                log.getDevice(), log.getAction(), log.getCount(), log.getOrderMode()
        };

        jdbcTemplate.update(sql, params);
        return true;
    }


}
