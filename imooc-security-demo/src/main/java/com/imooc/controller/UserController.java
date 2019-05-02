package com.imooc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.dto.User;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Trig
 * @create 2019-04-12 23:04
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 获取当前认证用户的信息
     * @return
     */
    @GetMapping("/me")
    public Object getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前认证用户信息的简单写法
     * @param authentication
     * @return
     */
    @GetMapping("/me2")
    public Object getCurrentUser2(Authentication authentication) {
        return authentication;
    }

    /**
     * 只返回和用户相关的信息user
     * @param userDetails
     * @return
     */
    @GetMapping("/me3")
    public Object getCurrentUser3(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }

    @RequestMapping
    public List<User> query() {
        // System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

}
