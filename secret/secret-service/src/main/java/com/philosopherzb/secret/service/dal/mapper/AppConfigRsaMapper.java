package com.philosopherzb.secret.service.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.philosopherzb.secret.service.dal.domain.AppConfigRsa;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author philosopherZB
 * @date 2022/1/21
 */
@Repository
public interface AppConfigRsaMapper extends BaseMapper<AppConfigRsa> {

    Page<AppConfigRsa> getByPage(AppConfigRsa appConfigRsa);

    AppConfigRsa getByAppId(@Param("appId") String appId);

    AppConfigRsa getByTenantId(@Param("tenantId") String tenantId);
}
