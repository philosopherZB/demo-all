package com.philosopherzb.commonutil.util;


import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author philosopherZB
 * @date 2022/1/13
 */
public class GenerateKeyUtils {
    private static KeyPair KEY_PAIR_INSTANCE = null;
    private static String ALGORITHM_RSA = "RSA";
    private static Integer ALGORITHM_RSA_KEY_LENGTH = 2048;
    private static String ALGORITHM_AES = "AES";
    private static Integer ALGORITHM_AES_KEY_LENGTH = 128;

    /**
     * 生成默认公钥--algorithm=RSA; keyLength=2048
     *
     * @return publicKey
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     */
    public static String genDefaultPublicKey() throws NoSuchAlgorithmException {
        return genPublicKey(ALGORITHM_RSA, ALGORITHM_RSA_KEY_LENGTH);

    }

    /**
     * 生成默认私钥--algorithm=RSA; keyLength=2048
     *
     * @return privateKey
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     */
    public static String genDefaultPrivateKey() throws NoSuchAlgorithmException {
        return genPrivateKey(ALGORITHM_RSA, ALGORITHM_RSA_KEY_LENGTH);
    }

    /**
     * @param algorithm 标准的算法名: https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html
     * @param keyLength 指定长度
     * @return publicKey
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     */
    public static String genPublicKey(String algorithm, int keyLength) throws NoSuchAlgorithmException {
        PublicKey publicKey = getKeyPairInstance(algorithm, keyLength).getPublic();
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());

    }

    /**
     * @param algorithm 标准的算法名: https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html
     * @param keyLength 指定长度
     * @return privateKey
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     */
    public static String genPrivateKey(String algorithm, int keyLength) throws NoSuchAlgorithmException {
        PrivateKey privateKey = getKeyPairInstance(algorithm, keyLength).getPrivate();
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }

    /**
     * 生成AES秘钥
     *
     * @return aes秘钥
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     */
    public static String genAesKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM_AES);
        SecureRandom secureRandom = new SecureRandom();
        keyGen.init(ALGORITHM_AES_KEY_LENGTH, secureRandom);
        SecretKey secretKey = keyGen.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    /**
     * getKeyPairInstance
     *
     * @param algorithm 标准的算法名: https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html
     * @param keyLength 指定长度
     * @return KeyPair
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     */
    private static KeyPair getKeyPairInstance(String algorithm, int keyLength) throws NoSuchAlgorithmException {
        if (KEY_PAIR_INSTANCE == null) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
            SecureRandom secureRandom = new SecureRandom();
            keyPairGenerator.initialize(keyLength, secureRandom);
            KEY_PAIR_INSTANCE = keyPairGenerator.generateKeyPair();
        }

        return KEY_PAIR_INSTANCE;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("publicKey: " + genPublicKey("RSA", 2048));
        System.out.println("privateKey: " + genPrivateKey("RSA", 2048));

        System.out.println("default publicKey: " + genDefaultPublicKey());
        System.out.println("default privateKey: " + genDefaultPrivateKey());

        System.out.println("aes key: " + genAesKey());
    }
}
