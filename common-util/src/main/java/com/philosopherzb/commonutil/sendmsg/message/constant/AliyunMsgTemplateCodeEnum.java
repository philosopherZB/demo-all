package com.philosopherzb.commonutil.sendmsg.message.constant;

/**
 * author: philosopherZB
 * date: 2020/1/7
 * 阿里云发送消息的模板code枚举
 */
public enum AliyunMsgTemplateCodeEnum {

    VERIFICATION_CODE("SMS_182360073","手机短信验证"),
    SUCCESS_NOTIFY("SMS_182375058","成功通知"),
    ;


    private String code;
    private String message;

    AliyunMsgTemplateCodeEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
