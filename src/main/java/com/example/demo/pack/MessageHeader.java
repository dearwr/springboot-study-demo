package com.example.demo.pack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class MessageHeader {

    private int cmd;

    private String msg;

}
