package com.philosopherzb.secret.service.service;

import com.github.pagehelper.Page;
import com.philosopherzb.secret.service.web.request.AppConfigAesRequest;
import com.philosopherzb.secret.service.web.vo.AppConfigAesVO;

/**
 * @author philosopherZB
 * @date 2022/1/21
 */
public interface AppConfigAesService {
    /**
     * 新增AES配置
     *
     * @param appId appId
     * @return 操作结果
     */
    Boolean create(String appId);

    /**
     * 通过id更新
     *
     * @param appId appId
     * @return 操作结果
     */
    Boolean upgradeAes(String appId);

    /**
     * 分页查询
     *
     * @param request 查询参数
     * @return 列表信息
     */
    Page<AppConfigAesVO> getByPage(AppConfigAesRequest request);
}
