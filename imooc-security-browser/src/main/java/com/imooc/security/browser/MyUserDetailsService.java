package com.imooc.security.browser;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Trig
 * @create 2019-05-02 12:10
 */
@Component
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登录用户名：" + username);
        // 根据用户名查找用户信息
        // return new User(username, "123456", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        String password = passwordEncoder.encode("123456");
        log.info("数据库密码是： " + password);
        return new User(username, password, true, true, true, true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
