package com.philosopherzb.shardingdb.service;

import com.alibaba.fastjson.JSONObject;
import com.philosopherzb.shardingdb.domain.TbUser;
import com.philosopherzb.shardingdb.mapper.TbUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

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
        tbUser.setShardingKey(2L);
        tbUser.setUserName("测试001");

        TbUser tbUser1 = new TbUser();
        tbUser1.setUserId(2L);
        tbUser1.setShardingKey(1L);
        tbUser1.setUserName("测试002");

        tbUserMapper.insert(tbUser);
        tbUserMapper.insert(tbUser1);
    }

    public void getUser() {
        System.out.println(JSONObject.toJSONString(tbUserMapper.select()));
    }

    public void getByPage() {
        try {
            long count = tbUserMapper.getCount();
            if (count == 0) {
                log.info("data is empty");
                return;
            }

            int pageSize = 3;
            long page = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
            for (int i = 1; i <= page; i++) {
                List<TbUser> dbResults = tbUserMapper.selectByPage((i - 1) * pageSize, pageSize);
                if (!CollectionUtils.isEmpty(dbResults)) {
                    log.info("info:{}", JSONObject.toJSONString(dbResults));
                }
            }
        } catch (Exception e) {
            log.error("occur exception, e:{}", e);
        }
    }

}
