package com.imooc.security.browser;

import com.imooc.security.browser.authentication.ImoocAuthenticationFailureHandler;
import com.imooc.security.browser.authentication.ImoocAuthenticationSuccessHandler;
import com.imooc.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author Trig
 * @create 2019-04-14 14:34
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    // 认证成功的处理器
    @Autowired
    private ImoocAuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

    // 认证失败的处理器
    @Autowired
    private ImoocAuthenticationFailureHandler imoocAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        // 自定义PasswordEncoder的逻辑
        /*return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return "password" + charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return encode(charSequence).equals(s);
            }
        };*/

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.httpBasic()
        http.formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(imoocAuthenticationSuccessHandler)
                .failureHandler(imoocAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require", securityProperties.getBrowser().getLoginPage()).permitAll()
                .anyRequest()
                .authenticated().and().csrf().disable();
    }
}
