package com.philosopherzb.secret.sdk;

import com.philosopherzb.secret.sdk.util.DasUtils;
import com.philosopherzb.secret.sdk.util.InternalBase64Utils;
import com.philosopherzb.secret.sdk.util.InternalStringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author philosopherZB
 * @date 2022/1/17
 */
class SecurityManager {
    private static final Map<String, Character> SEPARATOR_CHAR_MAP = new HashMap<>(4);
    private static final Map<String, String> SEPARATOR_MAP = new HashMap<>(4);

    static {
        SEPARATOR_CHAR_MAP.put(SecurityConstants.TYPE_PHONE, SecurityConstants.PHONE_SEPARATOR_CHAR);
        SEPARATOR_CHAR_MAP.put(SecurityConstants.TYPE_ID, SecurityConstants.ID_SEPARATOR_CHAR);
        SEPARATOR_CHAR_MAP.put(SecurityConstants.TYPE_SIMPLE, SecurityConstants.TEXT_CHAR);
        SEPARATOR_CHAR_MAP.put(SecurityConstants.TYPE_SEARCH, SecurityConstants.TEXT_CHAR);
    }

    static {
        SEPARATOR_MAP.put(SecurityConstants.TYPE_PHONE, SecurityConstants.PHONE_SEPARATOR);
        SEPARATOR_MAP.put(SecurityConstants.TYPE_ID, SecurityConstants.ID_SEPARATOR);
        SEPARATOR_MAP.put(SecurityConstants.TYPE_SIMPLE, SecurityConstants.TEXT);
        SEPARATOR_MAP.put(SecurityConstants.TYPE_SEARCH, SecurityConstants.TEXT);
    }

    static Map<String, Character> getSeparatorCharMap() {
        return SEPARATOR_CHAR_MAP;
    }

    static Map<String, String> getSeparatorMap() {
        return SEPARATOR_MAP;
    }

    /**
     * 是否为密文
     *
     * @param data 加密数据
     * @param type 加密类型
     * @return 是否加密数据
     * @throws DasSecurityException DasSecurityException
     */
    static boolean isEncryptData(String data, String type) throws DasSecurityException {
        if (InternalStringUtils.isBlank(data) || data.length() < 4) {
            return false;
        }

        Character charValue = SEPARATOR_CHAR_MAP.get(type);
        if (charValue == null) {
            throw new DasSecurityException("type not exist");
        }
        char separatorChar = charValue;
        if (!(data.charAt(0) == separatorChar && data.charAt(data.length() - 1) == separatorChar)) {
            return false;
        }

        if (separatorChar == SecurityConstants.PHONE_SEPARATOR_CHAR || separatorChar == SecurityConstants.ID_SEPARATOR_CHAR) {
            // 拆分元素
            String[] dataArray = InternalStringUtils.split(data, charValue);
            if (dataArray.length != 3) {
                return false;
            }
            if (data.charAt(data.length() - 2) == separatorChar) {
                return checkEncryptData(dataArray);
            } else {
                String version = dataArray[dataArray.length - 1];
                if (InternalStringUtils.isNumeric(version)) {
                    return InternalBase64Utils.isBase64ForStr(dataArray[dataArray.length - 2]);
                }
            }
        } else {
            // 拆分元素
            String[] dataArray = InternalStringUtils.split(data, charValue);
            if (data.charAt(data.length() - 2) == separatorChar) {
                if (dataArray.length != 3) {
                    return false;
                }
                return checkEncryptData(dataArray);
            } else {
                if (dataArray.length != 2) {
                    return false;
                }
                return checkEncryptData(dataArray);
            }
        }

        return false;
    }

    /**
     * 加密手机号类型或id类型，后四位将成为检索串，使用H_MAC加密
     *
     * @param data            待加密数据
     * @param separator       分隔符
     * @param securityContext 秘钥上下文
     * @return 加密数据
     */
    static String encryptPhoneOrId(String data, String separator, SecurityContext securityContext) throws DasSecurityException {
        // 手机号不能小于11位
        if (SecurityConstants.PHONE_SEPARATOR.equals(separator) && data.length() < 11) {
            return data;
        }
        // 取后4位
        String last4Number = data.substring(data.length() - 4);
        return separator + DasUtils.hmacMD5EncryptToBase64(last4Number, securityContext.getSecret()) + separator
                + DasUtils.aesEncrypt(data, securityContext.getSecret()) + separator + securityContext.getSecretVersion()
                + separator + separator;
    }

    /**
     * 支持模糊搜索的文本加密
     *
     * @param data            待加密数据
     * @param compressLen     压缩长度
     * @param slideSize       滑动窗口尺寸
     * @param separator       分隔符
     * @param securityContext 秘钥上下文
     * @return 加密数据
     */
    static String encryptSearch(String data, int compressLen, int slideSize, String separator, SecurityContext securityContext) throws DasSecurityException {
        List<String> slideList = DasUtils.getSlideWindows(data, slideSize);
        StringBuilder builder = new StringBuilder();
        for (String slide : slideList) {
            builder.append(DasUtils.hmacMD5EncryptToBase64(slide, securityContext.getSecret(), compressLen));
        }

        return separator + DasUtils.aesEncrypt(data, securityContext.getSecret()) + separator + builder.toString() + separator
                + securityContext.getSecretVersion() + separator + separator;
    }

    /**
     * 普通加密文本
     *
     * @param data            待加密数据
     * @param separator       分隔符
     * @param securityContext 秘钥上下文
     * @return 加密数据
     */
    static String encryptSimple(String data, String separator, SecurityContext securityContext) throws DasSecurityException {
        return separator + DasUtils.aesEncrypt(data, securityContext.getSecret()) + separator + securityContext.getSecretVersion()
                + separator;
    }

    /**
     * 获取支持模糊搜索的加密数据
     *
     * @param data          加密数据
     * @param separatorChar 分隔符
     * @return SecurityData
     */
    static SecurityData getIndexSecurityData(String data, char separatorChar) {
        SecurityData securityData = null;
        // 切割字符
        String[] dataArray = InternalStringUtils.split(data, separatorChar);
        if (dataArray.length != 3) {
            return null;
        }
        String version = dataArray[2];
        if (InternalStringUtils.isNumeric(version)) {
            securityData = new SecurityData();
            securityData.setSecretVersion(Long.valueOf(version));
            // phone or id类型
            if (separatorChar == SecurityConstants.PHONE_SEPARATOR_CHAR || separatorChar == SecurityConstants.ID_SEPARATOR_CHAR) {
                // 索引列，H-MAC(例如手机号码后4位)
                securityData.setIndexValue(dataArray[0]);
                securityData.setEncryptValue(dataArray[1]);
            } else {
                securityData.setEncryptValue(dataArray[0]);
                // H-MAC value
                securityData.setIndexValue(dataArray[1]);
            }
        }
        return securityData;
    }

    /**
     * 获取普通的加密数据
     *
     * @param data          加密数据
     * @param separatorChar 分隔符
     * @return SecurityData
     */
    static SecurityData getSecurityData(String data, char separatorChar) {
        SecurityData securityData = null;
        String[] dataArray = InternalStringUtils.split(data, separatorChar);
        if (dataArray.length != 2) {
            return null;
        }

        String version = dataArray[1];
        if (InternalStringUtils.isNumeric(version)) {
            securityData = new SecurityData();
            securityData.setEncryptValue(dataArray[0]);
            securityData.setSecretVersion(Long.valueOf(version));
        }
        return securityData;
    }

    /**
     * @param data            加密数据
     * @param securityContext 秘钥上下文
     * @return 加密数据
     * @throws DasSecurityException DasSecurityException
     */
    static String getForPhoneOrId(String data, SecurityContext securityContext) throws DasSecurityException {
        if (data.length() != 4) {
            throw new DasSecurityException("phone or id format error, length must be 4");
        }
        return DasUtils.hmacMD5EncryptToBase64(data, securityContext.getSecret());
    }

    /**
     * 支持模糊搜索的文本索引串加密
     *
     * @param data            待加密数据
     * @param compressLen     压缩长度
     * @param slideSize       滑动窗口尺寸
     * @param securityContext 秘钥上下文
     * @return 加密数据
     */
    static String getForSearch(String data, int compressLen, int slideSize, SecurityContext securityContext) throws DasSecurityException {
        List<String> slideList = DasUtils.getSlideWindows(data, slideSize);
        StringBuilder builder = new StringBuilder();
        for (String slide : slideList) {
            builder.append(DasUtils.hmacMD5EncryptToBase64(slide, securityContext.getSecret(), compressLen));
        }

        return builder.toString();
    }

    /**
     * 检查加密数据
     *
     * @param dataArray 加密数据
     * @return 检查结果
     */
    private static boolean checkEncryptData(String[] dataArray) {
        String version = dataArray[dataArray.length - 1];
        if (InternalStringUtils.isNumeric(version)) {
            boolean isBase64Value = InternalBase64Utils.isBase64ForStr(dataArray[0]);
            if (isBase64Value) {
                if (dataArray.length == 3) {
                    return InternalBase64Utils.isBase64ForStr(dataArray[1]);
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
