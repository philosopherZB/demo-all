package com.philosopherzb.secret.service.dal.dao;

import com.github.pagehelper.Page;
import com.philosopherzb.secret.service.dal.domain.AppConfigRsa;

/**
 * @author philosopherZB
 * @date 2022/1/21
 */
public interface AppConfigRsaDao {
    /**
     * 新增RSA配置
     *
     * @param appConfigRsa rsa对象
     * @return 操作结果
     */
    Integer insertSelective(AppConfigRsa appConfigRsa);

    /**
     * 通过id更新
     *
     * @param appConfigRsa rsa对象
     * @return 操作结果
     */
    Integer updateById(AppConfigRsa appConfigRsa);

    /**
     * 分页查询
     *
     * @param appConfigRsa 查询参数
     * @param pageNo       页数
     * @param pageSize     条数
     * @return 列表信息
     */
    Page<AppConfigRsa> getByPage(AppConfigRsa appConfigRsa, Integer pageNo, Integer pageSize);

    /**
     * 根据appId查询RSA信息
     *
     * @param appId appId
     * @return AppConfigRsa
     */
    AppConfigRsa getByAppId(String appId);

    /**
     * 根据tenantId查询RSA信息
     *
     * @param tenantId tenantId
     * @return AppConfigRsa
     */
    AppConfigRsa getByTenantId(String tenantId);

    /**
     * 根据appId查询RSA信息
     *
     * @param id id
     * @return AppConfigRsa
     */
    AppConfigRsa getById(Long id);
}
