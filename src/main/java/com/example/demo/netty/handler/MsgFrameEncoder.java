package com.example.demo.netty.handler;


import org.jboss.netty.handler.codec.frame.LengthFieldPrepender;

public class MsgFrameEncoder extends LengthFieldPrepender {

    public MsgFrameEncoder() {
        super(2);
    }
}
