package com.philosopherzb.commonutil.sendmsg.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * author: philosopherZB
 * date: 2020/3/9
 */
@Service
public class NotifyMailService {

    private static final Logger logger = LoggerFactory.getLogger(NotifyMailService.class);

    @Resource
    private JavaMailSender javaMailSender;

    //发送者邮箱地址
    @Value("${spring.mail.username}")
    private String sender;

    //接受者邮箱地址，格式类似于为：123@qq.com;456@qq.com
    @Value("${mail.receiver}")
    private String receiver;


    public void sendNotifyMail(String subject,String text){

        logger.info("execute method NotifyMailService.sendNotifyMail");

        sendMail(subject,text,sender,receiver);
    }

    /**
     * 发送邮件，相关参数组装
     * @param subject 邮件标题
     * @param text 邮件内容
     * @param sender 发送者
     * @param receiver 接受者，可多个，以英文分号分割邮件地址
     */
    private void sendMail(String subject,String text,String sender,String receiver){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(sender);
        if(receiver.contains(";")){
            String[] rcs = receiver.split(";");
            if(rcs.length>1){
                simpleMailMessage.setTo(rcs[0]);
                simpleMailMessage.setCc(receiver.substring(receiver.indexOf(";")+1).split(";"));
            }else if(rcs.length == 1){
                simpleMailMessage.setTo(rcs[0]);
            }
        }else{
            simpleMailMessage.setTo(receiver);
        }
        simpleMailMessage.setSentDate(new Date());
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);
    }

}
