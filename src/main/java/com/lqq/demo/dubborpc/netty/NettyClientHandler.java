package com.lqq.demo.dubborpc.netty;

import com.lqq.demo.dubborpc.provider.HelloServiceImpl;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.concurrent.Callable;

public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private ChannelHandlerContext context; // 上下文
    private String result; // 返回的结果
    private String para; // 客户端调用的方法，传入的参数


    // 连接调用 第一个被调用  （1）
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        context = ctx;
    }

    // 收到服务器的数据后，调用  （4）
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        result = msg.toString();
        notify(); // 唤醒等待的线程   是要唤醒call


    }

    // 被代理对象调用，发送数据给服务器 -> wait -> 等待被唤醒(channelRead) -> 返回结果 （3）（5）
    @Override
    public synchronized Object call() throws Exception {
        context.channel().writeAndFlush(para);
        // 进行wait
        wait(); // 等待 channelRead方法 获得服务器返回后 唤醒
        return result;
    }

    // （2）
    public void setPara(String para) {
        this.para = para;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
