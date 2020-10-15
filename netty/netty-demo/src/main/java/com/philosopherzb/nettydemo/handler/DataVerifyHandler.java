package com.philosopherzb.nettydemo.handler;

import com.philosopherzb.nettydemo.protobuf.IBusCloudSDKProto;
import com.philosopherzb.nettydemo.response.NettyResponseCode;
import com.philosopherzb.nettydemo.util.HexDump;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * author: philosopherZB
 * date: 2020/8/14
 */
@Slf4j
@ChannelHandler.Sharable
public class DataVerifyHandler extends ChannelInboundHandlerAdapter {
    private static final int VERIFY_LEN = 16;

    private static final int BODY_OFFSET = 4;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        IBusCloudSDKProto.OnlineVerifyResponse.Builder builder = IBusCloudSDKProto.OnlineVerifyResponse.newBuilder();
        if (msg instanceof ByteBuf) {
            try {
                ByteBuf buf = (ByteBuf) msg;
                byte[] heapBuf;
                if (!buf.hasArray()) {
                    heapBuf = new byte[buf.readableBytes()];
                    buf.getBytes(buf.readerIndex(), heapBuf);
                } else {
                    heapBuf = buf.array();
                }
                // 获取数据中的校验消息和校验体
                byte[] message = Arrays.copyOfRange(heapBuf, 0, heapBuf.length - VERIFY_LEN);
                byte[] md5 = Arrays.copyOfRange(heapBuf, heapBuf.length - VERIFY_LEN, heapBuf.length);
                String verifyData = new String(md5, StandardCharsets.ISO_8859_1);
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                // 获取用于校验数据的字节流
                byte[] digest = Arrays.copyOfRange(messageDigest.digest(message), 4, 12);
                String calcVerifyData = HexDump.toHexString(digest);
                if (!verifyData.equalsIgnoreCase(calcVerifyData)) {
                    // 校验失败
                    log.info("verify failed, send verify: {}, calc verify: {}", verifyData, calcVerifyData);
                    builder.setRespCode(NettyResponseCode.CHECK_SIGNATURE_FAILED.getCode());
                    builder.setRespMsg(NettyResponseCode.CHECK_SIGNATURE_FAILED.getMsg());
                    ctx.writeAndFlush(builder.build());
                } else {
                    // 转发数据到下一个节点
                    ByteBuf nextMsg = buf.copy(BODY_OFFSET, heapBuf.length - VERIFY_LEN - BODY_OFFSET);
                    ctx.fireChannelRead(nextMsg);
                }
                return;
            } catch (Exception e) {
                log.warn("verify data exception: ", e);
            } finally {
                ReferenceCountUtil.release(msg);
            }
        }
        builder.setRespCode(NettyResponseCode.SYSTEM_ERROR.getCode());
        builder.setRespMsg(NettyResponseCode.SYSTEM_ERROR.getMsg());
        ctx.writeAndFlush(builder.build());
    }
}
