package com.philosopherzb.springdynamicdatasource.annotation;

import com.philosopherzb.springdynamicdatasource.constant.DbTypeEnum;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * author: philosopherZB
 * date: 2020/3/4
 */
@Target({TYPE, FIELD, METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface  DataSource {

    DbTypeEnum value() default DbTypeEnum.READ_DB;
}
