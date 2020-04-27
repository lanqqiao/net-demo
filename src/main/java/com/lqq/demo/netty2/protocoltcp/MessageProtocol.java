package com.lqq.demo.netty2.protocoltcp;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class MessageProtocol {

    private int len;
    private byte[] content;

    public MessageProtocol(int len, byte[] content) {
        this.len = len;
        this.content = content;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageProtocol{" +
                "len=" + len +
                ", content=" + new String (content) +
                '}';
    }
}
