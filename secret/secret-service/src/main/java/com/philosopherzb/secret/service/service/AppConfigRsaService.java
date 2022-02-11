package com.philosopherzb.secret.service.service;

import com.github.pagehelper.Page;
import com.philosopherzb.secret.service.web.request.AppConfigRsaRequest;
import com.philosopherzb.secret.service.web.vo.AppConfigRsaVO;

/**
 * @author philosopherZB
 * @date 2022/1/21
 */
public interface AppConfigRsaService {

    /**
     * 新增RSA配置
     *
     * @param request rsa对象
     * @return 操作结果
     */
    Boolean create(AppConfigRsaRequest request);

    /**
     * 通过id更新
     *
     * @param request rsa对象
     * @return 操作结果
     */
    Boolean updateById(AppConfigRsaRequest request);

    /**
     * 分页查询
     *
     * @param request 查询参数
     * @return 列表信息
     */
    Page<AppConfigRsaVO> getByPage(AppConfigRsaRequest request);
}
