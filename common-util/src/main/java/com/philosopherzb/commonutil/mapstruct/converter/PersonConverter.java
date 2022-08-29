package com.philosopherzb.commonutil.mapstruct.converter;

import com.philosopherzb.commonutil.mapstruct.bo.PersonBO;
import com.philosopherzb.commonutil.mapstruct.bo.PersonVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * 转换器
 *
 * @author philosopherZB
 * @date 2022/8/29
 */
@Mapper
public interface PersonConverter {
    PersonConverter INSTANCE = Mappers.getMapper(PersonConverter.class);

    @Mapping(source = "name", target = "userName")
    @Mapping(source = "testFiled", target = "testFiled2")
    PersonVO boToVO(PersonBO personBO);
}
