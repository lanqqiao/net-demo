package com.lqq.demo.dubborpc.customer;

import com.lqq.demo.dubborpc.netty.NettyClient;
import com.lqq.demo.dubborpc.publicinterface.HelloService;

public class ClientBootstrap {


    private static final String providerName = "HelloService#hello#";

    public static void main(String[] args) {
        NettyClient customer = new NettyClient();

        HelloService service = (HelloService) customer.getBean(HelloService.class, providerName);

        String res = service.hello("你好 dubbo~");
        System.out.println("结果：" + res);
    }

}
