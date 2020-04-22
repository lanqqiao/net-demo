package com.lqq.demo.netty2.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server ctx = " + ctx);

        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发送消息是：" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址" + ctx.channel().remoteAddress());
        System.out.println("服务端回应：收到了！！！");

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buf = Unpooled.copiedBuffer("hello,客户端~", CharsetUtil.UTF_8);
        ctx.writeAndFlush(buf);


        // 队列实例
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10 * 1000);
                    ByteBuf buf = Unpooled.copiedBuffer("10s后  hello,客户端~", CharsetUtil.UTF_8);
                    ctx.writeAndFlush(buf);
                } catch (Exception ex) {

                }
            }

        });


        // 队列实例
        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10 * 1000);
                    ByteBuf buf = Unpooled.copiedBuffer(" hello,客户端~喵4~", CharsetUtil.UTF_8);
                    ctx.writeAndFlush(buf);
                } catch (Exception ex) {

                }
            }

        }, 5, TimeUnit.SECONDS);

        System.out.println("go on");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
