package com.philosopherzb.secret.service.service;

import com.philosopherzb.secret.service.gateway.request.SecurityRequest;
import com.philosopherzb.secret.service.gateway.vo.RsaVO;
import com.philosopherzb.secret.service.gateway.vo.SecurityVO;

/**
 * 用于管理AES RSA秘钥
 *
 * @author philosopherZB
 * @date 2022/1/20
 */
public interface SecretService {

    /**
     * 通过appId查询rsa信息，用于验签等操作
     *
     * @param appId appId
     * @return rsa 信息
     */
    RsaVO getByAppId(String appId);

    /**
     * 获取aes秘钥信息
     *
     * @param appId           appId
     * @param securityRequest securityRequest
     * @return aes 信息
     */
    SecurityVO getSecurity(String appId, SecurityRequest securityRequest);
}
