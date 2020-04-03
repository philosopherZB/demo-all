package com.philosopherzb.springdynamicdatasource.service;

import com.philosopherzb.springdynamicdatasource.domain.TbPerson;
import com.philosopherzb.springdynamicdatasource.domain.TbUser;
import com.philosopherzb.springdynamicdatasource.mapper.TbPersonMapper;
import com.philosopherzb.springdynamicdatasource.mapper.TbUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * author: philosopherZB
 * date: 2020/3/4
 */
@Service
public class TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestService.class);

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
        List<TbPerson> tbPersonList = new ArrayList<>();
        for (int i=0; i<2; i++) {
            TbPerson tbPerson = tbPersonMapper.getById(1L);
            tbPersonList.add(tbPerson);
        }
        TbPerson tbPerson1 = tbPersonMapper.getByName("Test");
        tbPersonList.add(tbPerson1);
        List<TbUser> tbUsers = new ArrayList<>();
        for (TbPerson tbPerson : tbPersonList){
            TbUser tbUser = new TbUser();
            tbUser.setUserName(tbPerson.getPersonName());
            tbUsers.add(tbUser);
        }
        tbUsers.forEach(tbUser -> {
            tbUserMapper.insert(tbUser);
        });
    }

    public void testGetCountNum(){
        TbPerson tbPerson = tbPersonMapper.getCount();
        logger.info("personName:{}", tbPerson.getPersonName());
        logger.info("countNum:{}", tbPerson.getCountNum());
    }

}
