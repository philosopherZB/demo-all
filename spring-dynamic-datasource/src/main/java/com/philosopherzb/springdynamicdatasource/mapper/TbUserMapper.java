package com.philosopherzb.springdynamicdatasource.mapper;

import com.philosopherzb.springdynamicdatasource.annotation.DataSource;
import com.philosopherzb.springdynamicdatasource.constant.DbTypeEnum;
import com.philosopherzb.springdynamicdatasource.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: philosopherZB
 * date: 2020/3/4
 */
@Repository
public interface TbUserMapper {
    @DataSource(value = DbTypeEnum.WRITE_DB)
    List select(TbUser tbUser);

    @DataSource(value = DbTypeEnum.WRITE_DB)
    int update(TbUser tbUser);

    @DataSource(value = DbTypeEnum.WRITE_DB)
    int insert(TbUser tbUser);

    @DataSource(value = DbTypeEnum.WRITE_DB)
    int delete(TbUser tbUser);

    @DataSource(value = DbTypeEnum.WRITE_DB)
    TbUser getById(Long id);
}
