package com.imooc.code;

import com.imooc.security.core.validate.code.ImageCode;
import com.imooc.security.core.validate.code.ValidateCodeGenerator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Trig
 * @create 2019-05-03 18:47
 */
// @Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode createImageCode(HttpServletRequest request) {
        System.out.println("自定义的图形验证码 - 可以覆盖默认的验证码生成逻辑");
        return null;
    }
}
