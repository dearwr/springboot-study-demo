package com.example.demo.dao;

import com.example.demo.entity.MallProductCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangrong 2019/12/31
 */
@Repository
@Slf4j
public class MallProductCodeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int batchSave(List<MallProductCode> mallProductCodeList) {
        String sql = "insert into t_mall_product_code(f_hqid, f_branchid, f_mall, f_sku, f_code, f_mall_id, f_createtime)" +
                " values(?, ?, ?, ?, ?, ?, now())";
        List<Object[]> paramsArr = new ArrayList<>(mallProductCodeList.size());
        for (int i = 0; i < mallProductCodeList.size(); i++) {
            MallProductCode table = mallProductCodeList.get(i);
            Object[] params = new Object[]{
                    table.getHqId(), table.getBranchId(), table.getMall(), table.getSku(), table.getCode(), table.getMallId()};
            paramsArr.add(params);
        }
        int[] rows = jdbcTemplate.batchUpdate(sql, paramsArr);
        return mallProductCodeList.size() - rows.length;
    }
}
