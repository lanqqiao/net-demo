package com.lqq.demo.netty2.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class NettyByteBuf02 {

    public static void main(String[] args) {

        ByteBuf buf = Unpooled.copiedBuffer("hello,world 杭州", Charset.forName("utf-8"));
        if (buf.hasArray()) {
            byte[] array = buf.array();
            System.out.println(new String(array, Charset.forName("utf-8")));
            System.out.println("buf =" + buf);
        }


    }
}
