package com.example.demo.netty.netty4;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class MsgFrameDecoder extends LengthFieldBasedFrameDecoder {

    public MsgFrameDecoder() {
        super(Integer.MAX_VALUE, 0, 4, 0, 4);
    }
}
