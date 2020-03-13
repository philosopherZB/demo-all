package com.philosopherzb.commonutil.chain;

import com.philosopherzb.commonutil.chain.dto.TestDBDTO;
import com.philosopherzb.commonutil.chain.dto.TestDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * author: philosopherZB
 * date: 2020/3/13
 */
public class TwoChain implements BaseChain {

    @Override
    public TestDBDTO doSomething(TestDTO input, List<TestDBDTO> testDBDTOList, BaseChain baseChain) {
        List<TestDBDTO> testDBDTOs = new ArrayList<>();
        testDBDTOList.forEach(testDBDTO -> {
            if(StringUtils.isNotEmpty(input.getId()) && input.getId().equals(testDBDTO.getId())){
                testDBDTOs.add(testDBDTO);
                System.out.println("twoChain , id: " + input.getId());
            }
        });

        if (!CollectionUtils.isEmpty(testDBDTOs)){
            return baseChain.doSomething(input, testDBDTOs, baseChain);
        }
        return null;
    }
}
