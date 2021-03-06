package com.imooc.security.core.validate.code;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * 短信验证码对象
 * @author Trig
 * @create 2019-05-03 15:36
 */
@Data
@AllArgsConstructor
public class ValidateCode {

    private String code;
    private LocalDateTime expireTime;

    /**
     * 在多少秒内过期的构造方法
     * @param code
     * @param expireIn
     */
    public ValidateCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    /**
     * 校验验证码是否过期
     * @return
     */
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
