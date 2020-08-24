package com.philosopherzb.provider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.philosopherzb.common.exception.BizException;
import com.philosopherzb.common.request.BizApiRequest;
import com.philosopherzb.common.response.BizApiResponse;
import com.philosopherzb.common.response.BizApiResponseCode;
import com.philosopherzb.provider.dto.UserInfoDTO;
import com.philosopherzb.provider.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * author: philosopherZB
 * date: 2020/7/29
 */
@Slf4j
@Service("providerService")
public class ProviderServiceImpl implements ProviderService {
    @Override
    public void test() {
        log.info("dubbo provider-----------------------");
    }

    @Override
    public BizApiResponse getInfo(BizApiRequest bizApiRequest) {
        log.info("bizApiRequest:{}", JSONObject.toJSONString(bizApiRequest));
        try {
            // 转换json
            UserInfoDTO request = convertJson(bizApiRequest);
            log.info("UserInfoDTO:{}", JSONObject.toJSONString(request));
            UserInfoDTO response = new UserInfoDTO();
            response.setName("Test");
            response.setAge("30");
            return BizApiResponse.newSuccess().setBizContent(JSONObject.toJSONString(response));
        } catch (BizException e) {
            return BizApiResponse.newFailure(e.getErrorCode());
        } catch (Exception e) {
            log.error("ProviderServiceImpl.getInfo error:{}", e);
            return BizApiResponse.newFailure(BizApiResponseCode.SYSTEM_BUSY);
        }
    }

    private UserInfoDTO convertJson(BizApiRequest request) throws BizException {
        if (request == null) {
            log.error("biz request is null");
            throw new BizException(BizApiResponseCode.INVALID_PARAM);
        }
        if (StringUtils.isBlank(request.getBizContent())) {
            log.error("biz content is null");
            throw new BizException(BizApiResponseCode.INVALID_PARAM);
        }
        try {
            return JSONObject.parseObject(request.getBizContent(), UserInfoDTO.class);
        } catch (Exception e) {
            log.error("biz content parse UserInfoDTO error:{}", e);
            throw new BizException(BizApiResponseCode.INVALID_PARAM);
        }
    }
}
