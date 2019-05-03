package com.imooc.security.core.validate.code;


import org.springframework.security.core.AuthenticationException;

/**
 * AuthenticationException是spring security中身份认证过程中抛出的所有异常的基类
 * @author Trig
 * @create 2019-05-03 16:20
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
