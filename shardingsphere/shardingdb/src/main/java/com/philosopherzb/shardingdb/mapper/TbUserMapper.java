package com.philosopherzb.shardingdb.mapper;

import com.philosopherzb.shardingdb.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: philosopherZB
 * date: 2020/3/4
 */
@Repository
public interface TbUserMapper {

    List select();

    int insert(TbUser tbUser);

}