package com.lqq.demo.dubborpc.provider;

import com.lqq.demo.dubborpc.netty.NettyServer;

public class ServerBootstrap {

    public static void main(String[] args) {
        //
        NettyServer.startServer("127.0.0.1", 7001);
    }
}
