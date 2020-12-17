package com.philosopherzb.commonutil.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.TreeMap;

/**
 * author: philosopherZB
 * date: 2020/12/8
 */
public class RSAUtils {

    /**
     * 加密算法RSA
     */
    private static final String KEY_ALGORITHM = "RSA";

    /**
     * 签名算法
     */
    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";

    /**
     * 用私钥对信息生成数字签名
     *
     * @param content    待加签报文
     * @param privateKey 私钥(BASE64编码)
     * @return 加签结果
     * @throws Exception 异常
     */
    public static String sign(String content, String privateKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        byte[] data = content.getBytes(StandardCharsets.UTF_8);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateK);
        signature.update(data);
        return new String(Base64.encodeBase64(signature.sign()));
    }

    /**
     * 校验数字签名
     *
     * @param content   待验签报文
     * @param publicKey 公钥(BASE64编码)
     * @param sign      数字签名
     * @return 验签结果
     * @throws Exception 异常
     */
    public static boolean verify(String content, String publicKey, String sign)
            throws Exception {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        byte[] data = content.getBytes(StandardCharsets.UTF_8);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicK = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicK);
        signature.update(data);
        return signature.verify(Base64.decodeBase64(sign));
    }

    public static void main(String[] args) throws Exception {
        String content = "{\n" +
                "    \"app_id\": \"Test0001\",\n" +
                "    \"sign_type\": \"SHA256withRSA\",\n" +
                "    \"order_no\": \"20201214498352115335884800\",\n" +
                "}";

        TreeMap treeMap = JSONObject.parseObject(content, TreeMap.class);
        System.out.println(treeMap.toString());
        String str = treeMap.toString();

        String priKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCsjf+VKgh8OIYNb2s2SUR/i79zLsaMmQy+UXg9/iT7/YvIjCTRP8tTJk0UDVG9v08GrLLCa+0KPckq39W+zCWUTNPpQNx0LDYXA3aVGFbmyeGxB2JvKFpVObvpCcEeI8M9M8AbSL2xzipUlg1Z93LD9cRG9jcp9DDVQdsy593aMTtyiffWWKdqnBWbo6RgjVr2Ps8G+4Ona38pjCk1FmtbbPDGhvyqR/qVrDmW3volAcxRH6DM9NLxLfUWGml4379kwlnbaKCj/NDfwkA/keZsMKXHhtzGW8o9fM1wxebfkZlm2/y1VuQ8DuV0zRbGW01hiEyNIU4VaNRuUnL98bKhAgMBAAECggEAaBsz/Fbjz656kliKorIJtbomw+OQvvsICTs2BJD012Pdlh2XiPeoQH53OoXer1Bg6XIAV/StiuREHq31U6vvcE35/Fy5pQ2XhML+JG4O4CclF52Q8eeyuICgsrTD4t9IyAAVA2Ebsc7lEyuE2qbEgx4gUX/zQEinvcKB8XCbFSxpJ7XGUJYf397XhJE86QKUgoEt6JHYBVvBp4hNOomkZrH4yePSUsFtgBQj70XrhVgjG5N2F0fzRUM3cPx/mV+5ixcVQz7PEPtl94asX5nsXRar+TzxqYvQogT3ms2NWxkhI8niztbrtwMttH5mI4GbB3FRXCqodpf3RcaqmrML0QKBgQDY/EA6qhypmPsEUkMWns8FSN+O7teK44fqfV4LsdZUw+U3tKSCmF1GZSIaUJznOfbN60yR5Z99R5G6hxfL4KIqHsMlcwgWGU4+cC61i3LUQjrYStK6CmnbTKpKjCEVftPvIE9lkMycKSxHpWuTW9W86n0D3ZqMAbtKciL3mLgyZwKBgQDLlJ8PJmeMc3+3D/uRjJq9wOn7esl0e/jgCjPVclIK1QWq2lRzqBLyirSETj+fFPlG1fimrEyJ6p+kh/4HJGDJBmNFiXlcutX+zJ+B25MlLecjPEOQoN9MeMaJNrTfnhOk9ejfmaORMlu1xIdvxfFVq5AH7nU/QkPqZDRZLPAdtwKBgDfCMpsgpbbrSe3lWboRWy+Hd3NaaucU6xNV3fnxXBtyL4/uCqxIjQeO64GJn5hHq+VkhsujDyX5YzhkiLfqZKGgQBN6iORs4k9nMomSaRKkZky4hYgrLuKcw9HeSo4khj+XtO9rkzi519gdaRR37+fY9gEtTA6YT1GlHNk1VHgXAoGAXapmuGi6EcP+SfK/k0r200FUJlFrKP31Ftd628T6fGNgdSh43LHC7fblcU4zNXVH79B40+7IVFgv1VqAhTa2lScsO40x2nlYBiCNbwjgnaWOCActKvjpZFzZM76I363yad5+o4oj2KUrzui6S7HuBLWn0g5jwZQyfUBXWYQ0gecCgYBQ1AqVn8mG9UYfoKVqQQRo3wjWMLfdpF0kLuSK/1Y1fWDNe+L9931FKcJrJlynW7bdHw+Fwp22NujoCvBzq/jH8I+M64+m86IMvXUOsaQeB/q2t9q0Cvhhv3nphUxHbQ9BDF+Y3ia+mtZM9t64Z5whzAFyxZLiFbXAMyBW5TNEDg==";

        String pubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArI3/lSoIfDiGDW9rNklEf4u/cy7GjJkMvlF4Pf4k+/2LyIwk0T/LUyZNFA1Rvb9PBqyywmvtCj3JKt/VvswllEzT6UDcdCw2FwN2lRhW5snhsQdibyhaVTm76QnBHiPDPTPAG0i9sc4qVJYNWfdyw/XERvY3KfQw1UHbMufd2jE7con31linapwVm6OkYI1a9j7PBvuDp2t/KYwpNRZrW2zwxob8qkf6law5lt76JQHMUR+gzPTS8S31FhppeN+/ZMJZ22igo/zQ38JAP5HmbDClx4bcxlvKPXzNcMXm35GZZtv8tVbkPA7ldM0WxltNYYhMjSFOFWjUblJy/fGyoQIDAQAB";

        System.out.println(sign(str, priKey));
        System.out.println(verify(str, pubKey, sign(str, priKey)));
    }

}
