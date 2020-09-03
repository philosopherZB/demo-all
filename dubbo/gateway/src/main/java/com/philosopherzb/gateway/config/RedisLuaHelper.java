package com.philosopherzb.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

/**
 * author: philosopherZB
 * date: 2020/9/3
 */
@Component
public class RedisLuaHelper {

    @Bean
    public DefaultRedisScript<Long> redisLuaScript() {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("/lua/rateLimit.lua")));
        redisScript.setResultType(Long.class);
        return redisScript;
    }

}
