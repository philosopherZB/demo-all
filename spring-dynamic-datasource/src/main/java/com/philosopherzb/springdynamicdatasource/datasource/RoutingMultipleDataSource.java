package com.philosopherzb.springdynamicdatasource.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * author: philosopherZB
 * date: 2020/3/4
 * 多库路由
 */
public class RoutingMultipleDataSource extends AbstractRoutingDataSource {
    private static final Logger logger = LoggerFactory.getLogger(RoutingMultipleDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        String dateSource =  DataSourceContextHolder.getDataSource().getValue();
        logger.info("RoutingMultipleDataSource.determineCurrentLookupKey current datasource:{}",dateSource);
        return dateSource;
    }
}
