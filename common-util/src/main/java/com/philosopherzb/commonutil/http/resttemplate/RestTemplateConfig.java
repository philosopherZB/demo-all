//package com.philosopherzb.commonutil.http.resttemplate;
//
//import org.apache.http.client.HttpClient;
//import org.apache.http.config.Registry;
//import org.apache.http.config.RegistryBuilder;
//import org.apache.http.conn.HttpClientConnectionManager;
//import org.apache.http.conn.socket.ConnectionSocketFactory;
//import org.apache.http.conn.socket.PlainConnectionSocketFactory;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.BufferingClientHttpRequestFactory;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
///**
// * @author philosopherZB
// * @date 2021/12/22
// */
//@Configuration
//public class RestTemplateConfig {
//    /**
//     * http连接管理器
//     *
//     * @return HttpClientConnectionManager
//     */
//    @Bean
//    public HttpClientConnectionManager poolingHttpClientConnectionManager() {
//        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
//                .register("http", PlainConnectionSocketFactory.getSocketFactory())
//                .register("https", SSLConnectionSocketFactory.getSocketFactory())
//                .build();
//        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(registry);
//        // 最大连接数
//        poolingHttpClientConnectionManager.setMaxTotal(500);
//        // 同路由并发数（每个主机的并发）
//        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(200);
//
//        return poolingHttpClientConnectionManager;
//    }
//
//    /**
//     * HttpClient config
//     *
//     * @param poolingHttpClientConnectionManager 连接管理器
//     * @return HttpClient
//     */
//    @Bean
//    public HttpClient httpClient(HttpClientConnectionManager poolingHttpClientConnectionManager) {
//        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
//        // 设置http连接管理器
//        httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);
//        // 设置重试次数
//        // httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(2, true));
//
//        return httpClientBuilder.build();
//    }
//
//    /**
//     * 请求连接池配置
//     *
//     * @param httpClient http客户端
//     * @return ClientHttpRequestFactory
//     */
//    @Bean
//    public ClientHttpRequestFactory clientHttpRequestFactory(HttpClient httpClient) {
//        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        // httpClient创建器
//        clientHttpRequestFactory.setHttpClient(httpClient);
//        // 连接超时时间/毫秒（连接上服务器(握手成功)的时间，超出抛出connect timeout）
//        clientHttpRequestFactory.setConnectTimeout(5 * 1000);
//        // 数据读取超时时间(socketTimeout)/毫秒（务器返回数据(response)的时间，超过抛出read timeout）
//        clientHttpRequestFactory.setReadTimeout(10 * 1000);
//        // 连接池获取请求连接的超时时间，不宜过长，必须设置/毫秒（超时间未拿到可用连接，会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for connection from pool）
//        clientHttpRequestFactory.setConnectionRequestTimeout(10 * 1000);
//        // BufferingClientHttpRequestFactory 可多次读取响应流
//        return new BufferingClientHttpRequestFactory(clientHttpRequestFactory);
//    }
//
//    /**
//     * restTemplate config
//     *
//     * @return restTemplate
//     */
//    @Bean
//    public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
//        return new RestTemplate(clientHttpRequestFactory);
//    }
//
//}
