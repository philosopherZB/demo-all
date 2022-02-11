package com.philosopherzb.secret.sdk;

/**
 * @author philosopherZB
 * @date 2022/1/17
 */
public final class SecurityConstants {
    /**
     * 默认滑动窗口大小: 4
     */
    public static final int DEFAULT_ENCRYPT_SLIDE_SIZE = 4;
    /**
     * 默认密文滑窗压缩长度: 3
     */
    public static final int DEFAULT_INDEX_ENCRYPT_COMPRESS_LEN = 3;

    /**
     * 手机号码
     */
    public static final String TYPE_PHONE = "phone";
    /**
     * 有规律的数字，例如身份证
     */
    public static final String TYPE_ID = "id";
    /**
     * 普通文本类型，不带检索功能
     */
    public static final String TYPE_SIMPLE = "simple";
    /**
     * 支持检索功能的文本类型
     */
    public static final String TYPE_SEARCH = "search";

    /**
     * 手机号类型分隔符---字符类型
     */
    public static final char PHONE_SEPARATOR_CHAR = '$';
    /**
     * id类型分隔符---字符类型
     */
    public static final char ID_SEPARATOR_CHAR = '#';
    /**
     * 文本类型分隔符---字符类型
     */
    public static final char TEXT_CHAR = '~';
    /**
     * 手机号类型分隔符---字符串类型
     */
    public static final String PHONE_SEPARATOR = String.valueOf(PHONE_SEPARATOR_CHAR);
    /**
     * id类型分隔符---字符串类型
     */
    public static final String ID_SEPARATOR = String.valueOf(ID_SEPARATOR_CHAR);
    /**
     * 文本类型分隔符---字符串类型
     */
    public static final String TEXT = String.valueOf(TEXT_CHAR);

    // 获取秘钥的地址
    public static final String API_SECURITY_GET_SECRET_KEY_URL = "/api/security/getSecretKey";
    // 参数key
    public static final String APP_ID = "appId";
    public static final String RANDOM_NUM = "randomNum";
    public static final String TIMESTAMP = "timestamp";
    public static final String CHARSET = "charset";
    public static final String SIGN = "sign";
    public static final String BIZ_CONTENT_KEY = "bizContent";
    // 请求业务参数key
    public static final String SECRET_VERSION = "secretVersion";
    public static final String VERITY_RESPONSE = "verifyResponse";
    // 响应参数
    public static final String RESPONSE_ERROR_CODE = "errorCode";
    public static final Integer RESPONSE_ERROR_CODE_SUCCESS_VALUE = 0;
    public static final String RESPONSE_DATA = "data";
    public static final String RESPONSE_ENCRYPT_SLIDE_SIZE = "encryptSlideSize";
    public static final String RESPONSE_ENCRYPT_INDEX_COMPRESS_LEN = "encryptIndexCompressLen";
    public static final String RESPONSE_INVALID_TIME = "invalidTime";
    public static final String RESPONSE_MAX_INVALID_TIME = "maxInvalidTime";
    public static final String RESPONSE_AES_KEY = "aesKey";
    public static final String RESPONSE_SIGN = "sign";
}
