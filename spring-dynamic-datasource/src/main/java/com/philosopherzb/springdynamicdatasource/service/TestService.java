package com.philosopherzb.springdynamicdatasource.service;

import com.philosopherzb.springdynamicdatasource.annotation.DataSource;
import com.philosopherzb.springdynamicdatasource.constant.DbTypeEnum;
import com.philosopherzb.springdynamicdatasource.domain.TbPerson;
import com.philosopherzb.springdynamicdatasource.domain.TbUser;
import com.philosopherzb.springdynamicdatasource.mapper.TbPersonMapper;
import com.philosopherzb.springdynamicdatasource.mapper.TbUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author: philosopherZB
 * date: 2020/3/4
 */
@Service
public class TestService {

    @Resource
    private TbPersonMapper tbPersonMapper;

    @Resource
    private TbUserMapper tbUserMapper;


    public void testCreatePerson(){
        TbPerson tbPerson = new TbPerson();
        tbPerson.setPersonName("测试person");
        tbPersonMapper.insert(tbPerson);
    }


    public void testCreateUser(){
        TbUser tbUser = new TbUser();
        tbUser.setUserName("测试user");
        tbUserMapper.insert(tbUser);
    }

    public void testPToU(){
        TbPerson tbPerson = tbPersonMapper.getById(1L);
        TbUser tbUser = new TbUser();
        tbUser.setUserName(tbPerson.getPersonName());
        tbUserMapper.insert(tbUser);
    }
}
