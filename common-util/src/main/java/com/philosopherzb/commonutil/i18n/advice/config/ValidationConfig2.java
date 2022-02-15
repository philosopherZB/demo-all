package com.philosopherzb.commonutil.i18n.advice.config;

import com.philosopherzb.commonutil.i18n.util.PropertiesTools;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.validation.MessageInterpolator;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 此配置器对于 javax.validation.constraints 中的message的格式要求为el形式，或者分隔符
 * eg:  @NotBlank(message = "{PARAM_INVALID}")
 * eg:  @NotBlank(message = "prefix-{PARAM_INVALID}-suffix")
 * 其中 PARAM_INVALID 为配置文件中的key
 * <p>
 * eg:  @NotBlank(message = I18nConstant.PARAM_IS_NULL_BY_SEPARATE + "orderSource")
 * 其中 18nConstant.PARAM_IS_NULL_BY_SEPARATE 是一个组合字符串，由 PARAM_IS_NULL_BY + SEPARATE构成
 * PARAM_IS_NULL_BY为配置文件中的key，而orderSource则为对应的字段名
 *
 * @author philosopherZB
 * @date 2022/2/15
 */
@Configuration
public class ValidationConfig2 {

    private static final Pattern MESSAGE_PATTERN = Pattern.compile("(?<=\\{)[^}]*(?=})");

    @Bean
    @Primary
    public Validator localValidator() {
        return Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new I18nMessageInterpolator())
                .buildValidatorFactory()
                .getValidator();
    }

    static class I18nMessageInterpolator implements MessageInterpolator {
        @Override
        public String interpolate(String s, Context context) {
            return interpolate(s, context, null);
        }

        @Override
        public String interpolate(String s, Context context, Locale locale) {
            if (s.contains(I18nConstant.SEPARATE)) {
                String[] split = s.split(I18nConstant.SEPARATE);
                return PropertiesTools.getProperties(split[0], split[1]);
            }
            Matcher matcher = MESSAGE_PATTERN.matcher(s);
            if (matcher.find()) {
                String temp = PropertiesTools.getProperties(matcher.group());
                return s.replaceFirst("\\{".concat(matcher.group()).concat("\\}"), temp);
            }
            return PropertiesTools.getProperties(s);
        }
    }
}
