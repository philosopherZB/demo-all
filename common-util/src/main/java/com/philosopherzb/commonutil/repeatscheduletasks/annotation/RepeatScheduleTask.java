package com.philosopherzb.commonutil.repeatscheduletasks.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

import static java.lang.annotation.ElementType.*;

/**
 * 针对集群模式，定时任务重复执行定义的注解，用作aop
 * author: philosopherZB
 * date: 2020/3/4
 */
@Target({TYPE, FIELD, METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatScheduleTask {

    String lockName() default "";

    long waitTime();

    long leaseTime();

    TimeUnit timeUnit();

}
