//package com.philosopherzb.gateway.config;
//
//import org.apache.tomcat.util.http.Rfc6265CookieProcessor;
//import org.apache.tomcat.util.http.SameSiteCookies;
//import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 通过修改容器的配置，对Session Cookie设置SameSite属性
// * author: philosopherZB
// * date: 2020/12/22
// */
//@Configuration
//public class TomcatConfig {
//    @Bean
//    public TomcatContextCustomizer sameSiteCookiesConfig() {
//        return context -> {
//            final Rfc6265CookieProcessor cookieProcessor = new Rfc6265CookieProcessor();
//            // 设置Cookie的SameSite
//            cookieProcessor.setSameSiteCookies(SameSiteCookies.NONE.getValue());
//            context.setCookieProcessor(cookieProcessor);
//        };
//    }
//}
