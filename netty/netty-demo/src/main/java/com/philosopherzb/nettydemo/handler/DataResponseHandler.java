package com.philosopherzb.nettydemo.handler;

import com.philosopherzb.nettydemo.protobuf.IBusCloudSDKProto;
import com.philosopherzb.nettydemo.response.NettyResponseCode;
import com.philosopherzb.nettydemo.util.MakeFrameUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import lombok.extern.slf4j.Slf4j;

/**
 * 处理返回消息
 * author: philosopherZB
 * date: 2020/8/11
 */
@Slf4j
@ChannelHandler.Sharable
public class DataResponseHandler extends ChannelOutboundHandlerAdapter {

    private static final IBusCloudSDKProto.OnlineVerifyResponse ERROR_RESPONSE;

    static {
        IBusCloudSDKProto.OnlineVerifyResponse.Builder builder = IBusCloudSDKProto.OnlineVerifyResponse.newBuilder();
        builder.setRespCode(NettyResponseCode.SYSTEM_ERROR.getCode());
        builder.setRespMsg(NettyResponseCode.SYSTEM_ERROR.getMsg());
        ERROR_RESPONSE = builder.build();
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (msg instanceof IBusCloudSDKProto.OnlineVerifyResponse) {
            IBusCloudSDKProto.OnlineVerifyResponse responseObject = (IBusCloudSDKProto.OnlineVerifyResponse) msg;
            ctx.writeAndFlush(MakeFrameUtil.makeFrame((byte) 0x01, responseObject.toByteArray()));
        } else if (msg instanceof ByteBuf) {
            log.error("resp direct byte buffer content.");
            ctx.writeAndFlush(msg);
        } else {
            ByteBuf errorMessage = Unpooled.buffer(ERROR_RESPONSE.getSerializedSize());
            errorMessage.writeBytes(ERROR_RESPONSE.toByteArray());
            ctx.writeAndFlush(errorMessage);
        }

    }
}
