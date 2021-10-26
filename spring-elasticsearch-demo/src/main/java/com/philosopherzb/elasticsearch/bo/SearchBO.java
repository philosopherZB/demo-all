package com.philosopherzb.elasticsearch.bo;

import lombok.Data;

/**
 * @author philosopherZB
 * @date 2021/10/25
 */
@Data
public class SearchBO {

    private Integer size;

    /**
     * 13位时间戳
     */
    private Long startTime;

    private String indexName;

    private Long id;

    private String name;
}
