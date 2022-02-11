package com.philosopherzb.secret.service.dal.dao.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.philosopherzb.secret.service.dal.dao.AppConfigRsaDao;
import com.philosopherzb.secret.service.dal.domain.AppConfigRsa;
import com.philosopherzb.secret.service.dal.mapper.AppConfigRsaMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author philosopherZB
 * @date 2022/1/21
 */
@Service
public class AppConfigRsaDaoImpl implements AppConfigRsaDao {

    @Resource
    private AppConfigRsaMapper appConfigRsaMapper;

    @Override
    public Integer insertSelective(AppConfigRsa appConfigRsa) {
        return appConfigRsaMapper.insert(appConfigRsa);
    }

    @Override
    public Integer updateById(AppConfigRsa appConfigRsa) {
        return appConfigRsaMapper.updateById(appConfigRsa);
    }

    @Override
    public Page<AppConfigRsa> getByPage(AppConfigRsa appConfigRsa, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return appConfigRsaMapper.getByPage(appConfigRsa);
    }

    @Override
    public AppConfigRsa getByAppId(String appId) {
        return appConfigRsaMapper.getByAppId(appId);
    }

    @Override
    public AppConfigRsa getByTenantId(String tenantId) {
        return appConfigRsaMapper.getByTenantId(tenantId);
    }

    @Override
    public AppConfigRsa getById(Long id) {
        return appConfigRsaMapper.selectById(id);
    }
}
