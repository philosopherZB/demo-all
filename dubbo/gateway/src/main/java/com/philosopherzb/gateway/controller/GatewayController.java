package com.philosopherzb.gateway.controller;

import com.alibaba.fastjson.JSONObject;
import com.philosopherzb.common.request.BizApiRequest;
import com.philosopherzb.common.request.GateWayApiRequest;
import com.philosopherzb.common.response.BizApiResponse;
import com.philosopherzb.common.response.GateWayApiResponse;
import com.philosopherzb.common.response.GateWayApiResponseCode;
import com.philosopherzb.gateway.handler.DubboServiceHandler;
import com.philosopherzb.gateway.util.RpcResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * author: philosopherZB
 * date: 2020/8/20
 */
@Slf4j
@RestController
public class GatewayController {

    // 服务前缀
    private final static String SERVICE_PREFIX = "com.philosopherzb.consumer.";

    @Resource
    private DubboServiceHandler dubboServiceHandler;

    @RequestMapping(value = "/gateway.do", method = RequestMethod.POST)
    public GateWayApiResponse gateway(HttpServletRequest httpServletRequest) {

        GateWayApiResponse apiResult = null;
        GateWayApiRequest request = (GateWayApiRequest) httpServletRequest.getAttribute("apiRequest");
        String method = request.getMethod();
        String version = request.getVersion();
        String accessId = request.getAccessId();
        String bizContent = request.getBizContent();
        if (StringUtils.isBlank(method) || StringUtils.isBlank(version) || StringUtils.isBlank(accessId) || StringUtils.isBlank(bizContent)) {
            log.error("GatewayController.gateway, request param missing, method:{}, version:{}, accessId:{}, bizContent:{}", method, version, accessId, bizContent);
            return GateWayApiResponse.newFailure(GateWayApiResponseCode.REQUIRED_PARAMS_MISSING);
        }
        String serviceName = SERVICE_PREFIX + method.substring(0, method.lastIndexOf("."));
        String postMethod = method.substring(method.lastIndexOf(".") + 1);

        // 获取dubbo服务
        GenericService genericService = dubboServiceHandler.getService(serviceName, version, "");
        if (genericService == null) {
            throw new NoSuchBeanDefinitionException("GatewayController.gateway, no such bean.");
        }

        // 执行相关方法
        BizApiRequest bizApiRequest = new BizApiRequest(accessId, bizContent);
        Object bizObj = genericService.$invoke(postMethod, new String[]{"com.philosopherzb.common.request.BizApiRequest"},
                new Object[]{bizApiRequest});
        bizObj = RpcResultUtil.fixRpcResultClass(bizObj);
        String json = JSONObject.toJSONString(bizObj);
        BizApiResponse bizResult = JSONObject.parseObject(json, BizApiResponse.class);
        if (bizResult != null) {
            apiResult = GateWayApiResponse.loadFromBizResponse(bizResult);
        }
        log.info("GatewayController.gateway, api result:{}", apiResult);
        return apiResult;
    }
}
