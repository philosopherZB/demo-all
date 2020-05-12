package com.philosopherzb.nettservice.demo.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * author: philosopherZB
 * date: 2020/5/12
 */
public class NettyDemoServiceHandler extends ChannelInboundHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(NettyDemoServiceHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            // 读取参数
            ByteBuf buf = (ByteBuf) msg;
            byte[] reg = new byte[buf.readableBytes()];
            buf.readBytes(reg);
            String message = new String(reg, StandardCharsets.UTF_8);

            logger.info("The netty server receive message:{}", message);

            String bizContent = "netty service receive message success";
            write(ctx, bizContent);

        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    private static void write(ChannelHandlerContext ctx, String bizContent) {
        ByteBuf buffer = Unpooled.copiedBuffer(bizContent, CharsetUtil.UTF_8);
        // 向客户端发送消息
        ctx.write(buffer);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        /* flush：将消息发送队列中的消息写入到 SocketChannel 中发送给对方，为了防止频繁的唤醒 Selector 进行消息发送
         * Netty 的 write 方法并不直接将消息写如 SocketChannel 中，调用 write 只是把待发送的消息放到发送缓存数组中，再通过调用 flush
         * 方法，将发送缓冲区的消息全部写入到 SocketChannel 中
         * */
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        logger.info("NettyDemoServiceHandler occur exception, e: ", cause);
        ctx.close();
    }
}
