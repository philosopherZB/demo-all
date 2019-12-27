package com.philosopherzb.springaop.schedule;

import com.alibaba.fastjson.JSONObject;
import com.philosopherzb.springaop.dto.ApiRequest;
import com.philosopherzb.springaop.dto.UserDto;
import com.philosopherzb.springaop.util.Constant;
import com.philosopherzb.springaop.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * author: philosopherZB
 * date: 2019/12/26
 */
@Service
public class ScheduleService {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleService.class);

    @Scheduled(fixedRate = 24*60*60*1000)
    public void test(){
        this.callApi();
    }

    private void callApi(){
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.setAccessId("test0001");
        apiRequest.setMethod(Constant.METHOD_GET_USER);
        apiRequest.setVersion(Constant.VERSION);

        UserDto userDto = new UserDto();
        userDto.setUserId("0001");

        apiRequest.setBizContent(JSONObject.toJSONString(userDto));

        String request = JSONObject.toJSONString(apiRequest);
        logger.info("request param:{}",request);

        try {
            String response = HttpClientUtil.sendHttpRequest(Constant.GATEWAY_API,Constant.HTTP_METHOD_POST,
                    Constant.CONTENT_TYPE_APPLICATION_JSON,Constant.ENCODING_UTF_8,new HashMap<>(),request);
            logger.info("response result:{}",response);
        } catch (Exception e) {
            logger.error("ScheduleService.callApi occur exception,e:{}",e);
        }
    }
}
