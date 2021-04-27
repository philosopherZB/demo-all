package com.philosopherzb.shardingtable.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.philosopherzb.shardingtable.domain.TbUser;
import com.philosopherzb.shardingtable.mapper.TbUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author: philosopherZB
 * date: 2020/4/3
 */
@Slf4j
@Service
public class UserService {

    @Resource
    private TbUserMapper tbUserMapper;

    public void insertUser() {
        TbUser tbUser = new TbUser();
        tbUser.setUserId(1L);
        tbUser.setUserName("测试001");

        TbUser tbUser1 = new TbUser();
        tbUser1.setUserId(2L);
        tbUser1.setUserName("测试002");

        tbUserMapper.insert(tbUser);
        tbUserMapper.insert(tbUser1);
    }

    public void getUser() {
        log.info("userList:{}", JSONObject.toJSONString(tbUserMapper.select()));
    }

    public void getUserPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbUser> userPage = tbUserMapper.getUserList();
        log.info("userList:{}", JSONObject.toJSONString(userPage));
        log.info("pageNum:{}, pageSize:{}, getCountColumn:{}, getPages:{}, getTotal:{}",
                userPage.getPageNum(), userPage.getPageSize(), userPage.getCountColumn(), userPage.getPages(), userPage.getTotal());
        log.info("userList:{}", JSONObject.toJSONString(userPage.getResult()));
    }

}
