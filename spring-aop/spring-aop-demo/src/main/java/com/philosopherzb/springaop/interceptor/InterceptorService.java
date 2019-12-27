package com.philosopherzb.springaop.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.philosopherzb.springaop.dto.ApiRequest;
import com.philosopherzb.springaop.util.Constant;
import com.philosopherzb.springaop.util.Result;
import com.philosopherzb.springaop.util.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;

/**
 * author: philosopherZB
 * date: 2019/12/26
 */
@Service
public class InterceptorService extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(InterceptorService.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("InterceptorService.preHandle begin execute");

        if(!checkParam(request)){
            response.setCharacterEncoding(Constant.ENCODING_UTF_8);
            response.setContentType(Constant.CONTENT_TYPE_APPLICATION_JSON_UTF_8);
            response.getWriter().print(JSONObject.toJSON(Result.newFailure(ResultEnum.REQUIRED_PARAMETER_MISSING)));
            return false;
        }
        return true;
    }

    private boolean checkParam(HttpServletRequest request){
        try {
            ApiRequest apiRequest = this.getRequest(request);
            String accessId = apiRequest.getAccessId();
            String version = apiRequest.getVersion();
            String method = apiRequest.getMethod();
            String bizContent = apiRequest.getBizContent();

            if(StringUtils.isEmpty(accessId) || StringUtils.isEmpty(version) ||
                    StringUtils.isEmpty(method) || StringUtils.isEmpty(bizContent)){
                logger.warn("InterceptorService.checkParam required parameter missing,accessId={}, version={}, method={}, bizContent={}",accessId,version,method,bizContent);
                return false;
            }
            request.setAttribute(Constant.HTTP_ATTRIBUTE_KEY,apiRequest);
            return true;
        } catch (Exception e) {
            logger.warn("InterceptorService.checkParam occur exception,e:{}",e);
            return false;
        }
    }

    private ApiRequest getRequest(HttpServletRequest request) throws Exception{
        BufferedReader br = request.getReader();
        String str;
        StringBuilder wholeStr = new StringBuilder();
        while ((str = br.readLine()) != null) {
            wholeStr.append(str);
        }
        JSONObject json = JSONObject.parseObject(wholeStr.toString());
        return JSONObject.parseObject(json.toJSONString(),ApiRequest.class);
    }
}
