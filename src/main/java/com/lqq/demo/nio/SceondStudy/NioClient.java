package com.lqq.demo.nio.SceondStudy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient {
    public static void main(String[] args) throws IOException, InterruptedException {

        SocketChannel socketChannel = SocketChannel.open();
//        socketChannel.configureBlocking(false);
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8889);
        if (!socketChannel.connect(inetSocketAddress)) {
            while(!socketChannel.finishConnect()){
                System.out.println("客户端连接中...");
            }
        }

        // buffer对象实例化方式一：
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer = byteBuffer.put("hello,byte buffer".getBytes());
        byteBuffer.clear(); // 没有清除或翻转的话，服务端就读不到数据。
        // buffer对象实例化方式二：
        ByteBuffer wrap = ByteBuffer.wrap("hello,sss".getBytes());

        // 写入
        socketChannel.write(byteBuffer);

        socketChannel.close();
    }
}
