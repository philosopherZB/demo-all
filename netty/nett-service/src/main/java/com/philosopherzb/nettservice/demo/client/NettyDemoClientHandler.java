package com.philosopherzb.nettservice.demo.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * author: philosopherZB
 * date: 2020/5/12
 */
public class NettyDemoClientHandler extends ChannelInboundHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(NettyDemoClientHandler.class);

    // 当客户端和服务端 TCP 链路建立成功之后，Netty 的 NIO 线程会调用 channelActive 方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String reqMsg = "netty client send message " + Thread.currentThread().getName();
        byte[] reqMsgByte = reqMsg.getBytes(StandardCharsets.UTF_8);
        ByteBuf reqByteBuf = Unpooled.buffer(reqMsgByte.length);
        /*
         * writeBytes：将指定的源数组的数据传输到缓冲区
         * 调用 ChannelHandlerContext 的 writeAndFlush 方法将消息发送给服务器
         */
        reqByteBuf.writeBytes(reqMsgByte);
        ctx.writeAndFlush(reqByteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            // 读取参数
            ByteBuf buf = (ByteBuf) msg;
            byte[] reg = new byte[buf.readableBytes()];
            buf.readBytes(reg);
            String message = new String(reg, StandardCharsets.UTF_8);

            logger.info("The netty client receive message:{}", message);
            ctx.close();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        logger.info("NettyDemoClientHandler occur exception, e: ", cause);
        ctx.close();
    }
}
