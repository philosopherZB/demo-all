package com.philosopherzb.elasticsearch.schedule;

import com.philosopherzb.elasticsearch.bo.SearchBO;
import com.philosopherzb.elasticsearch.bo.StudentBO;
import com.philosopherzb.elasticsearch.manager.StudentManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author philosopherZB
 * @date 2021/10/22
 */
@Slf4j
@Service
public class ScheduleService {

    @Resource
    private StudentManager studentManager;

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void task() {
//        String jsonMapping = "{\n" +
//                "    \"properties\": {\n" +
//                "        \"id\": {\n" +
//                "            \"type\": \"long\"\n" +
//                "        },\n" +
//                "        \"name\": {\n" +
//                "            \"type\": \"text\"\n" +
//                "        },\n" +
//                "        \"age\": {\n" +
//                "            \"type\": \"integer\"\n" +
//                "        },\n" +
//                "        \"description\": {\n" +
//                "            \"type\": \"keyword\",\n" +
//                "            \"index\": false\n" +
//                "        },\n" +
//                "        \"createTime\": {\n" +
//                "            \"type\": \"long\"\n" +
//                "        }\n" +
//                "    }\n" +
//                "}";
//        log.info("result: {}", studentManager.createIndex("student_demo", jsonMapping));

//        log.info("result: {}", studentManager.createIndex("student", ""));

//        log.info("result: {}", studentManager.deleteIndex("student"));

//        StudentBO studentBO = new StudentBO();
//        studentBO.setId(3L);
//        studentBO.setName("testName3");
//        studentBO.setAge(24);
//        studentBO.setDescription("description info-4");
//        studentBO.setCreateTime(System.currentTimeMillis());
//        log.info("result: {}", studentManager.insertByIndexName("student", JSONObject.toJSONString(studentBO)));

//        log.info("result: {}", studentManager.updateById("student", JSONObject.toJSONString(studentBO), "Yy_AtnwB0DZSv_uLBQk6"));

//        List<StudentBO> studentBOList = studentManager.searchByIndexName("student", StudentBO.class);
//        log.info("result: {}", CollectionUtils.isEmpty(studentBOList) ? "empty" : studentBOList.toString());

        SearchBO searchBO = new SearchBO();
        searchBO.setId(1L);
        searchBO.setName("testName");
        searchBO.setIndexName("student");
        searchBO.setSize(2);
        searchBO.setStartTime(1635151531415L);
        List<StudentBO> studentBOList = studentManager.search(searchBO);
        log.info("size: {}, result: {}", studentBOList.size(), CollectionUtils.isEmpty(studentBOList) ? "empty" : studentBOList.toString());

        StudentBO studentBO = studentManager.getById("student", "Yi-ktnwB0DZSv_uLawkd", StudentBO.class);
        log.info("result: {}", studentBO == null ? "empty" : studentBO.toString());

    }
}
