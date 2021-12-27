package com.philosopherzb.commonutil.i18n.config;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

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
@Component
public class NacosConfig {
    /**
     * Namespace
     */
    private String dNamespace;
    /**
     * server address
     */
    private String serverAddr;

    @Resource
    private MessageConfig messageConfig;

    @Resource
    private ConfigurableApplicationContext applicationContext;

    private static final String DEFAULT_GROUP = "DEFAULT_GROUP";

    @Autowired
    public void init() {
        serverAddr = applicationContext.getEnvironment().getProperty("spring.cloud.nacos.config.server-addr");
        dNamespace = applicationContext.getEnvironment().getProperty("spring.cloud.nacos.config.dNamespace");
        if (StringUtils.isEmpty(dNamespace)) {
            throw new IllegalArgumentException("dNamespace is empty");
        }
        initTip(null);
        initTip(Locale.CHINA);
        initTip(Locale.US);
        log.info("Initialization of system parameters succeeded!Nacos address:{},Prompt namespace:{}", serverAddr, dNamespace);
    }

    private void initTip(Locale locale) {
        String content;
        String dataId;
        ConfigService configService;
        try {
            if (locale == null) {
                dataId = messageConfig.getBasename() + ".properties";
            } else {
                dataId = messageConfig.getBasename() + "_" + locale.getLanguage() + "_" + locale.getCountry() + ".properties";
            }
            Properties properties = new Properties();
            properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
            properties.put(PropertyKeyConst.NAMESPACE, dNamespace);
            configService = NacosFactory.createConfigService(properties);
            content = configService.getConfig(dataId, DEFAULT_GROUP, 5000);
            if (StringUtils.isEmpty(content)) {
                log.warn("Configuration content is empty,Skip initialization!dataId:{}", dataId);
                return;
            }
            log.info("Initialize internationalization configuration!Configuration content:{}", content);
            saveAsFileWriter(dataId, content);
            setListener(configService, dataId, locale);
        } catch (Exception e) {
            log.error("Initialization internationalization configuration exception!Abnormal information:{}", e);
        }
    }

    private void setListener(ConfigService configService, String dataId, Locale locale) throws com.alibaba.nacos.api.exception.NacosException {
        configService.addListener(dataId, DEFAULT_GROUP, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                log.info("New internationalization configuration received!Configuration content:{}", configInfo);
                try {
                    initTip(locale);
                } catch (Exception e) {
                    log.error("Initialization internationalization configuration exception!Abnormal information:{}", e);
                }
            }

            @Override
            public Executor getExecutor() {
                return null;
            }
        });
    }

    private void saveAsFileWriter(String fileName, String content) {
        String path = System.getProperty("user.dir") + File.separator + messageConfig.getBaseFolder();
        try {
            fileName = path + File.separator + fileName;
            File file = new File(fileName);
            FileUtils.writeStringToFile(file, content, Charset.defaultCharset());
            log.info("Internationalization configuration updated!Local file path:{}", fileName);
        } catch (IOException e) {
            log.error("Initialization internationalization configuration exception!Local file path:{}Abnormal information:{}", fileName, e);
        }
    }
}
