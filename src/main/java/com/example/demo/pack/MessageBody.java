package com.example.demo.pack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class MessageBody {

    private String messageId;

    private String data;

}
