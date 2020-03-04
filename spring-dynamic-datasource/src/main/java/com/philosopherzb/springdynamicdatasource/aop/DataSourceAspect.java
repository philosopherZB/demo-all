package com.philosopherzb.springdynamicdatasource.aop;

import com.philosopherzb.springdynamicdatasource.annotation.DataSource;
import com.philosopherzb.springdynamicdatasource.datasource.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * author: philosopherZB
 * date: 2020/3/4
 */
@Component
@Slf4j
@Aspect
@Order(-1)
public class DataSourceAspect {

    @Pointcut("@within(com.philosopherzb.springdynamicdatasource.annotation.DataSource) || @annotation(com.philosopherzb.springdynamicdatasource.annotation.DataSource)")
    public void pointCut(){

    }

    @Before("pointCut() && @annotation(dataSource)")
    public void doBefore(DataSource dataSource){
        log.info("DataSourceAspect.doBefore current dataSource:{}", dataSource.value());
        DataSourceContextHolder.setDataSource(dataSource.value());
    }

    @After("pointCut()")
    public void doAfter(){
        DataSourceContextHolder.clear();
    }
}
