package com.philosopherzb.commonutil.http.resttemplate.other;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author philosopherZB
 * @date 2021/12/22
 */
@Slf4j
@Service
public class ScheduleRestTemplateService {

    @Resource
    private RestTemplate restTemplate;

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void test() {

        try {
            String host = "127.0.0.1:9200";
            String url = "http://" + host + "/_cluster/health";
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
            log.info("call es api response result: {}", responseEntity.toString());

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                if (StringUtils.isNotBlank(responseEntity.getBody())) {
                    JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
                    log.info("responseEntity.getBody:{}", jsonObject.toJSONString());
                }
            } else {
                log.info("call api failure");
            }
        } catch (RestClientException e) {
            log.error("call es api exception, e: ", e);
        }
    }
}
