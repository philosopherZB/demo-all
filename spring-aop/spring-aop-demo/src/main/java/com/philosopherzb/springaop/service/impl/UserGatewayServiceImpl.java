package com.philosopherzb.springaop.service.impl;

import com.philosopherzb.springaop.dto.ApiRequest;
import com.philosopherzb.springaop.facade.BaseFacade;
import com.philosopherzb.springaop.service.UserGatewayService;
import com.philosopherzb.springaop.service.UserService;
import com.philosopherzb.springaop.util.Constant;
import com.philosopherzb.springaop.util.Result;
import com.philosopherzb.springaop.util.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.function.Function;

/**
 * author: philosopherZB
 * date: 2019/12/26
 */
@Service(value = "userGatewayService")
public class UserGatewayServiceImpl extends BaseFacade implements UserGatewayService {
    private static final Logger logger = LoggerFactory.getLogger(UserGatewayServiceImpl.class);

    @Resource
    private UserService userService;

    @Override
    protected void init() {
        String key = Constant.METHOD_GET_USER + Constant.CONNECTOR_LINE_THROUGH + Constant.VERSION;
        functionMap.put(key,(bizContent)->userService.getUser(bizContent));
    }

    @Override
    public Result callGateway(ApiRequest request){
        String method = request.getMethod();
        String version = request.getVersion();
        String bizContent = request.getBizContent();
        String key = method + Constant.CONNECTOR_LINE_THROUGH + version;

        Function<String,Result> function = functionMap.get(key);
        if(function != null){
            return function.apply(bizContent);
        }else{
            logger.error("BaseFacade.callGateway call method failure, No method matching version,method: {}, version: {}",method,version);
            return Result.newFailure(ResultEnum.NOT_FOUND_ERROR);
        }
    }
}
