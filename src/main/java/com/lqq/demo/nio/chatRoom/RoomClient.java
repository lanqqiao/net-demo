package com.lqq.demo.nio.chatRoom;

import com.lqq.demo.nio.Util.BufferUtil;
import org.springframework.util.StringUtils;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class RoomClient {
    private Selector selector;
    private SocketChannel socketChannel;
    private static final String host = "127.0.0.1";
    private static final int port = 1235;

    public RoomClient() throws Exception {
        selector = Selector.open();
        socketChannel = SocketChannel.open(new InetSocketAddress(port));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    public void writeMsg(String msg) throws Exception {
        ByteBuffer wrap = ByteBuffer.wrap(msg.getBytes());
        socketChannel.write(wrap);
    }

    /**
     * 获取广播的数据
     *
     * @throws Exception
     */
    public void acceptMsg() throws Exception {
        int count = selector.select(2000);
        if (count > 0) {
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel)key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    channel.read(byteBuffer);
                    byteBuffer.clear();
                    String msg = new String(byteBuffer.array());
                    if (!StringUtils.isEmpty(msg)) {
                        System.out.println(msg);
                    }
                }
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        RoomClient roomClient = new RoomClient();
        new Thread(){
            @Override
            public void run() {
                try {
                    while (true) {
                        roomClient.acceptMsg();
                        Thread.sleep(3000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            roomClient.writeMsg(line);
        }

    }

}
