package com.example.demo.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by wangrong 2019/12/18
 */
@Data
public class PushOrder {

    private long hqId;
    private long branchId;
    private Date startTime;
    private Date endTime;
    private List<String> orderList;

}
