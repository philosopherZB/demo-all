package com.philosopherzb.secret.service.service.impl;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.Page;
import com.philosopherzb.secret.service.common.util.GenerateKeyUtils;
import com.philosopherzb.secret.service.dal.dao.AppConfigAesDao;
import com.philosopherzb.secret.service.dal.dao.AppConfigRsaDao;
import com.philosopherzb.secret.service.dal.domain.AppConfigAes;
import com.philosopherzb.secret.service.dal.domain.AppConfigRsa;
import com.philosopherzb.secret.service.service.AppConfigAesService;
import com.philosopherzb.secret.service.web.request.AppConfigAesRequest;
import com.philosopherzb.secret.service.web.vo.AppConfigAesVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author philosopherZB
 * @date 2022/1/21
 */
@Slf4j
@Service
public class AppConfigAesServiceImpl implements AppConfigAesService {

    private static final long DEFAULT_SECRET_VERSION = 1L;

    @Resource
    private AppConfigAesDao appConfigAesDao;
    @Resource
    private AppConfigRsaDao appConfigRsaDao;

    @Override
    public Boolean create(String appId) {
        AppConfigAes param = new AppConfigAes();
        param.setAppId(appId);
        param.setSecretVersion(DEFAULT_SECRET_VERSION);

        // 查询RSA是否存在
        AppConfigRsa rsaResult = appConfigRsaDao.getByAppId(appId);
        if (rsaResult == null || StringUtils.isBlank(rsaResult.getAppId())) {
            // todo 需替换
            throw new IllegalStateException("app rsa not exist");
        }
        // 查询AES是否存在
        AppConfigAes dbResult = appConfigAesDao.getByAppIdAndVersion(param.getAppId(), param.getSecretVersion());
        if (dbResult != null && StringUtils.isNotBlank(dbResult.getAppId())) {
            // todo 需替换
            throw new IllegalStateException("aes exist");
        }

        // 自动生成相关参数
        try {
            param.setAesKey(GenerateKeyUtils.genAesKey());
        } catch (NoSuchAlgorithmException e) {
            log.error("AppConfigAesService.create generate aes secret key failure, e: ", e);
            // todo 需替换
            throw new IllegalStateException("generate aes secret key failure");
        }
        if (appConfigAesDao.insertSelective(param) < 1) {
            log.error("AppConfigAesService.create, appConfigAesDao.insertSelective failure, param: {}", param.toString());
            // todo 需替换
            throw new IllegalStateException("create failure");
        }

        return true;
    }

    @Override
    public Boolean upgradeAes(String appId) {
        AppConfigAes dbResult = appConfigAesDao.getByAppIdAndVersion(appId, DEFAULT_SECRET_VERSION);
        if (dbResult == null || StringUtils.isBlank(dbResult.getAppId())) {
            // todo 需替换
            throw new IllegalStateException("app aes not exist");
        }
        // 获取指定appId下最新版本的aes秘钥
        AppConfigAes lastAes = appConfigAesDao.getLastByAppId(appId);
        if (lastAes == null || StringUtils.isBlank(lastAes.getAppId())) {
            // todo 需替换
            throw new IllegalStateException("last aes not exist");
        }
        AppConfigAes param = new AppConfigAes();
        param.setAppId(dbResult.getAppId());
        param.setSecretVersion(lastAes.getSecretVersion() + 1);
        try {
            param.setAesKey(GenerateKeyUtils.genAesKey());
        } catch (NoSuchAlgorithmException e) {
            log.error("AppConfigAesService.create generate aes secret key failure, e: ", e);
            // todo 需替换
            throw new IllegalStateException("generate aes secret key failure");
        }

        if (appConfigAesDao.insertSelective(param) < 1) {
            log.error("AppConfigRsaService.updateById, appConfigRsaDao.updateById failure, param: {}", param.toString());
            // todo 需替换
            throw new IllegalStateException("updateById failure");
        }

        return true;
    }

    @Override
    public Page<AppConfigAesVO> getByPage(AppConfigAesRequest request) {
        request.calcPage();
        AppConfigAes param = new AppConfigAes();
        BeanUtils.copyProperties(request, param);
        Page<AppConfigAes> dbResultPage = appConfigAesDao.getByPage(param, request.getPageNo(), request.getPageSize());
        // 分页转vo
        List<AppConfigAesVO> voList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(dbResultPage.getResult())) {
            voList = dbResultPage.getResult().stream().map(AppConfigAes::toVO).collect(Collectors.toList());
        }
        // todo 返回对象替换
        log.info("voList:{}", JSONUtil.toJsonStr(voList));
        return null;
    }
}
