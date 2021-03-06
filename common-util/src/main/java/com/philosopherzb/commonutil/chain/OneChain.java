package com.philosopherzb.commonutil.chain;

import com.philosopherzb.commonutil.chain.dto.TestDBDTO;
import com.philosopherzb.commonutil.chain.dto.TestDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * author: philosopherZB
 * date: 2020/3/13
 */
public class OneChain implements BaseChain {

    @Override
    public TestDBDTO doSomething(TestDTO input, List<TestDBDTO> testDBDTOList, BaseChain baseChain) {
        testDBDTOList.removeIf(testDBDTO -> StringUtils.isNotEmpty(input.getAge()) && !input.getAge().equals(testDBDTO.getAge()));
        if (CollectionUtils.isEmpty(testDBDTOList)){
            return null;
        }
        return baseChain.doSomething(input, testDBDTOList, baseChain);
    }
}
