package com.imooc.security.core.properties;

import lombok.Data;

/**
 * @author Trig
 * @create 2019-05-03 18:08
 */
@Data
public class ImageCodeProperties {

    private int width = 67;
    private int height = 23;
    private int length = 4;
    private int expireIn = 60;
    private String url;
}
