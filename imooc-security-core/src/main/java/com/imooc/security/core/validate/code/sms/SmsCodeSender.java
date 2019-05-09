package com.imooc.security.core.validate.code.sms;

/**
 * @author Trig
 * @create 2019-05-07 22:22
 */
public interface SmsCodeSender {

    void send(String mobile, String code);
}
