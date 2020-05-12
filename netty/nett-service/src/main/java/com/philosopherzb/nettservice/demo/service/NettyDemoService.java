package com.philosopherzb.nettservice.demo.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * netty用户指南：https://netty.io/wiki/user-guide-for-4.x.html
 * github地址: https://github.com/netty/netty
 * author: philosopherZB
 * date: 2020/5/12
 */
public class NettyDemoService {
    private static final Logger logger = LoggerFactory.getLogger(NettyDemoService.class);

    public static void main(String[] args){
        int port = 9098;
        new NettyDemoService().nettyService(port);
    }

    private void nettyService(int port){

        // 配置服务端的 NIO 线程池,用于网络事件处理，实质上他们就是 Reactor 线程组
        // bossGroup 用于服务端接受客户端连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // workerGroup 用于进行 SocketChannel 网络读写, 处理实际的业务
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 服务端使用ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChildChannelHandler());

            // Start the netty server.
            ChannelFuture future = b.bind(port).sync();
            logger.info("netty service started.");

            // Wait until the server socket is closed.
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            logger.warn("netty service interrupted, e: ", e);
            e.printStackTrace();
        } finally {
            // 释放资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            ChannelPipeline p = socketChannel.pipeline();
            p.addLast(new NettyDemoServiceHandler());
        }
    }

}
