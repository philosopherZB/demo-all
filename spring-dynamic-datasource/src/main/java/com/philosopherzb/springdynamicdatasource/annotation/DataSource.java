package com.philosopherzb.springdynamicdatasource.annotation;

import com.philosopherzb.springdynamicdatasource.constant.DbTypeEnum;

import java.lang.annotation.*;

/**
 * author: philosopherZB
 * date: 2020/3/4
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface  DataSource {

    DbTypeEnum value() default DbTypeEnum.READ_DB;
}
