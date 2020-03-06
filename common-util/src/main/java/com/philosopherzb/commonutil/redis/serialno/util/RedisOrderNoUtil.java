package com.philosopherzb.commonutil.redis.serialno.util;

import com.philosopherzb.commonutil.redis.serialno.constant.ConstantUtil;
import com.philosopherzb.commonutil.redis.serialno.constant.OrderNoTypeEnum;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * author: philosopherZB
 * date: 2020/1/8
 */
@Service
public class RedisOrderNoUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * @return 订单流水号
     */
    public String getOrderNo(){
        return this.getId(OrderNoTypeEnum.DEFAULT_ORDER);
    }

    /**
     * 获取批次流水号
     * @param orderNoTypeEnum 订单流水号枚举
     * @return 订单流水号
     */
    private String getId(OrderNoTypeEnum orderNoTypeEnum) {
        // 获得批次号前缀
        // 格式 固定前缀 + 时间前缀 示例 ：T20200108
        String formNoPrefix = this.getFormNoPrefix(orderNoTypeEnum);
        // 获得缓存key
        String cacheKey = this.getCacheKey(formNoPrefix);
        // 获得当日自增数,设置失效时间1天
        Long incr = getIncr(cacheKey);
        if (incr==0) {
            incr = getIncr(cacheKey);//从0000001开始
        }
        // 组合批次号并补全流水号
        String serialWithPrefix = this.completionSerial(formNoPrefix, incr, orderNoTypeEnum);
        // 补全随机数
        return this.completionRandom(serialWithPrefix, orderNoTypeEnum);
    }

    /**
     * redis自增序列号,并设置过期时间
     * @param key 缓存key
     * @return 自增值
     */
    private Long getIncr(String key) {

        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, Objects.requireNonNull(redisTemplate.getConnectionFactory()));
        long increment = entityIdCounter.getAndIncrement();

        if (increment == 0 &&  ConstantUtil.DEFAULT_CACHE_DAYS > 0) { //初始设置过期时间
            entityIdCounter.expire( ConstantUtil.DEFAULT_CACHE_DAYS, TimeUnit.DAYS); //单位毫秒
        }
        return increment;
    }

    /**
     * 生成单号前缀时间
     */
    private String getFormNoPrefix(OrderNoTypeEnum orderNoTypeEnum) {
        //格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(orderNoTypeEnum.getDatePattern());

        return formatter.format(LocalDateTime.now());

    }

    /**
     * 构建流水号缓存Key
     * @param serialPrefix 流水号前缀
     * @return 流水号缓存Key
     */
    private String getCacheKey(String serialPrefix) {
        return ConstantUtil.SERIAL_CACHE_PREFIX.concat(serialPrefix);
    }

    /**
     * 补全流水号
     * @param serialPrefix      单号前缀
     * @param incrementalSerial 当天自增流水号
     */
    private String completionSerial(String serialPrefix, Long incrementalSerial,
                                           OrderNoTypeEnum orderNoTypeEnum) {
        StringBuilder sb = new StringBuilder(serialPrefix);

        //需要补0的长度=流水号长度 -当日自增计数长度
        int length = orderNoTypeEnum.getSerialLength() - String.valueOf(incrementalSerial).length();
        //补零
        for (int i = 0; i < length; i++) {
            sb.append("0");
        }
        //redis当日自增数
        sb.append(incrementalSerial);
        return sb.toString();
    }


    /**
     * 补全随机数
     *
     * @param serialWithPrefix  当前单号
     * @param orderNoTypeEnum   单号生成枚举
     */
    private String completionRandom(String serialWithPrefix, OrderNoTypeEnum orderNoTypeEnum) {
        StringBuilder sb = new StringBuilder(serialWithPrefix);
        //随机数长度
        int length = orderNoTypeEnum.getRandomLength();
        if (length > 0) {
            Random random = new Random();
            for (int i = 0; i < length; i++) {
                //十以内随机数补全
                sb.append(random.nextInt(10));
            }
        }
        return sb.toString();
    }

}

