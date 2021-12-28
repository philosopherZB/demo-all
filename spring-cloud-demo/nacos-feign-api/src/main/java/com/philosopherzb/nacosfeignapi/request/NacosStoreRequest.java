package com.philosopherzb.nacosfeignapi.request;

import java.io.Serializable;

/**
 * @author philosopherZB
 * @date 2021/12/28
 */
public class NacosStoreRequest implements Serializable {
    private static final long serialVersionUID = -70131990434941865L;

    private String id;

    private String name;

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
}
