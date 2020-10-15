package com.philosopherzb.nettydemo.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 心跳检测, 统计连接数
 * author: philosopherZB
 * date: 2020/5/8
 */
@Slf4j
@ChannelHandler.Sharable
public class AcceptorIdleStateTrigger extends ChannelInboundHandlerAdapter {

    private AtomicInteger nConnection = new AtomicInteger();

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            // IdleState.READER_IDLE 表示 如果客户端没有在规定的时间内给你发送消息，服务端就会认为这个客户端宕掉了，关闭这个链接
            if (event.state() == IdleState.READER_IDLE) {
                log.info("No message sent within the specified time, Close inactive channel");
                ctx.channel().close();
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    /**
     * 每次过来一个新连接就对连接数加一
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        nConnection.incrementAndGet();
        int value = 60000;
        if (nConnection.get() > value) {
            log.error("ConnectionCountHandler current connection count:{} ", nConnection.get());
        }
    }

    /**
     * 端口断开连接的时候减一
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        nConnection.decrementAndGet();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        log.warn("AcceptorIdleStateTrigger occur exception, e:{}", cause);
        ctx.close();
    }

}
