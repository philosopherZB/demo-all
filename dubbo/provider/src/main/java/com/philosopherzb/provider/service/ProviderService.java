package com.philosopherzb.provider.service;

import com.philosopherzb.common.request.BizApiRequest;
import com.philosopherzb.common.response.BizApiResponse;

/**
 * author: philosopherZB
 * date: 2020/7/29
 */
public interface ProviderService {
    void test();

    BizApiResponse getInfo(BizApiRequest bizApiRequest);
}
