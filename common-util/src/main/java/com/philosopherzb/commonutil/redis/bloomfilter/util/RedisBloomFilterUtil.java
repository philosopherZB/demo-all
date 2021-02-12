package com.philosopherzb.commonutil.redis.bloomfilter.util;

import com.google.common.base.Preconditions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * author: philosopherZB
 * date: 2021/2/12
 */
@Component
public class RedisBloomFilterUtil {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 根据给定的布隆过滤器添加值
     */
    public <T> void addByBloomFilter(BloomFilterHelper<T> bloomFilterHelper, String key, T value) {
        Preconditions.checkArgument(bloomFilterHelper != null, "bloomFilterHelper is empty");
        int[] offset = bloomFilterHelper.murmurHashOffset(value);
        for (int i : offset) {
            stringRedisTemplate.opsForValue().setBit(key, i, true);
        }
    }

    /**
     * 根据给定的布隆过滤器判断值是否存在
     */
    public <T> boolean includeByBloomFilter(BloomFilterHelper<T> bloomFilterHelper, String key, T value) {
        Preconditions.checkArgument(bloomFilterHelper != null, "bloomFilterHelper is empty");
        int[] offset = bloomFilterHelper.murmurHashOffset(value);
        for (int i : offset) {
            if (stringRedisTemplate.opsForValue().getBit(key, i) == null || !stringRedisTemplate.opsForValue().getBit(key, i)) {
                return false;
            }
        }
        return true;
    }
}
