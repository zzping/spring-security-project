package com.imooc.security.core.validate.code.image;

import com.imooc.security.core.validate.code.ValidateCode;
import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * 图片验证码对象
 * @author Trig
 * @create 2019-05-03 15:36
 */
@Data
public class ImageCode extends ValidateCode {

    private BufferedImage image;
    private String code;
    private LocalDateTime expireTime;

    /**
     * 在多少秒内过期的构造方法
     * @param image
     * @param code
     * @param expireIn
     */
    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

    /**
     * 校验验证码是否过期
     * @return
     */
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
