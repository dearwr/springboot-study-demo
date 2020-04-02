package com.example.demo.netty.netty4;


import io.netty.handler.codec.LengthFieldPrepender;

public class MsgFrameEncoder extends LengthFieldPrepender {

    public MsgFrameEncoder() {
        super(4);
    }
}
