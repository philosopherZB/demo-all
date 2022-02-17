package com.philosopherzb.i18n;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author philosopherZB
 * @date 2021/12/15
 */
@Slf4j
@EnableConfigurationProperties(MessageProperties.class)
@ConditionalOnProperty(prefix = "spring.messages", value = "mode", havingValue = I18NMessageMode.NACOS)
public class NacosConfig {
    /**
     * Namespace
     */
    private String namespace;
    /**
     * server address
     */
    private String serverAddress;
    /**
     * nacos group
     */
    private String group;

    /**
     * nacos DEFAULT_GROUP
     */
    private static final String DEFAULT_GROUP = "DEFAULT_GROUP";
    /**
     * nacos config read time
     */
    private static final long NACOS_TIMEOUT_MS = 5000;


    @Resource
    private MessageProperties messageProperties;

    @PostConstruct
    public void init() {
        this.checkAndSet();
        initTip(null);
        LocaleParamManager.LOCALES.forEach(this::initTip);
        log.info("Initialization of system parameters, Nacos address:{}, Prompt namespace:{}, group:{}", serverAddress, namespace, group);
    }

    private void initTip(Locale locale) {
        String content;
        String dataId;
        ConfigService configService;
        try {
            if (locale == null) {
                dataId = messageProperties.getBasename() + ".properties";
            } else {
                dataId = messageProperties.getBasename() + "_" + locale.getLanguage() + "_" + locale.getCountry() + ".properties";
            }
            Properties properties = new Properties();
            properties.put(PropertyKeyConst.SERVER_ADDR, serverAddress);
            properties.put(PropertyKeyConst.NAMESPACE, namespace);
            configService = NacosFactory.createConfigService(properties);
            content = configService.getConfig(dataId, group, NACOS_TIMEOUT_MS);
            if (StringUtils.isEmpty(content)) {
                log.warn("Configuration content is empty,Skip initialization!dataId:{}", dataId);
                return;
            }
            log.info("Initialize i18n configuration! Configuration content:{}", content);
            saveAsFileWriter(dataId, content);
            setListener(configService, dataId, locale);
        } catch (Exception e) {
            log.error("Initialization i18n configuration exception! e: ", e);
        }
    }

    private void setListener(ConfigService configService, String dataId, Locale locale) throws com.alibaba.nacos.api.exception.NacosException {
        configService.addListener(dataId, group, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                log.debug("New i18n configuration received! Configuration content:{}", configInfo);
                try {
                    initTip(locale);
                } catch (Exception e) {
                    log.error("Initialization i18n configuration exception! e: ", e);
                }
            }

            @Override
            public Executor getExecutor() {
                return null;
            }
        });
    }

    private void saveAsFileWriter(String fileName, String content) {
        String path = System.getProperty("user.dir") + File.separator + messageProperties.getBaseFolder();
        try {
            fileName = path + File.separator + fileName;
            File file = new File(fileName);
            FileUtils.writeStringToFile(file, content, Charset.defaultCharset());
            log.debug("Internationalization configuration updated! Local file path:{}", fileName);
        } catch (IOException e) {
            log.error("Initialization i18n configuration exception! Local file path:{}, e:{}", fileName, e);
        }
    }

    /**
     * 校验参数完整性，并设值
     */
    private void checkAndSet() {
        serverAddress = messageProperties.getServerAddress();
        namespace = messageProperties.getNamespace();
        group = messageProperties.getGroup();
        if (StringUtils.isBlank(serverAddress)) {
            throw new IllegalArgumentException("spring.messages.serverAddress value is empty");
        }
        if (StringUtils.isBlank(namespace)) {
            throw new IllegalArgumentException("spring.messages.namespace value is empty");
        }
        if (StringUtils.isBlank(messageProperties.getBasename())) {
            throw new IllegalArgumentException("spring.messages.basename value is empty");
        }
        if (StringUtils.isBlank(group)) {
            group = DEFAULT_GROUP;
        }
    }
}
