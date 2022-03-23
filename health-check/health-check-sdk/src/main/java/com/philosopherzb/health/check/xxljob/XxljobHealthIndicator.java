package com.philosopherzb.health.check.xxljob;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author philosopherZB
 * @date 2022/3/22
 */
@Slf4j
public class XxljobHealthIndicator extends AbstractHealthIndicator {

    private static final String DEFAULT_CACHE_KEY = "DEFAULT_CACHE_KEY";
    /**
     * 允许3秒左右的时间误差
     */
    private static final long TIME_OFFSET = 3L;

    private Cache<String, Long> cache;

    private final XxlJobHealthProperties xxlJobHealthProperties;

    public XxljobHealthIndicator(XxlJobHealthProperties xxlJobHealthProperties) {
        super("xxl-job health check failed");
        this.xxlJobHealthProperties = xxlJobHealthProperties;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        long currentTime = System.currentTimeMillis();
        Long value = cache.getIfPresent(DEFAULT_CACHE_KEY);
        if (value == null) {
            builder.down().withDetail("errorMsg", "No message received in the last "
                    + xxlJobHealthProperties.getCacheMaxTime() + " minutes, app or xxl-jb possible occur error");
            return;
        }

        long timeDiff = Math.abs(currentTime - value);
        long standard = (xxlJobHealthProperties.getExecuteInterval() + TIME_OFFSET) * 1000L;
        if (timeDiff < standard) {
            builder.up();
        } else {
            builder.down().withDetail("errorMsg", "time offset too big, standard value: " + (xxlJobHealthProperties.getExecuteInterval() + TIME_OFFSET) + "s");
        }
    }

    @PostConstruct
    private void init() {
        if (xxlJobHealthProperties.getExecuteInterval() > xxlJobHealthProperties.getCacheMaxTime() * 60L) {
            throw new IllegalArgumentException("xxl-job executeInterval more than cacheMaxTime, " +
                    "executeInterval: " + xxlJobHealthProperties.getExecuteInterval() +
                    ", cacheMaxTime: " + xxlJobHealthProperties.getCacheMaxTime() * 60L);
        }
        this.cache = Caffeine.newBuilder()
                .expireAfterWrite(xxlJobHealthProperties.getCacheMaxTime(), TimeUnit.MINUTES)
                .maximumSize(xxlJobHealthProperties.getCacheMaximumSize())
                .build();
    }

    /**
     * 注解配置：为Job方法添加注解 "@XxlJob(value="自定义jobhandler名称", init = "JobHandler初始化方法", destroy = "JobHandler销毁方法")"，
     * 注解value值对应的是调度中心新建任务的JobHandler属性的值。
     */
    @XxlJob("healthCheckJobHandler")
    public void healthCheckJobHandler() {
        log.debug("healthCheckJobHandler start...");
        XxlJobHelper.log("xxl-job health check");
        cache.put(DEFAULT_CACHE_KEY, System.currentTimeMillis());
    }
}
