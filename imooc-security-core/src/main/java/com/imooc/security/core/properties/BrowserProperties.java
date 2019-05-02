package com.imooc.security.core.properties;

import lombok.Data;

/**
 * @author Trig
 * @create 2019-05-02 16:49
 */
@Data
public class BrowserProperties {

    private String loginPage = "/imooc-signIn.html";

    private LoginType loginType = LoginType.JSON;
}
