package com.philosopherzb.secret.sdk;

import java.util.List;
import java.util.Map;

/**
 * @author philosopherZB
 * @date 2022/1/17
 */
public interface SecurityClient {

    /**
     * 是否为密文
     *
     * @param data 加密数据
     * @param type 加密类型 ---> SecurityConstants
     * @return 是否加密数据
     * @throws DasSecurityException DasSecurityException
     */
    boolean isEncryptData(String data, String type) throws DasSecurityException;

    /**
     * 判断list元素是否全部为密文数据
     *
     * @param dataList 加密数据
     * @param type     加密类型 ---> SecurityConstants
     * @return 是否加密数据
     * @throws DasSecurityException DasSecurityException
     */
    boolean isEncryptDataForList(List<String> dataList, String type) throws DasSecurityException;

    /**
     * 判断list元素是否存在密文数据。只要有一个是密文，则返回true
     *
     * @param dataList 加密数据
     * @param type     加密类型 ---> SecurityConstants
     * @return 是否加密数据
     * @throws DasSecurityException DasSecurityException
     */
    boolean isEitherEncryptDataForList(List<String> dataList, String type) throws DasSecurityException;

    /**
     * 加密敏感数据
     *
     * @param data    待加密数据
     * @param type    加密类型 ---> SecurityConstants
     * @param version 秘钥版本号
     * @return 加密后的数据，数据格式可参考wiki文档: https://wiki.das-security.cn/pages/viewpage.action?pageId=39587750
     * @throws DasSecurityException DasSecurityException
     */
    String encrypt(String data, String type, Long version) throws DasSecurityException;

    /**
     * 批量加密敏感数据
     *
     * @param dataList 待加密数据
     * @param type     加密类型 ---> SecurityConstants
     * @param version  秘钥版本号
     * @return 加密后的数据，数据格式可参考wiki文档: https://wiki.das-security.cn/pages/viewpage.action?pageId=39587750
     * @throws DasSecurityException DasSecurityException
     */
    Map<String, String> encryptForBatch(List<String> dataList, String type, Long version) throws DasSecurityException;

    /**
     * 解密敏感数据
     *
     * @param data    待解密数据
     * @param type    解密类型 ---> SecurityConstants
     * @param version 秘钥版本号
     * @return 解密后的数据，数据格式可参考wiki文档: https://wiki.das-security.cn/pages/viewpage.action?pageId=39587750
     * @throws DasSecurityException DasSecurityException
     */
    String decrypt(String data, String type, Long version) throws DasSecurityException;

    /**
     * 批量解密敏感数据
     *
     * @param dataList 待解密数据
     * @param type     解密类型 ---> SecurityConstants
     * @param version  秘钥版本号
     * @return 解密后的数据，数据格式可参考wiki文档: https://wiki.das-security.cn/pages/viewpage.action?pageId=39587750
     * @throws DasSecurityException DasSecurityException
     */
    Map<String, String> decryptForBatch(List<String> dataList, String type, Long version) throws DasSecurityException;

    /**
     * 获取检索串密文
     *
     * @param data    待加密数据
     * @param type    加密类型 ---> SecurityConstants
     * @param version 秘钥版本号
     * @return 加密后的数据，数据格式可参考wiki文档: https://wiki.das-security.cn/pages/viewpage.action?pageId=39587750
     * @throws DasSecurityException DasSecurityException
     */
    String search(String data, String type, Long version) throws DasSecurityException;
}
