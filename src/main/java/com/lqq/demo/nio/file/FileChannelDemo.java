package com.lqq.demo.nio.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName FileChannel
 * @Description TODO
 * @Author lqq
 * @Date 2019/11/27 10:22
 * @Version 1.0
 **/
public class FileChannelDemo {

    public static void randomRW() throws IOException {
        //        String path = FileChannelDemo.class.getResource("/").getPath();
        //        path = path.replace("/target/classes/", "/");
        //1.创建一个RandomAccessFile（随机访问文件）对象通过RandomAccessFile对象的getChannel()方法。
        RandomAccessFile raf = new RandomAccessFile("demo6.txt", "rw");
        FileChannel fc = raf.getChannel();

        //使用FileChannel的read()方法读取数据：
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int bys = fc.read(byteBuffer);

        //使用FileChannel的write()方法写入数据：
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
        byteBuffer2.put("hello22222222222".getBytes());
        // 这句话不能少
        byteBuffer2.flip();

        fc.write(byteBuffer2);
        //3.关闭FileChannel
        fc.close();
    }

    /**
     * 复制文件到另一文件
     * @throws IOException
     */
    public static void fileRW() throws IOException {
        String path = FileChannelDemo.class.getResource("/").getPath();
        path = path.replace("/target/classes/", "/");
        //1.创建一个RandomAccessFile（随机访问文件）对象通过RandomAccessFile对象的getChannel()方法。
        FileInputStream inputStream = new FileInputStream(new File(path + "demo7.txt"));
        FileChannel fc = inputStream.getChannel();

        //使用FileChannel的read()方法读取数据：
        ByteBuffer buf = ByteBuffer.allocate(1024);
//        byteBuffer.flip();
        RandomAccessFile raf2 = new RandomAccessFile("demo6.txt", "rw");
        FileChannel fc2 = raf2.getChannel();
        while (fc.read(buf) != -1) {
            // 读写翻转
            buf.flip();
            // 将数据写入到通道中
            fc2.write(buf);
            buf.clear();
        }
        //3.关闭FileChannel
        fc.close();
        fc2.close();
    }

    public static void main(String[] args) throws IOException {

        //        randomRW();
        fileRW();
        System.out.println("-----------end");

    }
}
