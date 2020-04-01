package com.example.demo.entity;

import lombok.Data;

/**
 * Created by wangrong 2020/4/1
 */
@Data
public class ConnectMsg {

    private String ip;
    private int port;
    private String identifier;
    private String deviceMode;
    private String deviceUuid;

}
