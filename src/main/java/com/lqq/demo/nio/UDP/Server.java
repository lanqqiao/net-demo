package com.lqq.demo.nio.UDP;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramChannel dc= DatagramChannel.open();
        dc.bind(new InetSocketAddress(InetAddress.getLocalHost(),8888));


        //创建读数据/写数据缓冲区对象来读取客户端数据或向客户端发送数据
        //读取客户端发送的数据
        ByteBuffer buffer= ByteBuffer.allocate(1024);
        //从通道中读取数据到缓冲区
        dc.receive(buffer); // TODO 这里会挂起等待
        StringBuffer sb=new StringBuffer();
        buffer.flip();
        while(buffer.hasRemaining()){
            sb.append((char)buffer.get());
        }
        System.out.println(sb.toString());

        ByteBuffer buffer2=ByteBuffer.allocate(1024);
        //向客户端发送数据
        buffer2.put("data has been received.".getBytes());
        buffer2.flip();
        // TODO 这里发送回信
        dc.send(buffer2,new InetSocketAddress(InetAddress.getLocalHost(),9999));
        
        dc.close();
    }
}