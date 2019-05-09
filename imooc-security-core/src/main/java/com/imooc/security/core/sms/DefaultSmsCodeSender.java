package com.imooc.security.core.sms;

/**
 * @author Trig
 * @create 2019-05-07 22:23
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机 " + mobile + " 发送短信验证码：" + code);
    }
}
