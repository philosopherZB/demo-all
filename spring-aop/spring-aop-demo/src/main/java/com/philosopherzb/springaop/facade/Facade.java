package com.philosopherzb.springaop.facade;

import com.philosopherzb.springaop.dto.ApiRequest;
import com.philosopherzb.springaop.util.Result;

/**
 * author: philosopherZB
 * date: 2019/12/25
 */
public interface Facade {
    Result callGateway(ApiRequest request);
}
