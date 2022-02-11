package com.philosopherzb.secret.service.common.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Map;
import java.util.TreeMap;

/**
 * author: philosopherZB
 * date: 2020/12/8
 */
public class RSAUtils {

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
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     * @throws InvalidKeySpecException  InvalidKeySpecException
     * @throws InvalidKeyException      InvalidKeyException
     * @throws SignatureException       SignatureException
     */
    public static String sign(String content, String privateKey)
            throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        byte[] data = content.getBytes(StandardCharsets.UTF_8);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(str2PrivateKey(privateKey));
        signature.update(data);
        return Base64.getEncoder().encodeToString(signature.sign());
    }

    /**
     * 校验数字签名
     *
     * @param content   待验签报文
     * @param publicKey 公钥(BASE64编码)
     * @param sign      数字签名
     * @return 验签结果
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     * @throws InvalidKeySpecException  InvalidKeySpecException
     * @throws InvalidKeyException      InvalidKeyException
     * @throws SignatureException       SignatureException
     */
    public static boolean verify(String content, String publicKey, String sign)
            throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        byte[] data = content.getBytes(StandardCharsets.UTF_8);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(str2PublicKey(publicKey));
        signature.update(data);
        return signature.verify(Base64.getDecoder().decode(sign));
    }

    /**
     * RSA加密
     *
     * @param data      待加密数据
     * @param publicKey 公钥
     * @return 加密数据
     */
    public static String encrypt(String data, String publicKey)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, str2PublicKey(publicKey));
        byte[] encryptedMessage = cipher.doFinal(Base64.getDecoder().decode(data));
        return Base64.getEncoder().encodeToString(encryptedMessage);
    }

    /**
     * RSA解密
     *
     * @param data       待解密数据
     * @param privateKey 私钥
     * @return 解密数据
     */
    public static String decrypt(String data, String privateKey)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, str2PrivateKey(privateKey));
        byte[] decryptedMessage = cipher.doFinal(Base64.getDecoder().decode(data));
        return Base64.getEncoder().encodeToString(decryptedMessage);
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


    public static void main(String[] args) throws Exception {

        Map<String, String> map = new TreeMap<>();
        map.put("app_id", "Test0001");
        map.put("order_no", "20201214498352115335884800");
        System.out.println(map.toString());
        String str = map.toString();

        String priKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQChiNX7vVbE9r6fMFrFV7eSVBhSeniBAmNDWoaADv2Zk+viR5BBTl92fAdvyk6VWZWcmbykogRZf1ERV7pcLm5l/uakhWJ6gvIR6bWqEpOp28+sXvO3gd3OqlF+tH3/epjnbSFvXbSnvMNZcwDvOm888Lmbv3r4dhk2iH9rFRK7Ou40PNXi4PFKz44b168M30D79aZ6OkhtE2k9MlXIYLHBfqdQY3Pu81VDHHMMJE5WmZFjKiqwPRMVdE6sD9xTcvPWuH7UVdNdekKRPvsFP1SFdm3n5PjDDGO4Ec6VXKv2AvCvq2Rnzw89qO8AymfVq4y/uqkhAq4AGNNrnV4aEdSnAgMBAAECggEANPGMcP4VumjFAZfvqE6ftC4r6pyJcn892Y2KF97R78wzu+6IsV7mmwb7yQAd0YWTK8iXs74Gfu7juzNtuVjehj+NiM7PACh6/rQC/sMn8rxAzNYyOystb9cS7txpj5q3EuMJ2l50H6YWwPKYk9ArNWYQ76NKwrSyftUuLgKyKPsZG/7pphggmXU5kGxJngkR95Kcw8qH0hAYgbkaxU+0wtbQYha5E9wExhK+Tb4ydkx9GWK9QcWPXzIvNPEOti3lHyz9CEa0JPGuoTnc97UnA9n+N9va9jHc/LpWVMNrUA9wbjPN56mzs7BELAU2ZFf+oe4V9rhIxMIuWCvK326dwQKBgQDpGAcwH8ogDqvkbx+H6ytAvg8zCGMcZksAmargudI+fMqCVyeewJUr4lw+BuZ2RWXSTY2eKnj5dBXyLpCl7slsZY8OtwtIJqRbniE4K40eaGcxQGyUmBv1F5NIrGzKqx27X4xC7po52zIScOSop2MYHCi2hhnzF4bk1qu5E+EzDQKBgQCxaJSLGe1DP4CWcXDPk+TROrMCMccEBbwsjNFkGrskY1ys1CfFzMUH4xeuY2NoRRUBR2IecPKE7nvXfru2czHtft3Hk/NYo10O3UbH4om0h0LjlJE+GdCk/XaSsmENlhbgfAZjOEgNktod6tbwjPq24WR4OIjR048hRu049d5JgwKBgHXC8+62QNHNV76C/bUXdLSy0M8Bj8ELVR0qhZAfkT6MoWsUSSoFNdgD9oJHzis2iGilUcT0xEWTBntiVyXd69ldvda7V3HOQ/8ddr8AEb2pFWlmmPTBnG5IyNpQcm454T2G2j/+d+B/A18ZtgwW9RN7Nn5wZa/Q1Q/L/Nn2VzIJAoGBAInBpD6TBkpGoAmx0qBMvcu94cxdbKTx8xlAy0MJArIRuZ+2KaANDh2+t9/A6yrHIbVZgZYTrC2OpXlCvm3A6074SSw09SupxpPJPLHvdXBJ66Wd8l4fW4USD6V/f582IVN02tzmkgSAOIAsn3QwdGnXgNVdSNhth2GWmpO1T0MTAoGBAKeevI4AQYSDp/QotW6KNkNf7XR2/FrLZOZELdrMcVvpkb0jru4/oL6a/CJnknFcmPAwXPAcaB+zldoo7c0z59e+Y7JiFhdpHVDTY1tVZW4WVZvRkbDv5yl9oVIdbk7RrFHGlY66R8+xSLqBcy75vxGz5KJf3pJRqSZcvhrr0nPD";

        String pubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoYjV+71WxPa+nzBaxVe3klQYUnp4gQJjQ1qGgA79mZPr4keQQU5fdnwHb8pOlVmVnJm8pKIEWX9REVe6XC5uZf7mpIVieoLyEem1qhKTqdvPrF7zt4HdzqpRfrR9/3qY520hb120p7zDWXMA7zpvPPC5m796+HYZNoh/axUSuzruNDzV4uDxSs+OG9evDN9A+/WmejpIbRNpPTJVyGCxwX6nUGNz7vNVQxxzDCROVpmRYyoqsD0TFXROrA/cU3Lz1rh+1FXTXXpCkT77BT9UhXZt5+T4wwxjuBHOlVyr9gLwr6tkZ88PPajvAMpn1auMv7qpIQKuABjTa51eGhHUpwIDAQAB";

        System.out.println(sign(str, priKey));
        System.out.println(verify(str, pubKey, sign(str, priKey)));

        String data = "yVcgy1MJ1JSqkRAV1IqLWw==";
        System.out.println("encrypt: " + encrypt(data, pubKey));
        System.out.println("decrypt: " + decrypt(encrypt(data, pubKey), priKey));
    }

}
