package com.philosopherzb.gateway.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.philosopherzb.common.request.GateWayApiRequest;
import com.philosopherzb.common.response.GateWayApiResponse;
import com.philosopherzb.common.response.GateWayApiResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * author: philosopherZB
 * date: 2020/8/21
 */
@Slf4j
@Component
public class ParamCheckInterceptor extends HandlerInterceptorAdapter {

    private static final String UTF_8 = "utf-8";
    private static final int NONCE_LENGTH = 8;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        response.setCharacterEncoding("UTF-8");
        String origin = request.getHeader("origin");
        response.setHeader("Access-Control-Allow-Origin", StringUtils.isEmpty(origin) ? "*" : origin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setContentType("application/json;charset=UTF-8");

        GateWayApiResponseCode result = checkParam(request);
        if (result != GateWayApiResponseCode.SUCCESS) {
            GateWayApiResponse responseInfo = GateWayApiResponse.newFailure(result);
            response.getWriter().print(JSONObject.toJSON(responseInfo));
            return false;
        }
        return true;
    }

    private GateWayApiResponseCode checkParam(HttpServletRequest request) {

        GateWayApiRequest apiRequest = getApiRequest(request);

        String urlAccessId = apiRequest.getAccessId();
        String urlSignature = apiRequest.getSignature();
        String urlTimestamp = apiRequest.getTimestamp();
        String character = apiRequest.getCharacter();
        String signMethod = apiRequest.getSignatureMethod();
        String signNonce = apiRequest.getSignatureNonce();

        if (StringUtils.isBlank(urlAccessId) || StringUtils.isBlank(urlSignature) || StringUtils.isBlank(urlTimestamp)
                || !UTF_8.equalsIgnoreCase(character) || StringUtils.isBlank(signMethod) || StringUtils.isBlank(signNonce) ||
                NONCE_LENGTH != signNonce.length()) {
            log.info("checkSignature, param missing,  accessId,:{}, sign:{}, timestamp:{}, character:{}, signMethod:{}, signNonce:{}", urlAccessId, urlSignature, urlTimestamp, character, signMethod, signNonce);
            return GateWayApiResponseCode.REQUIRED_PARAMS_MISSING;
        }
        request.setAttribute("apiRequest", apiRequest);
        return GateWayApiResponseCode.SUCCESS;
    }

    private GateWayApiRequest getApiRequest(HttpServletRequest request) {
        GateWayApiRequest apiRequest = null;
        try (BufferedReader br = request.getReader()) {
            String str;
            StringBuilder wholeStr = new StringBuilder();
            while ((str = br.readLine()) != null) {
                wholeStr.append(str);
            }
            JSONObject json = JSONObject.parseObject(wholeStr.toString());
            apiRequest = JSONObject.parseObject(json.toJSONString(), GateWayApiRequest.class);
        } catch (IOException e) {
            log.error("getApiRequest error:{}", e);
        }
        return apiRequest;
    }
}
