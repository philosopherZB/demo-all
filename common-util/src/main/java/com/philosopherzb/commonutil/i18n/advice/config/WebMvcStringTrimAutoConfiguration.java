package com.philosopherzb.commonutil.i18n.advice.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.io.IOException;

/**
 * 自动剔除字符串前后空格
 *
 * @author philosopherZB
 * @date 2022/2/23
 */
@Configuration
public class WebMvcStringTrimAutoConfiguration {
    /**
     * 自动剔除url，requestParam等中string参数的前后空格
     */
    @ControllerAdvice
    public static class ControllerStringParamTrimConfig {

        @InitBinder
        public void initBinder(WebDataBinder binder) {
            // 创建 String trim 编辑器
            // 构造方法中 boolean 参数含义为如果是空白字符串,是否转换为null
            // 即如果为true,那么 " " 会被转换为 null,否者为 ""
            StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(false);
            // 为 String 类对象注册编辑器
            binder.registerCustomEditor(String.class, stringTrimmerEditor);
        }
    }

    /**
     * 自动剔除json入参中string参数的前后空格
     *
     * @return jackson2ObjectMapperBuilderCustomizer
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder
                .deserializerByType(String.class, new StdScalarDeserializer<String>(String.class) {
                    private static final long serialVersionUID = -4631539573353286524L;

                    @Override
                    public String deserialize(JsonParser jsonParser, DeserializationContext ctx)
                            throws IOException {
                        return StringUtils.trim(jsonParser.getValueAsString());
                    }
                });
    }
}
