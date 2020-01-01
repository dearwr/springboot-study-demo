package com.example.demo.dao;

import com.example.demo.entity.MallProductCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Created by wangrong 2019/12/31
 */
@Repository
@Slf4j
public class MallProductCodeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private MallProductCode toMapping(ResultSet rs, int num) throws SQLException {
        MallProductCode mallProductCode = new MallProductCode();
        mallProductCode.setId(rs.getInt("f_id"));
        mallProductCode.setHqId(rs.getInt("f_hqid"));
        mallProductCode.setBranchId(rs.getInt("f_branchid"));
        mallProductCode.setMall(rs.getString("f_mall"));
        mallProductCode.setSku(rs.getString("f_sku"));
        mallProductCode.setCode(rs.getString("f_code"));
        mallProductCode.setMallId(rs.getString("f_mall_id"));
        mallProductCode.setCreateTime(rs.getDate("f_createtime"));
        return mallProductCode;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean batchSave(List<MallProductCode> mallProductCodeList) {
        String sql = "insert into t_mall_product_code(f_hqid, f_branchid, f_mall, f_sku, f_code, f_mall_id, f_createtime)" +
                " values(?, ?, ?, ?, ?, ?, now())";
        List<Object[]> paramsArr = new ArrayList<>(mallProductCodeList.size());
        for (int i = 0; i < mallProductCodeList.size(); i++) {
            MallProductCode table = mallProductCodeList.get(i);
            Object[] params = new Object[]{
                    table.getHqId(), table.getBranchId(), table.getMall(), table.getSku(), table.getCode(), table.getMallId()};
            paramsArr.add(params);
        }
        jdbcTemplate.batchUpdate(sql, paramsArr);
        return true;
    }

    public List<MallProductCode> queryBySkuList(List<String> skuList) {
        String sql = "select * from t_mall_product_code where f_sku in ('" +
                String.join("','", skuList) +
                "')";
        return jdbcTemplate.query(sql, this::toMapping);
    }
}
