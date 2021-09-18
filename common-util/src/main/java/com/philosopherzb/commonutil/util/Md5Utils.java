package com.philosopherzb.commonutil.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author philosopherZB
 * @date 2021/9/7
 */
@Slf4j
public class Md5Utils {
    /**
     * 默认的密码字符串组合，用来将字节转换成 16 进制表示的字符,apache校验下载的文件的正确性用的就是默认的这个组合
     */
    private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static MessageDigest messagedigest = null;

    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            log.error("init MessageDigest failure, e: ", e);
        }
    }

    /**
     * 生成字符串的md5校验值
     *
     * @param s 字符串
     * @return md5值
     */
    public static String getMD5String(String s) {
        return getByteMD5String(s.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 判断字符串的md5校验码是否与一个已知的md5码相匹配
     *
     * @param password  要校验的字符串
     * @param md5PwdStr 已知的md5校验码
     * @return 校验结果
     */
    public static boolean checkStringMd5(String password, String md5PwdStr) {
        String s = getMD5String(password);
        return s.equals(md5PwdStr);
    }

    /**
     * 判断file的md5校验码是否与一个已知的md5码相匹配
     *
     * @param file      要校验的文件
     * @param md5PwdStr 已知的md5校验码
     * @return 校验结果
     */
    public static boolean checkFileMd5(File file, String md5PwdStr) {
        String s = getFileMD5String(file);
        return s.equals(md5PwdStr);
    }

    /**
     * 判断bytes的md5校验码是否与一个已知的md5码相匹配
     *
     * @param bytes     要校验的bytes
     * @param md5PwdStr 已知的md5校验码
     * @return 校验结果
     */
    public static boolean checkByteMd5(byte[] bytes, String md5PwdStr) {
        String s = getByteMD5String(bytes);
        return s.equals(md5PwdStr);
    }

    /**
     * 生成文件的md5校验值
     *
     * @param file 文件
     * @return md5值
     */
    public static String getFileMD5String(File file) {
        try (InputStream fis = new FileInputStream(file);) {
            byte[] buffer = new byte[(int)file.length()];
            int numRead;
            while ((numRead = fis.read(buffer)) > 0) {
                messagedigest.update(buffer, 0, numRead);
            }
            return bufferToHex(messagedigest.digest());
        } catch (IOException e) {
            log.error("getFileMD5String failure, e: ", e);
            return "";
        }
    }

    /**
     * 加密字节数组
     *
     * @param bytes 字节数组
     * @return md5值
     */
    public static String getByteMD5String(byte[] bytes) {
        messagedigest.update(bytes);
        return bufferToHex(messagedigest.digest());
    }

    /**
     * 字节数组转hex
     *
     * @param bytes 字节数组
     * @return 字符串
     */
    private static String bufferToHex(byte[] bytes) {
        int m = 0;
        int n = bytes.length;
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        // 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移,此处未发现两种符号有何不同
        char c0 = hexDigits[(bt & 0xf0) >> 4];
        // 取字节中低 4 位的数字转换
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

    public static void main(String[] args) {
        File file = new File("D://temp/1.txt");
        if (!file.exists()) {
            log.error("file not exist");
        }
        String md5 = getFileMD5String(file);

//        String md5 = getMD5String("a");

        if (StringUtils.isEmpty(md5)) {
            log.error("file md5 encrypt failure");
        }
        System.out.println("md5: " + md5);
        System.out.println(checkFileMd5(file, "b59c67bf196a4758191e42f76670ceba"));
    }
}

