package com.philosopherzb.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.philosopherzb.mybatisplus.dal.domain.User;
import com.philosopherzb.mybatisplus.dal.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author philosopherZB
 * @date 2022/10/25
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public Long testCount(Long userId) {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(User::getUserId, userId);
        queryWrapper.notIn(User::getUserName, "Test_user1_001");
        return userMapper.selectCount(queryWrapper);
    }
}
