package com.example.demo.netty.pack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class MessagePack<T>{

    private String messageId;

    private T data;

}
