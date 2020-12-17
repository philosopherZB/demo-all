package com.philosopherzb.shardingdb.mapper;

import com.philosopherzb.shardingdb.domain.TbUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: philosopherZB
 * date: 2020/3/4
 */
@Repository
public interface TbUserMapper {

    List<TbUser> select();

    int insert(TbUser tbUser);

    List<TbUser> selectByPage(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    Long getCount();
}
