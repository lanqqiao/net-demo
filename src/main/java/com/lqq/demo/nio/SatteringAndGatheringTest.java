package com.lqq.demo.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class SatteringAndGatheringTest {

    public static void main(String[] args) throws Exception{

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        serverSocketChannel.socket().bind(inetSocketAddress);

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);
        // 等待客户端链接
        SocketChannel socketChannel = serverSocketChannel.accept();
        while (true) {
            int byteRead = 0;
            while (byteRead < 8) {
                long read = socketChannel.read(byteBuffers);
                byteRead += read;
                System.out.println("byteRead=" + byteRead);
                Arrays.asList(byteBuffers).stream().map(buffer -> "postion=" + buffer.position() + ",limit="
                    + buffer.limit()).forEach(System.out::println);
            }

            // 反转
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());

            // 写
            long byteWirte = 0;
            while (byteWirte < 8) {
                socketChannel.write(byteBuffers);
                byteWirte += 1;
            }

            // clear
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.clear());

            System.out.println(byteRead + "||" + byteWirte);
        }


    }
}
