package com.philosopherzb.commonutil.chain;

import com.philosopherzb.commonutil.chain.dto.TestDBDTO;
import com.philosopherzb.commonutil.chain.dto.TestDTO;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * author: philosopherZB
 * date: 2020/3/13
 */
public class HandleChain implements BaseChain {
    // 所有 case 列表
    private List<BaseChain> baseChainList = new ArrayList<>();

    // 索引，用于遍历所有 case 列表
    private int index = 0;

    // 添加 case
    public HandleChain addBaseCase(BaseChain baseChain) {
        baseChainList.add(baseChain);
        return this;
    }
    @Override
    public TestDBDTO doSomething(TestDTO input, List<TestDBDTO> testDBDTOList, BaseChain baseChain) {
        // 所有遍历完了，直接返回
        if (index == baseChainList.size()){
            System.out.println("--------chain--end------");
            if (!CollectionUtils.isEmpty(testDBDTOList)){
                // 返回id最大的
                Optional<TestDBDTO> testDBDTOOptional = testDBDTOList.stream().
                        filter(Objects::nonNull).
                        filter(testDBDTO -> testDBDTO.getId() != null).
                        max(Comparator.comparing(TestDBDTO :: getId));
                if (testDBDTOOptional.isPresent()){
                    return testDBDTOOptional.get();
                }
            }
        }
        // 获取当前 case
        BaseChain currentChain = baseChainList.get(index);
        // 修改索引值，以便下次回调获取下个节点，达到遍历效果
        index++;
        // 调用 当前 case 处理方法
        return currentChain.doSomething(input, testDBDTOList, this);
    }
}
