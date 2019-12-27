package com.philosopherzb.springaop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.philosopherzb.springaop.dto.UserDto;
import com.philosopherzb.springaop.service.UserService;
import com.philosopherzb.springaop.util.Result;
import com.philosopherzb.springaop.util.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

/**
 * author: philosopherZB
 * date: 2019/12/26
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Result getUser(String request) {
        try {
            UserDto userDto = JSONObject.parseObject(request,UserDto.class);
            UserDto response = new UserDto();
            BeanUtils.copyProperties(userDto,response);
            response.setUserName("spring-aop");
            response.setAge(100);
            return Result.newSuccess(JSONObject.toJSONString(response));
        } catch (BeansException e) {
            logger.error("UserService.getUser occur exception,request param: {},e: {}",request,e);
            return Result.newFailure(ResultEnum.SYSTEM_ERROR);
        }
    }
}
