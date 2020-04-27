package com.lqq.demo.netty2.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class MyMessageDecoder extends ReplayingDecoder<MessageProtocol> {


    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("解码器 decode 被调用");

        int length = in.readInt();
        byte[] content = new byte[length];
        in.readBytes(content);
        MessageProtocol msg = new MessageProtocol(length, content);
        out.add(msg);
    }
}
