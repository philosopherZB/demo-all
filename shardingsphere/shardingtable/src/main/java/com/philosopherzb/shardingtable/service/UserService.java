package com.philosopherzb.shardingtable.service;

import com.alibaba.fastjson.JSONObject;
import com.philosopherzb.shardingtable.domain.TbUser;
import com.philosopherzb.shardingtable.mapper.TbUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author: philosopherZB
 * date: 2020/4/3
 */
@Service
public class UserService {

    @Resource
    private TbUserMapper tbUserMapper;

    public void insertUser(){
        TbUser tbUser = new TbUser();
        tbUser.setUserId(1L);
        tbUser.setUserName("测试001");

        TbUser tbUser1 = new TbUser();
        tbUser1.setUserId(2L);
        tbUser1.setUserName("测试002");

        tbUserMapper.insert(tbUser);
        tbUserMapper.insert(tbUser1);
    }

    public void getUser(){
        System.out.println(JSONObject.toJSONString(tbUserMapper.select()));
    }

}
