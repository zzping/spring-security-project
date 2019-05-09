package com.imooc.security.core.properties;

import lombok.Data;

/**
 * @author Trig
 * @create 2019-05-03 18:10
 */
@Data
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();
}
