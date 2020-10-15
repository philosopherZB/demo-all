package com.philosopherzb.nettydemo.handler;

import com.alibaba.fastjson.JSONObject;
import com.philosopherzb.nettydemo.protobuf.IBusCloudSDKProto;
import com.philosopherzb.nettydemo.request.NettyRequest;
import com.philosopherzb.nettydemo.response.NettyResponseCode;
import com.philosopherzb.nettydemo.util.Constants;
import com.philosopherzb.nettydemo.util.HexDump;
import com.philosopherzb.nettydemo.util.HttpClientUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Base64;

/**
 * author: philosopherZB
 * date: 2020/8/11
 */
@Slf4j
public class BizHandler extends ChannelInboundHandlerAdapter {

    private String apiUrl;

    public BizHandler(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        IBusCloudSDKProto.OnlineVerifyResponse.Builder builder = IBusCloudSDKProto.OnlineVerifyResponse.newBuilder();
        try {
            ByteBuf buf = (ByteBuf) msg;
            byte[] heapBuf;
            if (!buf.hasArray()) {
                heapBuf = new byte[buf.readableBytes()];
                buf.getBytes(buf.readerIndex(), heapBuf);
            } else {
                heapBuf = buf.array();
            }

            String message = HexDump.toHexString(heapBuf);
            log.info("The netty server receive message:{}", message);
            byte[] data = Arrays.copyOfRange(heapBuf, 1, heapBuf.length);

            NettyRequest nettyRequest = new NettyRequest();
            String encryptData = Base64.getEncoder().encodeToString(data);
            nettyRequest.setEncryptData(encryptData);
            String param = JSONObject.toJSONString(nettyRequest);
            callApi(apiUrl, param, builder);
        } catch (Exception e) {
            log.error("BizHandler handle data exception: ", e);
            builder.setRespCode(NettyResponseCode.SYSTEM_ERROR.getCode());
            builder.setRespMsg(NettyResponseCode.SYSTEM_ERROR.getMsg());
        } finally {
            ReferenceCountUtil.release(msg);
        }
        ctx.writeAndFlush(builder.build());
    }

    /**
     * 调用接口
     *
     * @param url     接口地址
     * @param params  请求参数
     * @param builder 赋值对象
     * @throws Exception 业务异常
     */
    private void callApi(String url, String params, IBusCloudSDKProto.OnlineVerifyResponse.Builder builder) throws Exception {
        log.info("BizHandler.callApi, requestUrl:{}, requestParam:{}", url, params);

        String responseStr = HttpClientUtil.sendHttpsRequest(url, Constants.HTTP_REQUEST_METHOD_POST, Constants.HTTP_CONTENT_TYPE_JSON, Constants.UTF8, null, params);
        log.info("BizHandler.callApi, requestUrl={}, result:{}", url, responseStr);
        JSONObject jo = JSONObject.parseObject(responseStr);
        if (NettyResponseCode.SUCCESS.getCode().equals(jo.getInteger(Constants.CODE))) {
            log.info("call api success.");
            builder.setRespCode(NettyResponseCode.SUCCESS.getCode());
            builder.setRespMsg(NettyResponseCode.SUCCESS.getMsg());
        } else {
            log.warn("call api fail, message:{}", jo.getString(Constants.MESSAGE));
            builder.setRespCode(NettyResponseCode.CHECK_QR_CODE_FAIL_ON_LINE.getCode());
            builder.setRespMsg(NettyResponseCode.CHECK_QR_CODE_FAIL_ON_LINE.getMsg());
        }
    }
}
