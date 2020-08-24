package com.philosopherzb.common.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.philosopherzb.common.request.GateWayApiRequest;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;

/**
 * author: philosopherZB
 * date: 2019/11/11
 * 签名生成工具类
 */
public class SignatureGeneratorUtil {

    /**
     * 指定连接符
     **/
    private static final String SEPARATOR = "&";
    /**
     * 字符集
     **/
    private static final String ENCODE_UTF8 = "UTF-8";

    /**
     * 加签密钥
     */
    private final String accessKey;

    /**
     * 加密实例
     *
     * @param accessKey 秘钥accessKey
     * @return 返回加密实例
     */
    public static SignatureGeneratorUtil getInstance(String accessKey) {
        return getInstanceByKey(accessKey);
    }

    /**
     * 计算签名
     *
     * @param httpMethod    http请求对应的方法，如GET，POST
     * @param apiRequestDto 签名数据
     * @return 返回签名结果
     * @throws UnsupportedEncodingException 不支持的编码格式异常
     */
    public String calcSignature(String httpMethod, GateWayApiRequest apiRequestDto) throws Exception {
        return calcSignature(apiRequestDto, getParamString(httpMethod, apiRequestDto));
    }

    private static String getParamString(String httpMethod, GateWayApiRequest apiRequestDto) throws Exception {

        if (null == apiRequestDto) {
            return "";
        }

        if (StringUtils.isEmpty(apiRequestDto.getAccessId()) ||
                StringUtils.isEmpty(apiRequestDto.getMethod())) {
            return "";
        }

        // 对参数进行排序
        Field[] fields = GateWayApiRequest.class.getDeclaredFields();
        Set<String> fieldSet = new TreeSet<>();
        for (Field f : fields) {
            if (!f.toString().contains("static") && !"signature".equals(f.getName())) {
                fieldSet.add(f.getName());
            }
        }

        // 生成stringToSign字符串
        StringBuilder stringToSign = new StringBuilder();
        stringToSign.append(httpMethod).append(SEPARATOR);
        stringToSign.append(percentEncode("/")).append(SEPARATOR);

        StringBuilder canonicalizedQueryString = new StringBuilder();

        for (String fieldName : fieldSet) {
            // 这里注意对key和value进行编码
            Field field = GateWayApiRequest.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            String key = field.getName();
            String value = (String) field.get(apiRequestDto);
            JSONField jsonField = field.getAnnotation(JSONField.class);
            if (null != jsonField) {
                key = jsonField.name();
            }
            canonicalizedQueryString.append("&")
                    .append(percentEncode(key)).append("=")
                    .append(percentEncode(value));
        }

        // 这里注意对canonicalizedQueryString进行编码
        stringToSign.append(percentEncode(
                canonicalizedQueryString.toString().substring(1)));

        System.out.println("stringToSign: " + stringToSign.toString());
        return stringToSign.toString();
    }

    private static String percentEncode(String value) throws UnsupportedEncodingException {
        return value != null ? URLEncoder.encode(value, ENCODE_UTF8)
                .replace("+", "%20").replace("*", "%2A")
                .replace("%7E", "~") : null;
    }

    private String calcSignature(GateWayApiRequest apiRequestDto, String strToSign) throws Exception {
        String signature = createSignature(strToSign, accessKey, apiRequestDto.getSignatureMethod());
        return StringUtils.isEmpty(signature) ? "" : signature;
    }

    private static String createSignature(String strToSign, String accessKey, String hmacMethod) throws Exception {
        SecretKeySpec signingKey = new SecretKeySpec(accessKey.getBytes(StandardCharsets.UTF_8), hmacMethod);
        Mac mac = Mac.getInstance(hmacMethod);
        mac.init(signingKey);
        byte[] rawHmac = mac.doFinal(strToSign.getBytes(StandardCharsets.UTF_8));
        return DatatypeConverter.printBase64Binary(rawHmac);
    }


    private static SignatureGeneratorUtil getInstanceByKey(String key) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("sign key must not be null or empty!");
        }
        return new SignatureGeneratorUtil(key);
    }

    private SignatureGeneratorUtil(String accessKey) {
        if (StringUtils.endsWith(accessKey, SEPARATOR)) {
            this.accessKey = accessKey;
        } else {
            this.accessKey = accessKey + SEPARATOR;
        }
    }

}
