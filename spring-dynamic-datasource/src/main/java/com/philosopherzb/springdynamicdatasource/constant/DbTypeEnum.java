package com.philosopherzb.springdynamicdatasource.constant;

/**
 * author: philosopherZB
 * date: 2020/3/4
 */
public enum DbTypeEnum {
    READ_DB("read","读库"),
    WRITE_DB("write","写库");

    private String type;
    private String name;

    DbTypeEnum(String type,String name) {
        this.type = type;
        this.name = name;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
