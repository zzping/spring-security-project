package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码处理器，封装不同验证码的处理逻辑
 * @author Trig
 * @create 2019-05-07 22:41
 */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 生成验证码
     * @param request
     * @throws Exception
     * ServletWebRequest封装了request和response、这样可以不用每次传两个参数
     */
    void create(ServletWebRequest request) throws Exception;
}
