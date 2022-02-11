package com.philosopherzb.secret.sdk;

/**
 * @author philosopherZB
 * @date 2022/1/18
 */
public class SecurityContext {
    private byte[] secret;
    private Long secretVersion;
    /**
     * 过期时间，单位（毫秒）
     */
    private long invalidTime;
    /**
     * 最长有效期，单位（毫秒），此值大于invalidTime
     */
    private long maxInvalidTime;
    /**
     * 滑动窗口大小
     */
    private Integer encryptSlideSize;
    /**
     * 密文滑窗压缩长度
     */
    private Integer encryptIndexCompressLen;

    /**
     * @return 是否过期
     */
    public boolean isValid() {
        return invalidTime > System.currentTimeMillis();
    }

    /**
     * 容灾，调用api获取秘钥可能会失败，在失败情况下最长有效期
     *
     * @return 是否在最大有效期内
     */
    public boolean isMaxValid() {
        return maxInvalidTime > System.currentTimeMillis();
    }

    public byte[] getSecret() {
        return secret;
    }

    public void setSecret(byte[] secret) {
        this.secret = secret;
    }

    public Long getSecretVersion() {
        return secretVersion;
    }

    public void setSecretVersion(Long secretVersion) {
        this.secretVersion = secretVersion;
    }

    public long getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(long invalidTime) {
        this.invalidTime = invalidTime;
    }

    public long getMaxInvalidTime() {
        return maxInvalidTime;
    }

    public void setMaxInvalidTime(long maxInvalidTime) {
        this.maxInvalidTime = maxInvalidTime;
    }

    public Integer getEncryptSlideSize() {
        return encryptSlideSize;
    }

    public void setEncryptSlideSize(Integer encryptSlideSize) {
        this.encryptSlideSize = encryptSlideSize;
    }

    public Integer getEncryptIndexCompressLen() {
        return encryptIndexCompressLen;
    }

    public void setEncryptIndexCompressLen(Integer encryptIndexCompressLen) {
        this.encryptIndexCompressLen = encryptIndexCompressLen;
    }
}
