package com.philosopherzb.commonutil.mapstruct.test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.philosopherzb.commonutil.mapstruct.bo.PersonBO;
import com.philosopherzb.commonutil.mapstruct.bo.PersonVO;
import com.philosopherzb.commonutil.mapstruct.converter.PersonConverter;

import java.util.Date;

/**
 * @author philosopherZB
 * @date 2022/8/29
 */
public class TestMapStruct {

    public static void main(String[] args) {
        PersonBO bo = new PersonBO();
        bo.setId(1);
        bo.setName("testName");
        bo.setAge(20);
        bo.setBirthday(new Date());
        bo.setGender("MALE");
        bo.setTestFiled("testFiled");

        PersonVO vo = PersonConverter.INSTANCE.boToVO(bo);
        System.out.println(JSONUtil.toJsonStr(vo));
        System.out.println(DateUtil.formatDateTime(vo.getBirthday()));
        System.out.println(vo.getGender().getDescription());
    }
}
