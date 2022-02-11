package com.philosopherzb.secret.service.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.philosopherzb.secret.service.dal.domain.AppConfigAes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author philosopherZB
 * @date 2022/1/21
 */
@Repository
public interface AppConfigAesMapper extends BaseMapper<AppConfigAes> {

    Page<AppConfigAes> getByPage(AppConfigAes appConfigAes);

    AppConfigAes getByAppIdAndVersion(@Param("appId") String appId,
                                      @Param("secretVersion") Long secretVersion);

    AppConfigAes getLastByAppId(@Param("appId") String appId);
}
