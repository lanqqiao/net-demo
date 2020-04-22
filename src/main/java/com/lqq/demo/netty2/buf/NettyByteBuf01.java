package com.lqq.demo.netty2.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class NettyByteBuf01 {

    public static void main(String[] args) {



        // 1,创建对象，该对象包含一个数组arr，是一个byte数组
        // 2，在netty的buffer中 不需要使用flip进行反转
        // 底层维护了 readindex和writeindex
        ByteBuf buffer = Unpooled.buffer(10);

        for (int i = 0; i < 10; i++) {
            buffer.writeByte(i);
        }
        System.out.println("capacity = " + buffer.capacity());

        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.getByte(i));
            System.out.println(buffer.readByte());
        }
    }
}
