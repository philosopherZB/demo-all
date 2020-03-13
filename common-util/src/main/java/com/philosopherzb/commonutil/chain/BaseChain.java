package com.philosopherzb.commonutil.chain;

import com.philosopherzb.commonutil.chain.dto.TestDBDTO;
import com.philosopherzb.commonutil.chain.dto.TestDTO;

import java.util.List;

/**
 * author: philosopherZB
 * date: 2020/3/13
 */
public interface BaseChain {
    // 责任链上所有 链路 处理逻辑的方法
    TestDBDTO doSomething(TestDTO input, List<TestDBDTO> testDBDTOList, BaseChain baseChain);
}
