package com.example.demo.netty.pack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class HeaderPack<T> {

    private int cmd;

    private T msg;

}
