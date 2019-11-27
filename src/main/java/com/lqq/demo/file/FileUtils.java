package com.lqq.demo.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName FileUtils
 * @Description TODO
 * @Author jiebai
 * @Date 2019/11/25 15:41
 * @Version 1.0
 **/
public class FileUtils {

    public static void main(String[] args) throws IOException {
        readFile("C:\\Users\\jiebai\\Desktop\\回调数据.txt");
    }

    static void readFile(String path) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(path));
        FileChannel channel = inputStream.getChannel();
        int capacity = 100;// 字节
        ByteBuffer bf = ByteBuffer.allocate(capacity);
        System.out.println("限制是：" + bf.limit() + ",容量是：" + bf.capacity() + " ,位置是：" + bf.position());

        int length = -1;
        while ((length = channel.read(bf)) != -1) {
            /*
             * 注意，读取后，将位置置为0，将limit置为容量, 以备下次读入到字节缓冲中，从0开始存储
             */
            bf.clear();
            byte[] bytes = bf.array();
            System.out.println("start..............");
            String str = new String(bytes, 0, length);
            System.out.println(str);
            System.out.println("end................");
            System.out.println("限制是：" + bf.limit() + "容量是：" + bf.capacity() + "位置是：" + bf.position());
        }

        channel.close();
        inputStream.close();
    }
}
