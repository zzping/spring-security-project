package com.imooc.code;

import com.imooc.security.core.validate.code.image.ImageCode;
import com.imooc.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author Trig
 * @create 2019-05-03 18:47
 */
// @Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("自定义的图形验证码 - 可以覆盖默认的验证码生成逻辑");
        return null;
    }
}
