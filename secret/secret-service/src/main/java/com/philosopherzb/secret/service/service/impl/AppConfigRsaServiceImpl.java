package com.philosopherzb.secret.service.service.impl;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.Page;
import com.philosopherzb.secret.service.common.constant.CommonConstants;
import com.philosopherzb.secret.service.common.util.GenerateKeyUtils;
import com.philosopherzb.secret.service.common.util.SnowflakeIdWorkerUtils;
import com.philosopherzb.secret.service.dal.dao.AppConfigRsaDao;
import com.philosopherzb.secret.service.dal.domain.AppConfigRsa;
import com.philosopherzb.secret.service.service.AppConfigRsaService;
import com.philosopherzb.secret.service.web.request.AppConfigRsaRequest;
import com.philosopherzb.secret.service.web.vo.AppConfigRsaVO;
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
public class AppConfigRsaServiceImpl implements AppConfigRsaService {

    @Resource
    private AppConfigRsaDao appConfigRsaDao;

    @Override
    public Boolean create(AppConfigRsaRequest request) {
        // todo 查询租户是否存在

        // 查询本地是否存在
        AppConfigRsa dbResult = appConfigRsaDao.getByTenantId(request.getTenantId());
        if (dbResult != null && StringUtils.isNotBlank(dbResult.getAppId())) {
            if (CommonConstants.DELETE_FLAG_1.equals(dbResult.getIsDelete())) {
                // todo 需替换
                throw new IllegalStateException("Data exists but has been deleted, please reactivate");
            }
            // todo 需替换
            throw new IllegalStateException("The tenant's secretKey already exists");
        }

        AppConfigRsa param = new AppConfigRsa();
        BeanUtils.copyProperties(request, param);
        // 自动生成相关参数
        param.setAppId(CommonConstants.APP_ID_PREFIX + SnowflakeIdWorkerUtils.generateIdWithDate());
        param.setRandomNum(SnowflakeIdWorkerUtils.generateIdWithDate());
        try {
            param.setDasPriKey(GenerateKeyUtils.genDefaultPrivateKey());
            param.setDasPubKey(GenerateKeyUtils.genDefaultPublicKey());
        } catch (NoSuchAlgorithmException e) {
            log.error("AppConfigRsaService.create generate rsa secret key failure, e: ", e);
            // todo 需替换
            throw new IllegalStateException("generate rsa secret key failure");
        }
        if (appConfigRsaDao.insertSelective(param) < 1) {
            log.error("AppConfigRsaService.create, appConfigRsaDao.insertSelective failure, param: {}", param.toString());
            // todo 需替换
            throw new IllegalStateException("create failure");
        }

        return true;
    }

    @Override
    public Boolean updateById(AppConfigRsaRequest request) {
        AppConfigRsa param = new AppConfigRsa();
        copyBeanValue(request, param);
        AppConfigRsa dbResult = appConfigRsaDao.getById(param.getId());
        if (dbResult == null || StringUtils.isBlank(dbResult.getAppId())) {
            // todo 需替换
            throw new IllegalStateException("app rsa not exist");
        }
        if (appConfigRsaDao.updateById(param) < 1) {
            log.error("AppConfigRsaService.updateById, appConfigRsaDao.updateById failure, param: {}", param.toString());
            // todo 需替换
            throw new IllegalStateException("updateById failure");
        }

        return true;
    }

    @Override
    public Page<AppConfigRsaVO> getByPage(AppConfigRsaRequest request) {
        request.calcPage();
        AppConfigRsa param = new AppConfigRsa();
        BeanUtils.copyProperties(request, param);
        Page<AppConfigRsa> dbResultPage = appConfigRsaDao.getByPage(param, request.getPageNo(), request.getPageSize());
        // 分页转vo
        List<AppConfigRsaVO> voList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(dbResultPage.getResult())) {
            voList = dbResultPage.getResult().stream().map(AppConfigRsa::toVO).collect(Collectors.toList());
        }
        // todo 返回对象替换
        log.info("voList:{}", JSONUtil.toJsonStr(voList));
        return null;
    }

    /**
     * 复制部分bean值到db对象
     *
     * @param request 入参
     * @param param   db对象
     */
    private void copyBeanValue(AppConfigRsaRequest request, AppConfigRsa param) {
        param.setId(request.getId());
        param.setAppPubKey(request.getAppPubKey());
        param.setRandomNum(request.getRandomNum());
        param.setEncryptIndexCompressLen(request.getEncryptIndexCompressLen());
        param.setEncryptSlideSize(request.getEncryptSlideSize());
        param.setInvalidTime(request.getInvalidTime());
        param.setMaxInvalidTime(request.getMaxInvalidTime());
        param.setIsDelete(request.getIsDelete());
    }
}
