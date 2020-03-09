package com.philosopherzb.commonutil.sendmsg.message;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.philosopherzb.commonutil.sendmsg.message.constant.AliyunMsgTemplateCodeEnum;
import com.philosopherzb.commonutil.sendmsg.message.constant.AliyunMsgTemplateDTO;
import com.philosopherzb.commonutil.sendmsg.message.constant.Result;
import com.philosopherzb.commonutil.sendmsg.message.constant.ReturnCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * author: philosopherZB
 * date: 2020/1/7
 * 阿里云发送短信
 */
@Service
public class AliyunSendMsgService {

    private static final Logger logger = LoggerFactory.getLogger(AliyunSendMsgService.class);

    private static final String ALIYUN_SUCCESS_OK = "OK";

    @Value("${aliyun.sms.timeout}")
    private String timeout;
    @Value("${aliyun.sms.product}")
    private String product;
    @Value("${aliyun.sms.domain}")
    private String domain;
    @Value("${aliyun.sms.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.sms.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.sms.regionId}")
    private String regionId;

    private static final String signName = "公司名称";

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 调用阿里云发送短信
     * @param phoneNumber 手机号
     * @param templateCode 短信模板ID，可在阿里云控制台模板管理页面模板CODE一列查看。
     * @param aliyunMsgTemplateDTO 短信模板中的变量对象，用来发送指定值
     * @return 发送结果
     */
    public Result sendSms(String phoneNumber, String templateCode, AliyunMsgTemplateDTO aliyunMsgTemplateDTO) {

        try {
            //设置超时时间-可自行调整
            System.setProperty("sun.net.client.defaultConnectTimeout", timeout);
            System.setProperty("sun.net.client.defaultReadTimeout", timeout);
            //初始化ascClient,暂时不支持多region（请勿修改）
            IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
            DefaultProfile.addEndpoint(regionId, regionId, product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);
            //组装请求对象
            SendSmsRequest request;
            request = new SendSmsRequest();
            //使用post提交
            request.setMethod(MethodType.POST);
            //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为00+国际区号+号码，如“0085200000000”
            request.setPhoneNumbers(phoneNumber);
            //必填:短信签名-可在短信控制台中找到
            request.setSignName(signName);
            //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
            request.setTemplateCode(templateCode);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
            //request.setTemplateParam("{\"code\":\"988756\"}");
            if(AliyunMsgTemplateCodeEnum.VERIFICATION_CODE.getCode().equals(templateCode) && StringUtils.isEmpty(aliyunMsgTemplateDTO.getCode())){
                String msgCode = this.getMsgCode();
                aliyunMsgTemplateDTO.setCode(msgCode);
            }
            this.setTemplateParam(templateCode, request, aliyunMsgTemplateDTO);
            //请求失败这里会抛ClientException异常
            logger.info("AliyunSendSmsImpl.sendSms request param:{}", JSONObject.toJSONString(request));
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if (sendSmsResponse.getCode() != null && ALIYUN_SUCCESS_OK.equals(sendSmsResponse.getCode())) {
                if(AliyunMsgTemplateCodeEnum.VERIFICATION_CODE.getCode().equals(templateCode) && StringUtils.isNotEmpty(aliyunMsgTemplateDTO.getCode())) {
                    //放入缓存，手机号为key，有效时间5分钟
                    logger.info("AliyunSendSmsImpl.sendSms send msgCode success, add to redis, phoneNumber:{}, msgCode:{}",phoneNumber,aliyunMsgTemplateDTO.getCode());
                    redisTemplate.opsForValue().set(phoneNumber, aliyunMsgTemplateDTO.getCode(), 5, TimeUnit.MINUTES);
                }
                //请求成功
                return Result.newSuccess();
            } else {
                logger.info("AliyunSendSmsImpl.sendSms call fail,response result:{}", JSONObject.toJSONString(sendSmsResponse));
                return Result.newFailure(ReturnCode.RESULT_FAIL);
            }
        } catch (Exception e){
            logger.info("AliyunSendSmsImpl.sendSms call exception, e:{}",e);
            return Result.newFailure(ReturnCode.RESULT_FAIL);
        }
    }


    /**
     * @return 随机的6位数，短信验证码
     */
    private String getMsgCode() {
        int n = 6;
        StringBuilder code = new StringBuilder();
        Random ran = new Random();
        for (int i = 0; i < n; i++) {
            code.append(Integer.valueOf(ran.nextInt(10)).toString());
        }
        return code.toString();
    }

    /**
     * 根据templateCode设置对应的短信模板参数
     * @param templateCode 模板code
     * @param request 短信请求参数
     */
    private void setTemplateParam(String templateCode, SendSmsRequest request, AliyunMsgTemplateDTO aliyunMsgTemplateDTO){
        // 手机短信验证模板
        if(AliyunMsgTemplateCodeEnum.VERIFICATION_CODE.getCode().equals(templateCode)){
            request.setTemplateParam("{\"code\":\"" + aliyunMsgTemplateDTO.getCode() + "\"}");
        }

        // 成功通知模板
        if(AliyunMsgTemplateCodeEnum.SUCCESS_NOTIFY.getCode().equals(templateCode)){

            request.setTemplateParam("{\"code\":\"" + aliyunMsgTemplateDTO.getCode() + "\" " +
                    ", \"message\":\"" + aliyunMsgTemplateDTO.getMessage() + "\" }");
        }

    }

}
