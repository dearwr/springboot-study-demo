package com.example.demo.netty.handler;


import io.netty.handler.codec.LengthFieldPrepender;

public class MsgFrameEncoder extends LengthFieldPrepender {

    public MsgFrameEncoder() {
        super(2);
    }
}
