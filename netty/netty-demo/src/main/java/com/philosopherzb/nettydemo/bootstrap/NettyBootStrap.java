package com.philosopherzb.nettydemo.bootstrap;

import com.philosopherzb.nettydemo.handler.AcceptorIdleStateTrigger;
import com.philosopherzb.nettydemo.handler.BizHandler;
import com.philosopherzb.nettydemo.handler.DataResponseHandler;
import com.philosopherzb.nettydemo.handler.DataVerifyHandler;
import com.philosopherzb.nettydemo.util.NettyThreadFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * netty启动类
 * author: philosopherZB
 * date: 2020/8/11
 */
@Slf4j
@Service
public class NettyBootStrap {
    // 心跳检测对应的时间, 此时间请不要随意更改（不要低于35）
    private static final long READER_IDLE_TIME = 35;
    private static final long WRITER_IDLE_TIME = 0;
    private static final long ALL_IDLE_TIME = 0;

    /**
     * 端口
     */
    private static final Integer PORT = 12004;

    /**
     * shutdown等待时间，秒
     */
    private static final Integer SHUTDOWN_WAIT_SECOND = 10;

    @Getter
    @Value("${apiUrl}")
    private String apiUrl;

    /**
     * netty 主线程
     */
    private ExecutorService executorService;

    /**
     * 初始化Netty
     */
    @PostConstruct
    void init() {
        executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), new NettyThreadFactory("netty boot strap"));
        executorService.submit(new NettyBootStrapTask(this));
    }

    @PreDestroy
    void destroy() throws InterruptedException {
        executorService.shutdownNow();
        executorService.awaitTermination(SHUTDOWN_WAIT_SECOND, TimeUnit.SECONDS);
    }

    static class NettyBootStrapTask implements Runnable {

        private final AcceptorIdleStateTrigger acceptorIdleStateTrigger = new AcceptorIdleStateTrigger();
        /**
         * 持有启动管理类的引用，便于获取netty的参数
         */
        private NettyBootStrap nettyBootStrap;

        NettyBootStrapTask(NettyBootStrap nettyBootStrap) {
            this.nettyBootStrap = nettyBootStrap;
        }

        @Override
        public void run() {
            // Netty的Boos节点，用于接收与处理Tcp连接
            EventLoopGroup bossGroup = new NioEventLoopGroup();
            // Netty的工作节点，用于处理实际的业务
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            try {
                ServerBootstrap b = new ServerBootstrap();
                b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ChannelPipeline p = ch.pipeline();
                                // 心跳检测, 统计连接数
                                p.addLast(new IdleStateHandler(READER_IDLE_TIME, WRITER_IDLE_TIME, ALL_IDLE_TIME, TimeUnit.SECONDS));
                                p.addLast(acceptorIdleStateTrigger);
                                p.addLast(new DataResponseHandler());
                                p.addLast(new LengthFieldBasedFrameDecoder(2048, 2, 2));
                                p.addLast(new DataVerifyHandler());
                                p.addLast(new BizHandler(nettyBootStrap.getApiUrl()));
                            }
                        });

                // tcp
                b.option(ChannelOption.SO_BACKLOG, 2048);

                // start netty
                ChannelFuture future = b.bind(PORT).sync();
                log.info("netty started.");
                future.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                log.warn("netty interrupted.");
            } finally {
                bossGroup.shutdownGracefully();
                workerGroup.shutdownGracefully();
                log.info("netty shutdown gracefully");
            }
        }
    }


}
