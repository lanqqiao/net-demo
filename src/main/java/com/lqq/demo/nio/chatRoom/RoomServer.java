package com.lqq.demo.nio.chatRoom;

import com.lqq.demo.nio.Util.BufferUtil;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class RoomServer {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    final int port = 1235;

    public RoomServer() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void accept() {
        try {
            while (true) {
                int count = selector.select(2000);
                if (count == 0) {
//                    System.out.println("等待...");
                    continue;
                }
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) {
                        SocketChannel sChannel = serverSocketChannel.accept();
                        sChannel.configureBlocking(false);
                        sChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println(sChannel.getRemoteAddress() + "进入聊天室。");
                        sendClient(sChannel.getRemoteAddress() + "进入聊天室。", sChannel);
                    }
                    if (key.isReadable()) {
                        SocketChannel channel = null;
                        try {
                            channel = (SocketChannel)key.channel();
//                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//                            channel.read(byteBuffer);
//                            byteBuffer.clear();
                            String msg = BufferUtil.readChannel2(channel);
                            if (!StringUtils.isEmpty(msg)) {
                                String showMsg = channel.getRemoteAddress() + "say：" + msg;
                                System.out.println(showMsg);
                                // 广播信息
                                sendClient(showMsg, channel);
                            }
                        } catch (Exception ex) {
//                            ex.printStackTrace();
                            System.out.println(channel.getRemoteAddress() + "离线");
                            key.cancel();
                            sendClient(channel.getRemoteAddress() + "离线", channel);
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                    iterator.remove();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 广播信息到客户端
     *
     * @param msg
     * @param self
     * @throws IOException
     */
    private void sendClient(String msg, SocketChannel self) throws IOException {
        Iterator<SelectionKey> iterator = selector.keys().iterator();
        while (iterator.hasNext()) {
            Channel channel = iterator.next().channel();
            if (channel instanceof SocketChannel && channel != self) {
                SocketChannel sc = (SocketChannel)channel;
                sc.write(ByteBuffer.wrap(msg.getBytes()));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new RoomServer().accept();
    }
}
