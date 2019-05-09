package com.imooc.security.core.validate.code;

import com.imooc.security.core.properties.SecurityProperties;
import com.imooc.security.core.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 生成图片验证码的rest接口
 * @author Trig
 * @create 2019-05-03 15:57
 */
@RestController
public class ValidateCodeController {

    @Autowired
    private Map<String, ValidateCodeProcessor> ValidateCodeProcessors;

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    @Autowired
    private ValidateCodeGenerator smsCodeGenerator;

    @Autowired
    private SmsCodeSender smsCodeSender;

    // 为了操作session需要引入Spring的一个工具类
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
     * 生成图片验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 生成图片验证码
        ImageCode imageCode = (ImageCode) imageCodeGenerator.generate(new ServletWebRequest(request));
        // 将随机数存到session中
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
        // 将生成的图片写到接口的响应中
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
    }

    /**
     * 生成短信验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/code/sms")
    public void createSmsCode(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
        // 生成短信验证码
        ValidateCode smsCode = smsCodeGenerator.generate(new ServletWebRequest(request));
        // 将随机数存到session中
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, smsCode);
        String mobile = ServletRequestUtils.getRequiredStringParameter(request, "mobile");
        smsCodeSender.send(mobile, smsCode.getCode());
    }

    /**
     * 创建验证码，根据验证码类型不同，调用不同的 {@link ValidateCodeProcessor} 接口实现
     * @param request
     * @param response
     * @param type
     * @throws Exception
     */
    @GetMapping("/code/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
        ValidateCodeProcessors.get(type + "CodeGenerator").create(new ServletWebRequest(request, response));
    }

}
