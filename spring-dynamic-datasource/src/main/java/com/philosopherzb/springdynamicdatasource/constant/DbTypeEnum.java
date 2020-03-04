package com.philosopherzb.springdynamicdatasource.constant;

/**
 * author: philosopherZB
 * date: 2020/3/4
 */
public enum DbTypeEnum {
    READ_DB("read"),
    WRITE_DB("write");

    private String value;

    DbTypeEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
