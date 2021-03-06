package com.lqq.demo.netty.chatRoom;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


public class SimpleChatServerInitial extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline()
                .addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()))
                .addLast("encoder", new StringEncoder())
                .addLast("decoder", new StringDecoder())
                .addLast("handler", new SimpleChatServerHandler());

        System.out.println("[USER]-" + channel.remoteAddress() + "连接上");
    }
}