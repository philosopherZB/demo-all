package com.philosopherzb.springdynamicdatasource.datasource;

import com.philosopherzb.springdynamicdatasource.constant.DbTypeEnum;

/**
 * author: philosopherZB
 * date: 2020/3/4
 * 读写库路由key
 */
public class DataSourceContextHolder {

    // 开启多个线程，每个线程进行初始化一个数据源
    private static final ThreadLocal<DbTypeEnum> contextHolder = new InheritableThreadLocal<>();

    /**
     *  设置数据源
     * @param dbTypeEnum 数据源
     */
    public static void setDataSource(DbTypeEnum dbTypeEnum){
        contextHolder.set(dbTypeEnum);
    }

    /**
     * @return 当前数据源
     */
    public static DbTypeEnum getDataSource(){
        return contextHolder.get() == null ? DbTypeEnum.READ_DB : contextHolder.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clear(){
        contextHolder.remove();
    }
}
