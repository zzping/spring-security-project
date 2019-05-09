package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Trig
 * @create 2019-05-03 18:39
 */
public interface ValidateCodeGenerator {

    /**
     * 生成验证码
     * @param request
     * @return
     */
    ValidateCode generate(ServletWebRequest request);
}
