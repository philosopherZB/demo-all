package com.philosopherzb.nettservice.demo.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * author: philosopherZB
 * date: 2020/5/12
 */
public class NettyDemoClient {
    private static final Logger logger = LoggerFactory.getLogger(NettyDemoClient.class);

    public static void main(String[] args){
        for (int i=0; i<3; i++){
            new Thread(new NettyThread()).start();
        }
    }

    static class NettyThread implements Runnable{

        @Override
        public void run() {
            String host = "127.0.0.1";
            int port = 9098;
            nettyClient(host, port);
        }

        private void nettyClient(String host, int port){
            // Configure the client.
            EventLoopGroup group = new NioEventLoopGroup();
            try {
                // 服务端使用ServerBootstrap
                Bootstrap b = new Bootstrap();
                b.group(group)
                        .channel(NioSocketChannel.class)
                        .handler(new ChannelInitializer<SocketChannel>(){
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                ChannelPipeline p = socketChannel.pipeline();
                                p.addLast(new NettyDemoClientHandler());
                            }
                        });

                // Start the client.
                ChannelFuture f = b.connect(host, port).sync();
                logger.info("netty client started.");

                // Wait until the connection is closed.
                f.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                logger.warn("netty client interrupted, e: ", e);
                e.printStackTrace();
            } finally {
                // 释放资源
                group.shutdownGracefully();
            }
        }
    }
}
