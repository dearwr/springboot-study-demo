package com.example.demo.netty.handler;


import org.jboss.netty.handler.codec.frame.LengthFieldBasedFrameDecoder;

public class MsgFrameDecoder extends LengthFieldBasedFrameDecoder {

    public MsgFrameDecoder() {
        super(Integer.MAX_VALUE, 0, 2, 0, 2);
    }
}
