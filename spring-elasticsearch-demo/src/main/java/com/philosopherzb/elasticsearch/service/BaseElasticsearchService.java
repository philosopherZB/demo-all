package com.philosopherzb.elasticsearch.service;

import com.alibaba.fastjson.JSONObject;
import com.philosopherzb.elasticsearch.config.ElasticsearchProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 参考: https://www.elastic.co/guide/en/elasticsearch/client/java-rest/7.15/java-rest-high.html
 *
 * @author philosopherZB
 * @date 2021/10/22
 */
@Slf4j
public abstract class BaseElasticsearchService {

    @Resource
    protected RestHighLevelClient restHighLevelClient;
    @Resource
    private ElasticsearchProperties properties;

    /**
     * 创建索引
     *
     * @param indexName   索引名
     * @param jsonMapping 索引mapping设置
     * @return 操作结果
     */
    public boolean createIndex(String indexName, String jsonMapping) {
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        request.settings(Settings.builder()
                .put("index.number_of_shards", properties.getIndexShards())
                .put("index.number_of_replicas", properties.getIndexReplicas())
        );
        if (StringUtils.isNotBlank(jsonMapping)) {
            request.mapping(jsonMapping, XContentType.JSON);
        }
        try {
            if (indexExist(indexName)) {
                log.info("index exist");
                return true;
            } else {
                CreateIndexResponse response = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
                return response.isAcknowledged() && response.isShardsAcknowledged();
            }
        } catch (IOException | ElasticsearchException e) {
            log.error("createIndex occur Exception: ", e);
            return false;
        }
    }

    /**
     * 删除指定索引
     *
     * @param indexName 索引名
     * @return 操作结果
     */
    public boolean deleteIndex(String indexName) {
        DeleteIndexRequest request = new DeleteIndexRequest(indexName);
        // 索引存在再删除
        if (indexExist(indexName)) {
            try {
                AcknowledgedResponse response = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
                return response.isAcknowledged();
            } catch (IOException | ElasticsearchException e) {
                log.error("deleteIndex occur Exception: ", e);
            }
        }
        return false;
    }

    /**
     * 在指定索引下新增数据
     *
     * @param indexName  索引名
     * @param jsonString json数据体
     * @return 操作结果
     */
    public boolean insertByIndexName(String indexName, String jsonString) {
        IndexRequest request = new IndexRequest(indexName);
        request.source(jsonString, XContentType.JSON);
        // 在指定索引下新增数据
        if (indexExist(indexName)) {
            try {
                IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
                return response.getResult() == DocWriteResponse.Result.CREATED;
            } catch (IOException | ElasticsearchException e) {
                log.error("insertByIndexName occur Exception: ", e);
            }
        }
        return false;
    }

    /**
     * 新增数据
     * 如果索引存在，则直接插入数据
     * 如果索引不存在，将先创建索引再插入数据
     *
     * @param indexName  索引名
     * @param jsonString json数据体
     * @return 操作结果
     */
    public boolean insertDateAndCreateIndex(String indexName, String jsonString) {
        IndexRequest request = new IndexRequest(indexName);
        request.source(jsonString, XContentType.JSON);
        try {
            // 如果索引存在，则直接插入数据
            // 如果索引不存在，将先创建索引再插入数据
            IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
            return response.getResult() == DocWriteResponse.Result.CREATED;
        } catch (IOException | ElasticsearchException e) {
            log.error("insertDateAndCreateIndex occur Exception: ", e);
        }
        return false;
    }

    /**
     * 通过id更新数据
     * 如果索引存在，则直接插入数据
     * 如果索引不存在，将先创建索引再插入数据
     *
     * @param indexName  索引名
     * @param jsonString json数据体
     * @param id         id
     * @return 操作结果
     */
    public boolean updateByIdAndCreateIndex(String indexName, String jsonString, String id) {
        UpdateRequest request = new UpdateRequest(indexName, id);
        request.doc(jsonString, XContentType.JSON);
        try {
            UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
            return response.getResult() == DocWriteResponse.Result.UPDATED;
        } catch (IOException | ElasticsearchException e) {
            log.error("updateByIdAndCreateIndex occur Exception: ", e);
        }
        return false;
    }

    /**
     * 通过id更新数据
     *
     * @param indexName  索引名
     * @param jsonString json数据体
     * @param id         id
     * @return 操作结果
     */
    public boolean updateById(String indexName, String jsonString, String id) {
        UpdateRequest request = new UpdateRequest(indexName, id);
        request.doc(jsonString, XContentType.JSON);
        if (indexExist(indexName)) {
            try {
                UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
                return response.getResult() == DocWriteResponse.Result.UPDATED;
            } catch (IOException | ElasticsearchException e) {
                log.error("updateById occur Exception: ", e);
            }
        }
        return false;
    }

    /**
     * 批量删除
     *
     * @param indexName 索引名
     * @param idList    id列表
     * @param <T>       泛型
     */
    public <T> void deleteBatch(String indexName, Collection<T> idList) {
        BulkRequest request = new BulkRequest();
        idList.forEach(item -> request.add(new DeleteRequest(indexName, item.toString())));
        try {
            BulkResponse responses = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
            for (BulkItemResponse bulkItemResponse : responses) {
                if (bulkItemResponse.isFailed()) {
                    BulkItemResponse.Failure failure = bulkItemResponse.getFailure();
                    log.info("deleteBatch failure:{}", failure.toString());
                }
            }
        } catch (Exception e) {
            log.error("deleteBatch occur Exception: ", e);
        }
    }

    /**
     * 根据索引名及id查询对应的列表数据
     *
     * @param indexName 索引名
     * @param clazz     covert type
     * @param <T>       泛型
     * @return 转换为指定clazz的对象
     */
    public <T> T getById(String indexName, String id, Class<T> clazz) {
        GetRequest request = new GetRequest(indexName);
        request.id(id);
        try {
            GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
            if (response.isExists()) {
                return JSONObject.parseObject(response.getSourceAsString(), clazz);
            }
        } catch (IOException | ElasticsearchException e) {
            log.error("getById occur Exception: ", e);
        }
        return null;
    }

    /**
     * 根据索引名查询对应的列表数据
     *
     * @param indexName 索引名
     * @param clazz     covert type
     * @param <T>       泛型
     * @return 转换为指定clazz的列表
     */
    public <T> List<T> searchByIndexName(String indexName, Class<T> clazz) {
        SearchRequest searchRequest = new SearchRequest(indexName);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        try {
            SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            if (response.status() == RestStatus.OK) {
                SearchHit[] searchHits = response.getHits().getHits();
                if (searchHits.length > 0) {
                    List<T> resultList = new ArrayList<>(searchHits.length);
                    for (SearchHit searchHit : searchHits) {
                        resultList.add(JSONObject.parseObject(searchHit.getSourceAsString(), clazz));
                    }
                    return resultList;
                }
            }
        } catch (IOException | ElasticsearchException e) {
            log.error("searchByIndexName occur Exception: ", e);
        }
        return Collections.emptyList();
    }

    /**
     * 索引是否存在
     *
     * @param indexName 索引名
     * @return 索引是否存在
     */
    private boolean indexExist(String indexName) {
        GetIndexRequest request = new GetIndexRequest(indexName);
        // true-返回本地信息, false-从主节点获取状态 Whether to return local information or retrieve the state from master node
        request.local(false);
        // Return result in a format suitable for humans
        request.humanReadable(true);
        // Whether to return all default setting for each of the indices
        request.includeDefaults(false);
        // 控制不可用索引的解析方式以及通配符表达式的扩展方式, 详情见 IndicesOptions.txt
        request.indicesOptions(IndicesOptions.STRICT_SINGLE_INDEX_NO_EXPAND_FORBID_CLOSED);
        try {
            return restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        } catch (IOException | ElasticsearchException e) {
            log.error("indexExist occur Exception: ", e);
            return false;
        }
    }
}
