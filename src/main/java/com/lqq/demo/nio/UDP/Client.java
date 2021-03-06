package com.lqq.demo.nio.UDP;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramChannel dc= DatagramChannel.open();
        dc.bind(new InetSocketAddress(InetAddress.getLocalHost(),9999));

        //创建读数据/写数据缓冲区对象来读取服务端数据或向服务端发送数据
        //向通道中写入数据
        ByteBuffer buffer= ByteBuffer.allocate(1024);
        buffer.put("hello".getBytes());
        buffer.flip();
        dc.send(buffer,new InetSocketAddress(InetAddress.getLocalHost(),8888));

        //读取从客户端中获取的数据
        ByteBuffer buffer2=ByteBuffer.allocate(1024);
        dc.receive(buffer2);
        StringBuffer sb=new StringBuffer();
        buffer2.flip();
        while(buffer2.hasRemaining()){
            sb.append((char)buffer2.get());
        }
        System.out.println(sb.toString());
        
        dc.close();
    }
}