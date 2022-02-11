package com.philosopherzb.secret.sdk;

/**
 * @author philosopherZB
 * @date 2022/1/18
 */
public class SecurityData {

    /**
     * 检索串，一般指phone或id类型的索引列，具体可参考wiki: https://wiki.das-security.cn/pages/viewpage.action?pageId=39587750
     */
    private String indexValue;
    /**
     * 原始base64加密之后的密文数据
     */
    private String encryptValue;
    /**
     * 秘钥版本
     */
    private Long secretVersion;

    public String getIndexValue() {
        return indexValue;
    }

    public void setIndexValue(String indexValue) {
        this.indexValue = indexValue;
    }

    public String getEncryptValue() {
        return encryptValue;
    }

    public void setEncryptValue(String encryptValue) {
        this.encryptValue = encryptValue;
    }

    public Long getSecretVersion() {
        return secretVersion;
    }

    public void setSecretVersion(Long secretVersion) {
        this.secretVersion = secretVersion;
    }
}
