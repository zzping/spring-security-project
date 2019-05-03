package com.imooc.security.core.validate.code;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Trig
 * @create 2019-05-03 18:39
 */
public interface ValidateCodeGenerator {

    /**
     * 生成图片验证码
     * @param request
     * @return
     */
    ImageCode createImageCode(HttpServletRequest request);
}
