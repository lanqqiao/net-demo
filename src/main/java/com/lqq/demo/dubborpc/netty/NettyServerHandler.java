package com.lqq.demo.dubborpc.netty;

import com.lqq.demo.dubborpc.provider.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("msg =" + msg);
        // 客户端在调用服务器的api时，必须定义一个协议
        // 比如我们要求  每次发消息时都必须以某个字符串开头 “HelloService#hello#”
        if (msg.toString().startsWith("HelloService#hello#")) {
            String hello = new HelloServiceImpl().hello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
            ctx.writeAndFlush(hello);
        }

    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
