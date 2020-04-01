package com.example.demo.netty.pack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.poi.ss.formula.functions.T;

@Data
@ToString
@AllArgsConstructor
public class MessageBody {

    private String messageId;

    private Object data;

}
