package com.philosopherzb.shardingtable.mapper;

import com.philosopherzb.shardingtable.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: philosopherZB
 * date: 2020/3/4
 */
@Repository
public interface TbUserMapper {

    List select();

    int update(TbUser tbUser);

    int insert(TbUser tbUser);

    TbUser getByUserId(Long userId);
}
