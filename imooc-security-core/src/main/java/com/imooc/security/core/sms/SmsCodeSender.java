package com.imooc.security.core.sms;

/**
 * @author Trig
 * @create 2019-05-07 22:22
 */
public interface SmsCodeSender {

    void send(String mobile, String code);
}
