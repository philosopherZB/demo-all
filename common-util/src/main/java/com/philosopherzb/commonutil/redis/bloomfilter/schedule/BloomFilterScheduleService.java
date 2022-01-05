package com.philosopherzb.commonutil.redis.bloomfilter.schedule;

import com.google.common.base.Charsets;
import com.google.common.hash.Funnel;
import com.philosopherzb.commonutil.redis.bloomfilter.util.BloomFilterHelper;
import com.philosopherzb.commonutil.redis.bloomfilter.util.RedisBloomFilterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author: philosopherZB
 * date: 2021/2/12
 */
@Service
public class BloomFilterScheduleService {
    private static final Logger logger = LoggerFactory.getLogger(BloomFilterScheduleService.class);
    @Resource
    private RedisBloomFilterUtil redisBloomFilterUtil;

//    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void test() {
        logger.info("ScheduleService.scheduleTask task begin");
        try {
//            add("1");
            if (exist("2")) {
                logger.info("exist");
            } else {
                logger.info("not exist");
            }
        } catch (Exception e) {
            logger.error("ScheduleService.scheduleTask occur exception, e:{}", e);
        }
    }

    private void add(String value) {
        // 申明了可以用于存放100数据的空间,且误差率为0.0001% 如果存入的数据大于了预先申请的空间，那么bloomFilter将会增加“误伤率”。
        BloomFilterHelper<String> myBloomFilterHelper = new BloomFilterHelper<>((Funnel<String>) (from, into) -> into.putString(from, Charsets.UTF_8).putString(from, Charsets.UTF_8), 100, 0.00001);
        redisBloomFilterUtil.addByBloomFilter(myBloomFilterHelper, "bloom", value);
    }

    private boolean exist(String target) {
        // 申明了可以用于存放100数据的空间,且误差率为0.0001% 如果存入的数据大于了预先申请的空间，那么bloomFilter将会增加“误伤率”。
        BloomFilterHelper<String> myBloomFilterHelper = new BloomFilterHelper<>((Funnel<String>) (from, into) -> into.putString(from, Charsets.UTF_8).putString(from, Charsets.UTF_8), 100, 0.00001);
        return redisBloomFilterUtil.includeByBloomFilter(myBloomFilterHelper, "bloom", target);
    }
}
