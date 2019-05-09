package com.imooc.security.core.properties;

import lombok.Data;

/**
 * @author Trig
 * @create 2019-05-03 18:08
 */
@Data
public class SmsCodeProperties {

    private int length = 6;
    private int expireIn = 60;
    private String url;
}
