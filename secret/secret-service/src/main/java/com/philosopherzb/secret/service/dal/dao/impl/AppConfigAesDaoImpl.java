package com.philosopherzb.secret.service.dal.dao.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.philosopherzb.secret.service.dal.dao.AppConfigAesDao;
import com.philosopherzb.secret.service.dal.domain.AppConfigAes;
import com.philosopherzb.secret.service.dal.mapper.AppConfigAesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author philosopherZB
 * @date 2022/1/21
 */
@Service
public class AppConfigAesDaoImpl implements AppConfigAesDao {

    @Resource
    private AppConfigAesMapper appConfigAesMapper;

    @Override
    public Integer insertSelective(AppConfigAes appConfigAes) {
        return appConfigAesMapper.insert(appConfigAes);
    }

    @Override
    public Integer updateById(AppConfigAes appConfigAes) {
        return appConfigAesMapper.updateById(appConfigAes);
    }

    @Override
    public Page<AppConfigAes> getByPage(AppConfigAes appConfigAes, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return appConfigAesMapper.getByPage(appConfigAes);
    }

    @Override
    public AppConfigAes getByAppIdAndVersion(String appId, Long secretVersion) {
        return appConfigAesMapper.getByAppIdAndVersion(appId, secretVersion);
    }

    @Override
    public AppConfigAes getById(Long id) {
        return appConfigAesMapper.selectById(id);
    }

    @Override
    public AppConfigAes getLastByAppId(String appId) {
        return appConfigAesMapper.getLastByAppId(appId);
    }
}
