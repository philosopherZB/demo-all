package com.philosopherzb.springdynamicdatasource.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * author: philosopherZB
 * date: 2020/3/4
 * 多库路由
 */
public class RoutingMultipleDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource().getType();
    }
}
