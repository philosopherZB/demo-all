package com.philosopherzb.secret.service.service.impl;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.philosopherzb.secret.service.common.util.RSAUtils;
import com.philosopherzb.secret.service.dal.dao.AppConfigAesDao;
import com.philosopherzb.secret.service.dal.dao.AppConfigRsaDao;
import com.philosopherzb.secret.service.dal.domain.AppConfigAes;
import com.philosopherzb.secret.service.dal.domain.AppConfigRsa;
import com.philosopherzb.secret.service.gateway.request.SecurityRequest;
import com.philosopherzb.secret.service.gateway.vo.RsaVO;
import com.philosopherzb.secret.service.gateway.vo.SecurityVO;
import com.philosopherzb.secret.service.service.SecretService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.TreeMap;

/**
 * @author philosopherZB
 * @date 2022/1/20
 */
@Slf4j
@Service
public class SecretServiceImpl implements SecretService {

    @Resource
    private AppConfigAesDao appConfigAesDao;
    @Resource
    private AppConfigRsaDao appConfigRsaDao;

    @Override
    public RsaVO getByAppId(String appId) {
        AppConfigRsa rsaResult = getRsaByAppId(appId);
        RsaVO rsaVO = new RsaVO();
        BeanUtils.copyProperties(rsaResult, rsaVO);
        // 可将数据存储在redis中；如果存储至redis，需要注意在更新操作时删除对应的key
        return rsaVO;
    }

    @Override
    public SecurityVO getSecurity(String appId, SecurityRequest securityRequest) {
        AppConfigRsa rsaResult = getRsaByAppId(appId);
        if (securityRequest.getSecretVersion() == null) {
            // todo 需替换
            throw new IllegalStateException("invalid param secretVersion");
        }
        AppConfigAes aesResult = getAesByAppIdAndVersion(appId, securityRequest.getSecretVersion());
        SecurityVO securityVO = new SecurityVO();
        BeanUtils.copyProperties(rsaResult, securityVO);

        // aes加密后传输
        String aesKey = aesResult.getAesKey();
        try {
            String encryptAesKey = RSAUtils.encrypt(aesKey, rsaResult.getAppPubKey());
            securityVO.setAesKey(encryptAesKey);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException |
                InvalidKeySpecException | InvalidKeyException |
                IllegalBlockSizeException | BadPaddingException e) {
            log.error("SecretService.getSecurity RSAUtils.encrypt occur exception: ", e);
            // todo 需替换
            throw new IllegalStateException("aesKey encrypt failure");
        }

        // 是否需要对结果进行加签-->只加签业务内容
        if (securityRequest.getVerifyResponse()) {
            String json = JSONUtil.toJsonStr(securityVO);
            TreeMap<String, Object> treeMap = JSONUtil.toBean(json, new TypeReference<TreeMap<String, Object>>() {
            }, Boolean.FALSE);
            log.info("treeMap: {}", treeMap.toString());
            try {
                String sign = RSAUtils.sign(treeMap.toString(), rsaResult.getDasPriKey());
                securityVO.setSign(sign);
            } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | SignatureException e) {
                log.error("SecretService.getSecurity RSAUtils.encrypt occur exception: ", e);
                // todo 需替换
                throw new IllegalStateException("sign failure");
            }
        }
        return securityVO;
    }

    /**
     * 通过appId查询rsa信息
     *
     * @param appId appId
     * @return rsa信息
     */
    private AppConfigRsa getRsaByAppId(String appId) {
        AppConfigRsa rsaResult = appConfigRsaDao.getByAppId(appId);
        if (rsaResult == null || StringUtils.isBlank(rsaResult.getAppId())) {
            // todo 需替换
            throw new IllegalStateException("app rsa not exist");
        }
        return rsaResult;
    }

    /**
     * 通过appId version 查询aes信息
     *
     * @param appId         appId
     * @param secretVersion 秘钥版本
     * @return aes信息
     */
    private AppConfigAes getAesByAppIdAndVersion(String appId, Long secretVersion) {
        AppConfigAes aesResult = appConfigAesDao.getByAppIdAndVersion(appId, secretVersion);
        if (aesResult == null || StringUtils.isBlank(aesResult.getAppId())) {
            // todo 需替换
            throw new IllegalStateException("app aes not exist");
        }
        return aesResult;
    }
}
