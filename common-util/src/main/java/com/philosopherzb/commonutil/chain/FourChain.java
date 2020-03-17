package com.philosopherzb.commonutil.chain;

import com.philosopherzb.commonutil.chain.dto.TestDBDTO;
import com.philosopherzb.commonutil.chain.dto.TestDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * author: philosopherZB
 * date: 2020/3/16
 */
public class FourChain implements BaseChain {

    @Override
    public TestDBDTO doSomething(TestDTO input, List<TestDBDTO> testDBDTOList, BaseChain baseChain) {
        Iterator<TestDBDTO> it = testDBDTOList.iterator();
        while (it.hasNext()){
            TestDBDTO testDBDTO = it.next();
            if(StringUtils.isNotEmpty(input.getId()) && new BigDecimal(input.getId()).compareTo(new BigDecimal(testDBDTO.getId())) < 0){
                System.out.println("remove FourChain , id: " + testDBDTO.getId());
                it.remove();
            }
        }
        if (CollectionUtils.isEmpty(testDBDTOList)){
            return null;
        }
        return baseChain.doSomething(input, testDBDTOList, baseChain);
    }
}
