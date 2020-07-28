package com.philosopherzb.commonutil.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * author: philosopherZB
 * date: 2020/6/29
 */
@Slf4j
public class AesUtil {


    private static String CHAR_SET = "UTF-8";
    private static String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static String ALGORITHM = "AES";


    /**
     * AES加密
     *
     * @param content 待加密内容
     * @param key     加密秘钥
     * @return 加密结果
     */
    public static String encrypt(String content, String key) {
        try {
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            byte[] byteContent = content.getBytes(CHAR_SET);
            // 初始化
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            byte[] result = cipher.doFinal(byteContent);
            // 加密
            return Base64.encodeBase64String(result);
        } catch (Exception e) {
            log.error("encrypt error:{}", e);
        }
        return null;
    }

    /**
     * AES解密
     *
     * @param content 待解密内容
     * @param key     解密密钥
     * @return 解密结果
     */
    public static String decrypt(String content, String key) {
        try {
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, skey);
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));
            // 解密
            return new String(result, CHAR_SET);
        } catch (Exception e) {
            log.error("decrypt error:{}", e);
        }
        return null;
    }

    public static void main(String[] args){
        System.out.println(encrypt("13011112222", "sa7aUdPr78xmX4pK"));
        System.out.println(decrypt("dwfGeUwZmjqaNDG7lf5gtg==", "sa7aUdPr78xmX4pK"));
    }
}
