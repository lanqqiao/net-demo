package com.lqq.demo.nio.Util;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class BufferUtil {

    /**
     * 读取数据
     *
     * @param sChannel
     * @return
     * @throws IOException
     */
    public static String readChannel(SocketChannel sChannel) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            StringBuilder data = new StringBuilder();
            while (true) {
                buffer.clear();
                int r = sChannel.read(buffer);
                if (r == -1) {
                    break;
                }
                buffer.flip();
                int limit = buffer.limit();
                char[] dst = new char[limit];
                for (int i = 0; i < limit; i++) {
                    dst[i] = (char)buffer.get(i);
                }
                data.append(dst);
                buffer.clear();
            }
            return data.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 读取channel中的数据
     * @param channel
     * @return
     */
    public static String readChannel2(SocketChannel channel) throws Exception{
        String reslut = "";
        //创建字节缓冲区
        ByteBuffer bytebuf = ByteBuffer.allocate(10);
        //默认字符集创建解码器
        Charset charset = Charset.forName("utf-8");
        while((channel.read(bytebuf)) != 0) {//读取通道数据到缓冲区中,非-1就代表有数据
            //确定缓冲区数据的起点和终点
            bytebuf.flip();
            //对bytebuf进行解码，避免乱码
            String temp = charset.decode(bytebuf).toString();
            System.out.println(temp);
            //清空缓冲区，再次放入数据
            bytebuf.clear();
            reslut += temp.toString();
        }
        String ret = URLDecoder.decode(reslut, "utf-8");
        return ret;
    }

    public static void main(String[] args) throws Exception {
        String str = "就解决这个问题上来说，还是建议用回传统的Socket阻塞试读取整个流。或者使用ReadableByteChannel这个类(不能解决读写双向的Channel阻塞问题)，封装Socket流，多绕了一圈而已。";
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(1235));
        String ss = URLEncoder.encode(str, "utf-8");
        socketChannel.write(ByteBuffer.wrap(ss.getBytes()));
        Thread.sleep(10 * 60 * 1000);
//        readChannel(socketChannel);

    }
}
