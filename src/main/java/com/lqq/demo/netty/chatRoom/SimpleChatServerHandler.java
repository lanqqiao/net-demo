package com.lqq.demo.netty.chatRoom;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class SimpleChatServerHandler extends SimpleChannelInboundHandler<String> {

    // 静态channel组用来存放客户端连接的channel
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    // 处理客户端发来的消息
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        Channel incoming = channelHandlerContext.channel();
        for (Channel channel : channels) {
            if (channel != incoming) {
                channel.writeAndFlush("[" + incoming.remoteAddress() + "]:" + s + "\n");
            } else {
                channel.writeAndFlush("you:" + s + "\n");
            }
        }
    }

    // 处理用户连接的方法
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // 获取客户端连接的channel
        Channel incoming = ctx.channel();
        // 通知目前已经连接的所有用户新用户的连接
        for (Channel channel : channels) {
            channel.writeAndFlush("[USER]-" + incoming.remoteAddress() + "加入\n");
        }
        // 将channel加入channelGroup
        channels.add(incoming);
    }

    // 处理用户断开连接的方法
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel leaving = ctx.channel();
        for (Channel channel : channels) {
            channel.writeAndFlush("[USER]-" + leaving.remoteAddress() + "离开\n");
        }
        channels.remove(leaving);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("[USER]-" + channel.remoteAddress() + "在线\n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("[USER]-" + channel.remoteAddress() + "掉线\n");
    }

    // 异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("[USER]-" + channel.remoteAddress() + "异常\n");
        cause.printStackTrace();
        // 直接关闭连接
        ctx.close();
    }
}