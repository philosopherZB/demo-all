package com.philosopherzb.elasticsearch.manager;

import com.alibaba.fastjson.JSONObject;
import com.philosopherzb.elasticsearch.bo.SearchBO;
import com.philosopherzb.elasticsearch.bo.StudentBO;
import com.philosopherzb.elasticsearch.service.BaseElasticsearchService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author philosopherZB
 * @date 2021/10/25
 */
@Slf4j
@Component
public class StudentManager extends BaseElasticsearchService {

    private static final String CREATE_TIME = "createTime";
    private static final String ID = "id";
    // ElasticSearch 5.0以后，String字段被拆分成两种新的数据类型: text用于全文搜索，会分词,而keyword用于关键词搜索，不进行分词。
    // 对于字符串类型的字段，ES默认会再生成一个keyword字段用于精确索引，默认mapping格式如下：
    // "name" : {
    //          "type" : "text",
    //          "fields" : {
    //            "keyword" : {
    //              "type" : "keyword",
    //              "ignore_above" : 256
    //            }
    //          }
    //        }
    // 故此处字段名设置为 name.keyword 表示不分词查询；如果使用 name 则表示分词查询(对应可以使用matchPhraseQuery短语匹配)
    private static final String NAME = "name.keyword";
    private static final long DURATION = 60;

    /**
     * 根据条件查询数据
     *
     * @param searchBO 查询条件类
     * @return 查询结果
     */
    public List<StudentBO> search(SearchBO searchBO) {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // termQuery: 完全匹配; matchPhraseQuery: 短语匹配
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (searchBO.getId() != null && searchBO.getName() != null) {
            boolQueryBuilder.must(QueryBuilders.termQuery(ID, searchBO.getId()))
                    .must(QueryBuilders.termQuery(NAME, searchBO.getName()));
        }
        // 时间范围
        boolQueryBuilder.must(QueryBuilders.rangeQuery(CREATE_TIME)
                .gte(searchBO.getStartTime())
                .lt(System.currentTimeMillis()));
        sourceBuilder.query(boolQueryBuilder);

        // 分页与超时
        sourceBuilder.size(searchBO.getSize());
        sourceBuilder.timeout(new TimeValue(DURATION, TimeUnit.SECONDS));

        // 排序
        sourceBuilder.sort(new FieldSortBuilder(CREATE_TIME).order(SortOrder.ASC));

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(searchBO.getIndexName());
        searchRequest.source(sourceBuilder);
        try {
            SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            if (response.status() == RestStatus.OK) {
                SearchHit[] searchHits = response.getHits().getHits();
                if (searchHits.length > 0) {
                    List<StudentBO> resultList = new ArrayList<>(searchHits.length);
                    for (SearchHit searchHit : searchHits) {
                        resultList.add(JSONObject.parseObject(searchHit.getSourceAsString(), StudentBO.class));
                    }
                    return resultList;
                }
            }
        } catch (IOException | ElasticsearchException e) {
            log.error("search occur Exception: ", e);
        }
        return Collections.emptyList();
    }
}
