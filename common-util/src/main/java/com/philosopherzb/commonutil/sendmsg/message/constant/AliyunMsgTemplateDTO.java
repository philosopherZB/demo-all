package com.philosopherzb.commonutil.sendmsg.message.constant;

import lombok.Data;

import java.io.Serializable;

/**
 * author: philosopherZB
 * date: 2020/3/9
 */
@Data
public class AliyunMsgTemplateDTO implements Serializable {

    private static final long serialVersionUID = 6742449326292302912L;

    private String code;

    private String message;
}
