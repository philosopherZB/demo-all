package com.philosopherzb.commonutil.async.config;

import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.lang.reflect.Method;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: philosopherZB
 * date: 2020/11/24
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        Method[] methods = BatchProperties.Job.class.getMethods();
        int defaultPooSize = 3;
        int corePoolSize = 0;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        if (methods.length > 0) {
            for (Method method : methods) {
                Scheduled annotation = method.getAnnotation(Scheduled.class);
                if (annotation != null) {
                    atomicInteger.incrementAndGet();
                }
            }
            corePoolSize = atomicInteger.intValue();
            if (defaultPooSize > corePoolSize || corePoolSize > 15) {
                corePoolSize = defaultPooSize;
            }
        }
        scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(corePoolSize));
    }
}
