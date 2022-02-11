package com.philosopherzb.secret.sdk.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author philosopherZB
 * @date 2022/1/18
 */
public class DasLogger {
    private static final Log log = LogFactory.getLog("das-sdk");
    private static final String LOG_SPLIT = "^_^";

    private static String osName = System.getProperties().getProperty("os.name");
    private static boolean needEnableLogger = true;

    public static void setNeedEnableLogger(boolean needEnableLogger) {
        DasLogger.needEnableLogger = needEnableLogger;
    }

    public static void logApiError(String appId, String apiName, String url, String params, String errorMessage) {
        if (!needEnableLogger) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getCurrentTimeByFormat());// 时间
        sb.append(LOG_SPLIT);
        sb.append(appId);// APP
        sb.append(LOG_SPLIT);
        sb.append(apiName);// API
        sb.append(LOG_SPLIT);
        sb.append(DasUtils.getIntranetIp());// IP地址
        sb.append(LOG_SPLIT);
        sb.append(osName);// 操作系统
        sb.append(LOG_SPLIT);
        sb.append(url);// 请求URL
        sb.append(LOG_SPLIT);
        sb.append(params);// 请求参数
        sb.append(LOG_SPLIT);
        sb.append(errorMessage);// 错误信息
        log.error(sb.toString());
    }

    public static void logBizDebug(String errorMessage) {
        if (!needEnableLogger) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getCurrentTimeByFormat());// 时间
        sb.append(LOG_SPLIT);
        sb.append(DasUtils.getIntranetIp());// IP地址
        sb.append(LOG_SPLIT);
        sb.append(osName);// 操作系统
        sb.append(LOG_SPLIT);
        sb.append(errorMessage);// 错误信息
        log.debug(sb.toString());
    }

    public static void logBizDebug(Throwable t) {
        if (!needEnableLogger) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getCurrentTimeByFormat());// 时间
        sb.append(LOG_SPLIT);
        sb.append(DasUtils.getIntranetIp());// IP地址
        sb.append(LOG_SPLIT);
        sb.append(osName);// 操作系统
        log.debug(sb, t);
    }

    public static void logBizDebug(String msg, Throwable t) {
        if (!needEnableLogger) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getCurrentTimeByFormat());// 时间
        sb.append(LOG_SPLIT);
        sb.append(DasUtils.getIntranetIp());// IP地址
        sb.append(LOG_SPLIT);
        sb.append(osName);// 操作系统
        sb.append(LOG_SPLIT);
        sb.append(msg);
        log.debug(sb, t);
    }


    public static void logBizInfo(String errorMessage) {
        if (!needEnableLogger) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getCurrentTimeByFormat());// 时间
        sb.append(LOG_SPLIT);
        sb.append(DasUtils.getIntranetIp());// IP地址
        sb.append(LOG_SPLIT);
        sb.append(osName);// 操作系统
        sb.append(LOG_SPLIT);
        sb.append(errorMessage);// 错误信息
        log.info(sb.toString());
    }

    public static void logBizWarn(String errorMessage) {
        if (!needEnableLogger) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getCurrentTimeByFormat());// 时间
        sb.append(LOG_SPLIT);
        sb.append(DasUtils.getIntranetIp());// IP地址
        sb.append(LOG_SPLIT);
        sb.append(osName);// 操作系统
        sb.append(LOG_SPLIT);
        sb.append(errorMessage);// 错误信息
        log.warn(sb.toString());
    }

    public static void logBizError(String errorMessage) {
        if (!needEnableLogger) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getCurrentTimeByFormat());// 时间
        sb.append(LOG_SPLIT);
        sb.append(DasUtils.getIntranetIp());// IP地址
        sb.append(LOG_SPLIT);
        sb.append(osName);// 操作系统
        sb.append(LOG_SPLIT);
        sb.append(errorMessage);// 错误信息
        log.error(sb.toString());
    }

    private static String getCurrentTimeByFormat() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
