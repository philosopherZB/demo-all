package com.philosopherzb.secret.service.dal.dao;

import com.github.pagehelper.Page;
import com.philosopherzb.secret.service.dal.domain.AppConfigAes;

/**
 * @author philosopherZB
 * @date 2022/1/21
 */
public interface AppConfigAesDao {
    /**
     * 新增AES配置
     *
     * @param appConfigAes aes对象
     * @return 操作结果
     */
    Integer insertSelective(AppConfigAes appConfigAes);

    /**
     * 通过id更新
     *
     * @param appConfigAes aes对象
     * @return 操作结果
     */
    Integer updateById(AppConfigAes appConfigAes);

    /**
     * 分页查询
     *
     * @param appConfigAes 查询参数
     * @param pageNo       页数
     * @param pageSize     条数
     * @return 列表信息
     */
    Page<AppConfigAes> getByPage(AppConfigAes appConfigAes, Integer pageNo, Integer pageSize);

    /**
     * 根据appId及version查询AES信息
     *
     * @param appId         appId
     * @param secretVersion secretVersion
     * @return AppConfigAes
     */
    AppConfigAes getByAppIdAndVersion(String appId, Long secretVersion);

    /**
     * 根据appId查询AES信息
     *
     * @param id id
     * @return AppConfigAes
     */
    AppConfigAes getById(Long id);

    /**
     * 通过appId获取最新的一条AES信息
     *
     * @param appId appId
     * @return AppConfigAes
     */
    AppConfigAes getLastByAppId(String appId);
}
