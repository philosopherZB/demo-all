package com.philosopherzb.springaop.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 忽略安全套接层认证，可解决站点信任问题
 * 调用https接口时，使用此工具类可以忽略安全套接层认证
 * author:philosopherZB
 * date:2019/6/25
 */
public class SslUtil {
    private static final Logger logger = LoggerFactory.getLogger(SslUtil.class);

    private static void trustAllHttpsCertificates() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[1];
        TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }
    static class miTM implements TrustManager, X509TrustManager {
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
        public boolean isServerTrusted(X509Certificate[] certs) {
            return true;
        }
        public boolean isClientTrusted(X509Certificate[] certs) {
            return true;
        }
        @Override
        public void checkServerTrusted(X509Certificate[] certs, String authType)
                throws CertificateException {
            return;
        }
        @Override
        public void checkClientTrusted(X509Certificate[] certs, String authType)
                throws CertificateException {
            return;
        }
    }
    /**
     * 忽略HTTPS请求的SSL证书，必须在openConnection之前调用
     * @throws Exception
     */
    public static void ignoreSsl() throws Exception{
        trustAllHttpsCertificates();
        HttpsURLConnection.setDefaultHostnameVerifier((urlHostName, session) -> {
            logger.warn("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
            return true;
        });
    }
}
