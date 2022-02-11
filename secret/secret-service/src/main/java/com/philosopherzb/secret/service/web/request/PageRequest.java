package com.philosopherzb.secret.service.web.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @author philosopherZB
 * @date 2021/12/17
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageRequest implements Serializable {
    private static final long serialVersionUID = 7436322697743001110L;

    /**
     * 页数
     */
    private Integer pageNo;

    /**
     * 分页条数
     */
    private Integer pageSize;

    private static final Integer DEFAULT_PAGE_NO = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 10;

    public void calcPage() {
        this.pageNo = this.pageNo == null || this.pageNo < 1 ? DEFAULT_PAGE_NO : this.pageNo;
        this.pageSize = this.pageSize == null || this.pageSize < 1 ? DEFAULT_PAGE_SIZE : this.pageSize;
    }
}
