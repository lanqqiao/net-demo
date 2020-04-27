package com.lqq.demo.netty2.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.UUID;

public class NettyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private  int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {

        System.out.println("服务器接收到的数据" + msg);
        System.out.println("服务器接受的消息量" + (++this.count));

        String res = UUID.randomUUID().toString();
        MessageProtocol resMsg = new MessageProtocol(res.getBytes().length, res.getBytes());
        ctx.writeAndFlush(resMsg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
