package com.philosopherzb.nacosfeignapi.vo;

import java.io.Serializable;

/**
 * @author philosopherZB
 * @date 2021/12/28
 */
public class NacosStoreVO implements Serializable {

    private static final long serialVersionUID = 7631997917966181028L;

    private String id;

    private String name;

    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
