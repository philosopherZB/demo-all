package com.philosopherzb.springaop.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Optional;

/**
 * http服务调用工具类
 * author:philosopherZB
 * date:2019/6/25
 */
@Slf4j
public class HttpClientUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    /**
     * 发送https请求
     *
     * @param urlPath
     *            目的地址
     * @param method
     *            请求方法
     *@param contentType
     *            请求类型
     *@param encodeType
     *            编码类型
     *@param headers
     *            请求头参数
     * @param parameters
     *            请求Json结构参数，字符串类型。
     * @return 远程响应结果
     * @throws Exception 异常
     */
    public static String sendHttpsRequest(String urlPath, String method, String contentType, String encodeType, Map<String, String> headers, String parameters) throws Exception{
        StringBuilder result = new StringBuilder();
        BufferedReader reader = null;
        OutputStream outwritestream = null;
        HttpsURLConnection conn = null;
        try {
            SslUtil.ignoreSsl();     //使用此工具类可忽略安全套接层认证
            URL url = new URL(urlPath);
            conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setRequestProperty("Connection", "Keep-Alive");
            String codeType = StringUtils.isEmpty(encodeType)?"UTF-8":encodeType;
            conn.setRequestProperty("Charset", codeType);
            if(!StringUtils.isEmpty(contentType)){
                // 设置文件类型:
                conn.setRequestProperty("Content-Type",contentType+"; charset="+codeType);
                //conn.setRequestProperty("accept","*/*")此处为暴力方法设置接受所有类型，以此来防范返回415;
                //设置接收类型否则返回415错误
                conn.setRequestProperty("accept",contentType);
            }
            if(Optional.ofNullable(headers).isPresent()){
                headers.forEach(conn::setRequestProperty);
            }

            if(Optional.ofNullable(parameters).isPresent()){
                // 往服务器里面发送数据
                byte[] writebytes = parameters.getBytes();
                // 设置文件长度
                conn.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
                outwritestream = conn.getOutputStream();
                outwritestream.write(parameters.getBytes(codeType));
                outwritestream.flush();
            }

            logger.info("http response code: {}", conn.getResponseCode()+"  "+conn.getResponseMessage());
            if (conn.getResponseCode() == 200) {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),codeType));
            }else{
                if(conn.getErrorStream() != null){
                    reader = new BufferedReader(new InputStreamReader(conn.getErrorStream(),codeType));
                }
            }
            String s;
            if(reader != null){
                while((s = reader.readLine()) != null){
                    result.append(s);
                }
            }else{
                throw new Exception("服务错误[service response code:"+conn.getResponseCode()+"]" + "响应参数：" + result);
            }
        } finally {
            if (outwritestream != null) {
                try {
                    outwritestream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                conn.disconnect();
            }
        }
        return result.toString();

    }

    /**
     * 发送http请求
     *
     * @param urlPath
     *            目的地址
     * @param method
     *            请求方法
     *@param contentType
     *            请求类型
     *@param encodeType
     *            编码类型
     *@param headers
     *            请求头参数
     * @param parameters
     *            请求Json结构参数，字符串类型。
     * @return 远程响应结果
     * @throws Exception 异常
     */
    public static String sendHttpRequest(String urlPath, String method, String contentType, String encodeType,Map<String, String> headers, String parameters) throws Exception{
        StringBuilder result = new StringBuilder();
        BufferedReader reader = null;
        OutputStream outwritestream = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(urlPath);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod(method);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setRequestProperty("Connection", "Keep-Alive");
            String codeType = StringUtils.isEmpty(encodeType)?"UTF-8":encodeType;
            conn.setRequestProperty("Charset", codeType);
            if(!StringUtils.isEmpty(contentType)){
                // 设置文件类型:
                conn.setRequestProperty("Content-Type",contentType+"; charset="+codeType);
                //conn.setRequestProperty("accept","*/*")此处为暴力方法设置接受所有类型，以此来防范返回415;
                //设置接收类型否则返回415错误
                conn.setRequestProperty("accept",contentType);
            }
            if(Optional.ofNullable(headers).isPresent()){
                headers.forEach(conn::setRequestProperty);
            }

            if(Optional.ofNullable(parameters).isPresent()){
                // 往服务器里面发送数据
                byte[] writebytes = parameters.getBytes();
                // 设置文件长度
                conn.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
                outwritestream = conn.getOutputStream();
                outwritestream.write(parameters.getBytes(codeType));
                outwritestream.flush();
            }

            logger.info("http response code: {}", conn.getResponseCode()+"  "+conn.getResponseMessage());
            if (conn.getResponseCode() == 200) {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),codeType));
            }else{
                if(conn.getErrorStream() != null){
                    reader = new BufferedReader(new InputStreamReader(conn.getErrorStream(),codeType));
                }
            }
            String s;
            if(reader != null){
                while((s = reader.readLine()) != null){
                    result.append(s);
                }
            }else{
                throw new Exception("服务错误[service response code:"+conn.getResponseCode()+"]" + "响应参数：" + result);
            }
        } finally {
            if (outwritestream != null) {
                try {
                    outwritestream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                conn.disconnect();
            }
        }
        return result.toString();

    }
}
