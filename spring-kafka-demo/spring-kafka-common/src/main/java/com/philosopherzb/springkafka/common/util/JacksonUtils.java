package com.philosopherzb.springkafka.common.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.PackageVersion;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author philosopherZB
 * @date 2021/4/21
 */
public class JacksonUtils {
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    private static final ObjectMapper JSON_MAPPER_UNKNOWN_FALSE = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private static final ObjectMapper JSON_MAPPER_DATE_PARSE = new ObjectMapper();

    static {
        JavaTimeModule timeModule = new JavaTimeModule();
        JSON_MAPPER.registerModule(timeModule);
        JSON_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // 添加时间转换的序列化类
        SimpleModule serializerModule = new SimpleModule("DateSerializer", PackageVersion.VERSION);
        serializerModule.addSerializer(Date.class, new CustomDateSerializer());
        serializerModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateUtils.DEFAULT_DATETIME_FORMATTER));
        JSON_MAPPER_DATE_PARSE.registerModule(serializerModule);
    }

    /**
     * date的序列化方式
     */
    static class CustomDateSerializer extends DateSerializer {
        private static final long serialVersionUID = 81981426178865416L;

        @Override
        public void serialize(Date value, JsonGenerator g, SerializerProvider provider) throws IOException {
            g.writeString(DateUtils.dateToStringByDefaultDateFormat(value));
        }
    }

    /**
     * 序列化对象为一个json字符串
     *
     * @param obj 需要序列化的对象
     * @return json字符串
     * @throws JsonProcessingException  json处理异常
     * @throws IllegalArgumentException 非法入参异常
     */
    public static String serialize(Object obj) throws JsonProcessingException, IllegalArgumentException {
        if (obj == null) {
            throw new IllegalArgumentException("serialize object is null");
        }
        return JSON_MAPPER.writeValueAsString(obj);
    }

    /**
     * 序列化的时候日期按照yyyy-MM-dd HH:mm:ss转化
     *
     * @param obj 需要序列化的对象
     * @return json字符串
     * @throws JsonProcessingException  json处理异常
     * @throws IllegalArgumentException 非法入参异常
     */
    public static String serializeOfDataParse(Object obj) throws JsonProcessingException, IllegalArgumentException {
        if (obj == null) {
            throw new IllegalArgumentException("serializeOfDataParse object is null");
        }
        return JSON_MAPPER_DATE_PARSE.writeValueAsString(obj);
    }

    /**
     * 反序列化json字符串为一个对象
     *
     * @param json       json字符串
     * @param objectType 指定转换对象
     * @param <T>        泛型
     * @return 转换后的对象
     * @throws IOException              json处理异常
     * @throws IllegalArgumentException 非法入参异常
     */
    public static <T> T deserialize(String json, Class<T> objectType) throws IOException, IllegalArgumentException {
        if (StringUtils.isBlank(json) || objectType == null) {
            throw new IllegalArgumentException("deserialize json or objectType is null");
        }
        return JSON_MAPPER.readValue(json, objectType);
    }

    /**
     * 通过typeReference反序列化json字符串为一个对象
     *
     * @param json          json字符串
     * @param typeReference 指定转换对象类型
     * @param <T>           泛型
     * @return 转换后的对象
     * @throws IOException              json处理异常
     * @throws IllegalArgumentException 非法入参异常
     */
    public static <T> T deserialize(String json, TypeReference<T> typeReference) throws IOException, IllegalArgumentException {
        if (StringUtils.isBlank(json) || typeReference == null) {
            throw new IllegalArgumentException("deserialize json or typeReference is null");
        }
        return JSON_MAPPER.readValue(json, typeReference);
    }

    /**
     * 字符串转换成对象 字符串中的一些未知字段不会报错
     *
     * @param json       json字符串
     * @param objectType 指定转换对象
     * @param <T>        泛型
     * @return 转换后的对象
     * @throws IOException              json处理异常
     * @throws IllegalArgumentException 非法入参异常
     */
    public static <T> T deserializeUnKnownFalse(String json, Class<T> objectType) throws IOException, IllegalArgumentException {
        if (StringUtils.isBlank(json) || objectType == null) {
            throw new IllegalArgumentException("deserialize json or objectType is null");
        }
        return JSON_MAPPER_UNKNOWN_FALSE.readValue(json, objectType);
    }

    /**
     * 反序列化数组，默认mapper
     *
     * @param json  json字符串
     * @param clazz 指定转换对象
     * @param <T>   泛型
     * @return 转换后的对象
     * @throws IOException              json处理异常
     * @throws IllegalArgumentException 非法入参异常
     */
    public static <T> List<T> deserializeArray(String json, Class<T> clazz) throws IOException, IllegalArgumentException {
        return deserializeArray(json, clazz, null);
    }

    /**
     * 反序列化数组，给定mapper
     *
     * @param json          json字符串
     * @param clazz         指定转换对象
     * @param <T>           泛型
     * @param jacksonMapper ObjectMapper对象
     * @return 转换后的对象
     * @throws IOException              json处理异常
     * @throws IllegalArgumentException 非法入参异常
     */
    public static <T> List<T> deserializeArray(String json, Class<T> clazz, ObjectMapper jacksonMapper) throws IOException, IllegalArgumentException {
        if (StringUtils.isBlank(json) || clazz == null) {
            throw new IllegalArgumentException("deserialize json or clazz is null");
        }
        ObjectMapper objectMapper = (jacksonMapper == null ? JSON_MAPPER : jacksonMapper);
        JavaType listType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
        return objectMapper.readValue(json, listType);
    }

    /**
     * get ObjectMapper
     *
     * @return ObjectMapper
     */
    public static ObjectMapper getJsonMapper() {
        return JSON_MAPPER;
    }
}
