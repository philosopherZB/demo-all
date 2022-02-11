package com.philosopherzb.secret.sdk.util;


import com.philosopherzb.secret.sdk.DasSecurityException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author philosopherZB
 * @date 2022/1/18
 */
public class DasUtils {
    private static final byte[] IV_BYTES = "0102030405060708".getBytes();
    private static final String AES = "AES";
    private static final String MAC_HMAC_MD5 = "HmacMD5";
    private static String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    /**
     * 加密算法RSA
     */
    private static final String KEY_ALGORITHM = "RSA";

    /**
     * 签名算法
     */
    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";

    /**
     * 用私钥对信息生成数字签名
     *
     * @param content    待加签报文
     * @param privateKey 私钥(BASE64编码)
     * @return 加签结果
     * @throws DasSecurityException DasDasSecurityException
     */
    public static String rsaSign(String content, String privateKey) throws DasSecurityException {
        try {
            byte[] data = content.getBytes(StandardCharsets.UTF_8);
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initSign(str2PrivateKey(privateKey));
            signature.update(data);
            return Base64.getEncoder().encodeToString(signature.sign());
        } catch (Exception e) {
            throw new DasSecurityException(e);
        }
    }

    /**
     * 校验数字签名
     *
     * @param content   待验签报文
     * @param publicKey 公钥(BASE64编码)
     * @param sign      数字签名
     * @return 验签结果
     * @throws DasSecurityException DasDasSecurityException
     */
    public static boolean rsaVerify(String content, String publicKey, String sign) throws DasSecurityException {
        try {
            byte[] data = content.getBytes(StandardCharsets.UTF_8);
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(str2PublicKey(publicKey));
            signature.update(data);
            return signature.verify(Base64.getDecoder().decode(sign));
        } catch (Exception e) {
            throw new DasSecurityException(e);
        }
    }

    /**
     * RSA加密
     *
     * @param data      待加密数据
     * @param publicKey 公钥
     * @return 加密数据
     * @throws DasSecurityException DasDasSecurityException
     */
    public static String rsaEncrypt(String data, String publicKey) throws DasSecurityException {
        try {
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, str2PublicKey(publicKey));
            byte[] encryptedMessage = cipher.doFinal(Base64.getDecoder().decode(data));
            return Base64.getEncoder().encodeToString(encryptedMessage);
        } catch (Exception e) {
            throw new DasSecurityException(e);
        }
    }

    /**
     * RSA解密
     *
     * @param data       待解密数据
     * @param privateKey 私钥
     * @return 解密数据
     * @throws DasSecurityException DasDasSecurityException
     */
    public static String rsaDecrypt(String data, String privateKey) throws DasSecurityException {
        try {
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, str2PrivateKey(privateKey));
            byte[] decryptedMessage = cipher.doFinal(Base64.getDecoder().decode(data));
            return Base64.getEncoder().encodeToString(decryptedMessage);
        } catch (Exception e) {
            throw new DasSecurityException(e);
        }
    }

    /**
     * AES加密
     *
     * @param content    待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密数据
     * @throws DasSecurityException DasDasSecurityException
     */
    public static String aesEncrypt(String content, byte[] encryptKey) throws DasSecurityException {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance(AES);
            kgen.init(new SecureRandom(encryptKey));

            IvParameterSpec iv = new IvParameterSpec(IV_BYTES);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey, AES), iv);

            byte[] result = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(result);
        } catch (Exception e) {
            throw new DasSecurityException(e);
        }
    }

    /**
     * AES解密
     *
     * @param encryptContent 待解密的数据
     * @param decryptKey     解密密钥
     * @return 解密数据
     * @throws DasSecurityException DasDasSecurityException
     */
    public static String aesDecrypt(String encryptContent, byte[] decryptKey) throws DasSecurityException {
        IvParameterSpec iv = new IvParameterSpec(IV_BYTES);
        Cipher cipher;
        try {
            cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey, AES), iv);
            byte[] result = cipher.doFinal(Base64.getDecoder().decode(encryptContent.getBytes(StandardCharsets.UTF_8)));
            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new DasSecurityException(e);
        }
    }

    /**
     * h-mac加密，支持压缩
     *
     * @param encryptText 加密文本
     * @param encryptKey  秘钥
     * @param compressLen 压缩长度
     * @return 加密数据
     * @throws DasSecurityException DasDasSecurityException
     */
    public static String hmacMD5EncryptToBase64(String encryptText, byte[] encryptKey, int compressLen) throws DasSecurityException {
        try {
            return Base64.getEncoder().encodeToString(compress(hmacMD5Encrypt(encryptText, encryptKey), compressLen));
        } catch (Exception e) {
            throw new DasSecurityException(e);
        }
    }

    /**
     * h-mac加密
     *
     * @param encryptText 加密文本
     * @param encryptKey  秘钥
     * @return 加密数据
     * @throws DasSecurityException DasDasSecurityException
     */
    public static String hmacMD5EncryptToBase64(String encryptText, byte[] encryptKey) throws DasSecurityException {
        try {
            return Base64.getEncoder().encodeToString(hmacMD5Encrypt(encryptText, encryptKey));
        } catch (Exception e) {
            throw new DasSecurityException(e);
        }
    }

    /**
     * 获取滑动窗口数组
     *
     * @param input     输入数据
     * @param slideSize 滑动尺寸
     * @return 滑动数组
     */
    public static List<String> getSlideWindows(String input, int slideSize) {
        List<String> windows = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 0;
        int currentWindowSize = 0;
        String currentWindow = null;

        while (endIndex < input.length() || currentWindowSize > slideSize) {
            boolean startsWithLetterOrDigit;
            if (currentWindow == null) {
                startsWithLetterOrDigit = false;
            } else {
                startsWithLetterOrDigit = isAscii(currentWindow.charAt(0));
            }

            if (endIndex == input.length() && !startsWithLetterOrDigit) {
                break;
            }
            // ascii占一个字符，其余占两个字符
            if (endIndex != 0) {
                if (startsWithLetterOrDigit) {
                    currentWindowSize -= 1;
                } else {
                    currentWindowSize -= 2;
                }
                startIndex++;
            }

            while (currentWindowSize < slideSize && endIndex < input.length()) {
                char currentChar = input.charAt(endIndex);
                if (isAscii(currentChar)) {
                    currentWindowSize += 1;
                } else {
                    currentWindowSize += 2;
                }
                endIndex++;
            }
            currentWindow = input.substring(startIndex, endIndex);
            windows.add(currentWindow);
        }
        return windows;
    }

    /**
     * 获取本机的局域网IP。
     */
    public static String getIntranetIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            return "127.0.0.1";
        }
    }

    /**
     * 使用 HMAC-MD5 签名方法对对encryptText进行签名
     *
     * @param encryptText 加密文本
     * @param encryptKey  秘钥
     * @return 加密数据
     * @throws Exception Exception
     */
    private static byte[] hmacMD5Encrypt(String encryptText, byte[] encryptKey) throws Exception {
        // 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(encryptKey, MAC_HMAC_MD5);
        // 生成一个指定 Mac 算法 的 Mac 对象
        Mac mac = Mac.getInstance(MAC_HMAC_MD5);
        // 用给定密钥初始化 Mac 对象
        mac.init(secretKey);

        byte[] text = encryptText.getBytes(StandardCharsets.UTF_8);
        // 完成 Mac 操作
        return mac.doFinal(text);
    }

    private static byte[] compress(byte[] input, int toLength) {
        if (toLength < 0) {
            return null;
        }
        byte[] output = new byte[toLength];
        for (int i = 0; i < output.length; i++) {
            output[i] = 0;
        }

        for (int i = 0; i < input.length; i++) {
            int index_output = i % toLength;
            output[index_output] ^= input[i];
        }

        return output;
    }

    private static boolean isAscii(char x) {
        return x <= 127;
    }

    private static PublicKey str2PublicKey(String publicKey)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = Base64.getDecoder().decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        return keyFactory.generatePublic(keySpec);
    }

    private static PrivateKey str2PrivateKey(String privateKey)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = Base64.getDecoder().decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        return keyFactory.generatePrivate(pkcs8KeySpec);
    }

}
