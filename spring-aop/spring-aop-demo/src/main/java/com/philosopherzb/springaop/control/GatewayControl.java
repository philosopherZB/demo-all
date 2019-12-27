package com.philosopherzb.springaop.control;

import com.philosopherzb.springaop.dto.ApiRequest;
import com.philosopherzb.springaop.service.UserGatewayService;
import com.philosopherzb.springaop.util.Constant;
import com.philosopherzb.springaop.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * author: philosopherZB
 * date: 2019/12/26
 */
@RestController
@RequestMapping("/api/v1")
public class GatewayControl {

    @Resource
    private UserGatewayService userGatewayService;

    @RequestMapping(value = "/gateway.do",method = RequestMethod.POST, produces = Constant.CONTENT_TYPE_APPLICATION_JSON_UTF_8,consumes = Constant.CONTENT_TYPE_APPLICATION_JSON_UTF_8)
    public Result gateway(HttpServletRequest request){
        ApiRequest apiRequest = (ApiRequest) request.getAttribute(Constant.HTTP_ATTRIBUTE_KEY);
        return userGatewayService.callGateway(apiRequest);
    }
}
