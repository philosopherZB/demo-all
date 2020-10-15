package com.philosopherzb.nettydemo.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * author: philosopherZB
 * date: 2020/5/21
 */
public class MakeFrameUtil {

    /**
     * 固定头
     */
    private static final byte[] FIXED_HEADER = {(byte) 0x98, (byte) 0x98};

    private static final int COMMAND_OFFSET = 4;

    private static final int BODY_OFFSET = 5;

    private static final int VERIFY_LEN = 16;

    private static final String MESSAGE_DIGEST = "MD5";

    public static ByteBuf makeFrame(byte command, byte[] body) {
        try {
            int length = body.length + 1 + VERIFY_LEN;
            byte[] message = new byte[BODY_OFFSET + body.length];
            ByteBuf buf = Unpooled.buffer(COMMAND_OFFSET + length);
            buf.writeBytes(FIXED_HEADER);
            buf.writeShort(length);
            buf.writeByte(command);
            buf.writeBytes(body);
            buf.getBytes(0, message, 0, message.length);
            MessageDigest messageDigest = MessageDigest.getInstance(MESSAGE_DIGEST);
            // 获取用于校验数据的字节流
            byte[] digest = Arrays.copyOfRange(messageDigest.digest(message), 4, 12);
            String verifyString = HexDump.toHexString(digest);
            buf.writeBytes(verifyString.getBytes(StandardCharsets.ISO_8859_1));
            return buf;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("get md5 instance failed!");
        }

    }
}
