package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by wangrong 2020/3/30
 */
@Data
@AllArgsConstructor
@ToString
public class ConnectData implements Serializable {
    private long branchId;
    private String msg;
}
