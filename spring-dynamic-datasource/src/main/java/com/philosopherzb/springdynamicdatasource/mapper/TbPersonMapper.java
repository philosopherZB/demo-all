package com.philosopherzb.springdynamicdatasource.mapper;

import com.philosopherzb.springdynamicdatasource.annotation.DataSource;
import com.philosopherzb.springdynamicdatasource.constant.DbTypeEnum;
import com.philosopherzb.springdynamicdatasource.domain.TbPerson;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: philosopherZB
 * date: 2020/3/4
 */
@Repository
public interface TbPersonMapper {
    @DataSource(value = DbTypeEnum.READ_DB)
    List select(TbPerson tbPerson);

    @DataSource(value = DbTypeEnum.READ_DB)
    int update(TbPerson tbPerson);

    @DataSource(value = DbTypeEnum.READ_DB)
    int insert(TbPerson tbPerson);

    @DataSource(value = DbTypeEnum.READ_DB)
    int delete(TbPerson tbPerson);

    @DataSource(value = DbTypeEnum.READ_DB)
    TbPerson getById(Long id);
}
