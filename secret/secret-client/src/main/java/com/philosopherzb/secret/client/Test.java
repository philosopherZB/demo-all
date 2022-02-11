package com.philosopherzb.secret.client;

import com.philosopherzb.secret.sdk.DasSecurityException;
import com.philosopherzb.secret.sdk.DefaultSecurityClient;
import com.philosopherzb.secret.sdk.SecurityClient;
import com.philosopherzb.secret.sdk.SecurityConstants;

/**
 * @author philosopherZB
 * @date 2022/1/18
 */
public class Test {
    public static void main(String[] args) {
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDGbO1R5OQ0Ff27V+k1FuPBnKMqwC3c0HFnAFu0ZUWH5FTyfkMahhsRntg7/uLk2QM1v0rx7kEdd/ExhOs5z68nO8xbyX/YbC+DX/NH3IsvNRrDU+xfpZdnuMT3bjtlGsasTIOK8S3DlHfiGpO4HPgeY7mBfduBaPStmJFLMM4Xpg3piD4r8mmq+2dAIhq6vX8GpwVqap0XLk8TcYY5h8WQ0FTbTSbRUNN/+YHmlwbEJVa+NR8qaUoo75/WHeVgjNlZ8SAfdjMt1oVWmibSiKYDr1JBVZrPD4CjBy6UR9jDrTxTrwmGsvHUzE3ZThPJZvJEWVXHbMCTs4KReUds/UcPAgMBAAECggEAXSsAM5e53wsEXFbm1VquDlax9nzODASDes2cQZPblfcMO+A1OdsGErv25BTGDJYo/6+WTQqF4IRU5991Y2u03kMhrWdrc/84QANpg7B2WfAhZN2e+zoRYU5MjbFgihSMfJJgoXik+FRaBfxcp/JSPlKs47RowNa7LFeawSdlXYxy+eXCouYomGe0aCPACKfHRyBWDRCf+eK/UwXRcmiyHi8hXOa/IfsaBsZNLtHR3rFod4x+hZUoIJAuXpupc2KW4qsK8ImW9BDcx2p2EO6iggw6MZMZkIo7NRHf3aaaLfpVsebjHm5lBF95ptVUP4CFpfoNevn3y09D4nhGjBP7AQKBgQDnZIcX+XJDykYES10jClxKndibhLYN9zNp7FOiin1Sfd5tUux+VXNEocWSMIqz8wuuI6kyrigwa0E2Kis3QANLizsaOu39jCW5kAHFm19txG3IgntPix95qADl9fQAO1Y3Nbh+zL43FH8f0s066L3V9bTvmZ6rN9vf8GF/xHrfLwKBgQDbhuUop370RhFbgN1CIFM6m6gio7pft7NW6YLyn4yXa/vbpw7c7B+c5TA1ru9maaXlF+Sff5WtLVK10czghDOdI0B5qrm62+TEhOEk7C6dgNsCdaHuDzqA2MYEmq4HJhoXrwM+xvzrlCwNZQ1AIRQWKdceKK9YgEnZQXQU9TEeIQKBgQCfPELrcLH9jLlaQzK45mxUvQNPIqjWO4OaJRP5CyzrE8t5mFM/LTbByEHaNKV+6IblM41AXzExAN5DlAlhYB/kYNAvYNZeYY+kf0F4509ojoCuN3z8ZFUot0DG/9cGQc829zUbrXJJHUXOdJbfL0NUdl4pdKIIWcxp81ZlQqT76QKBgHMlCzfKux1XTy1mpydTGzSnhoY8yLoB+dBBhQzLwQt/eUhaFMKuG1rJIANYcXuPOJO0d5dtbU27cyGpHMQ6s3PdlKj8cpTfV9v4MruSIlU8zCM7Hidm13HTwfGSTGu1gYQgqRwZdXn/ayfPdCbJ8uY5JftMrcRG7fVFjqSbgxrhAoGAVPNPW/QOVarHZDCVJi0XtOhl1g6oR51FGkOZ13SEuu8271v0PxcP55Hib6WvCPDOFB75oPaa1HmQs/WL41RCFMlELH/DhwEEkd2hLFmou4AiiB+M2DQODxagyINOx0RGd7FZuhiIWQTocqXj2PV71gkn5q4pIGKLsk1aklLTKXY=";
        String dasPubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiPNXFw6tQyfpNi63OoR5E+VR+KS4Sy1+1EFNiHTIc/f5AXXZtmo8CVTgAM8X7a2GHLMwRqjH1JZ/2Da9HHn8zHdEtSAbObxMtTKPrnQOG5NrTuA3hfRb/4N00iZZ2KZMr5fTXJ4824VMr2/fQZySwDd0bOPTmrNnlHLu6ErFvfJwjQqbhWVC1VhRkGzvT81O2SM+ALuTnbgoFGqFyaUE9YUP57COA/Hw4Yz+GmQkHxs9ELPvikFSGdBdptDvHQ2dTprskRW8UU/v0XjVED8jeayiqKxJFn2Yejq43eqkH+SV6c9R1jE39qhMyEX7hVvzSMcyvONSo5Za4R5zLqap4wIDAQAB";
        // 初始化一次即可（单例模式）
        SecurityClient securityClient =
                new DefaultSecurityClient("http://127.0.0.1:8999", "mss20220209651316091208540160", privateKey, "20220209651322386368110592", dasPubKey);
        try {
            // 加密类型: TYPE_PHONE-手机号; TYPE_ID-id; TYPE_SIMPLE-普通加密；TYPE_SEARCH-支持搜索的加密
            String encryptData = securityClient.encrypt("www.test.hostname.com", SecurityConstants.TYPE_SEARCH, 1L);
            System.out.println("encryptData: " + encryptData);

            boolean isEncryptData = securityClient.isEncryptData(encryptData, SecurityConstants.TYPE_SEARCH);
            System.out.println("isEncryptData: " + isEncryptData);

            String decryptData = securityClient.decrypt(encryptData, SecurityConstants.TYPE_SEARCH, 1L);
            System.out.println("decryptData: " + decryptData);

            String searchData = securityClient.search("test.hostname", SecurityConstants.TYPE_SEARCH, 1L);
            System.out.println("searchData: " + searchData);
        } catch (DasSecurityException e) {
            e.printStackTrace();
        }
    }
}
